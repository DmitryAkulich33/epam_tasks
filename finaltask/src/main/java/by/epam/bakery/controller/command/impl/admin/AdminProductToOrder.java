package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.*;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminProductToOrder implements Command {
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final double TOTAL = 0.0;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_FOR_ORDER);
        int userId = user.getId();
        Basket basket;
        double total = 0.0;
        int basketId = 0;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            basketId = basket.getId();
            total = basket.getTotal();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if (total == 0) {
            return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
        } else {
            try {
                serviceFactory.getOrderService().save(userId, total, null, null, StatusEnum.NOT_READY.getValue());
                Order order = serviceFactory.getOrderService().findLastOrderByUserId(userId);
                int orderId = order.getId();
                List<Pie> pies = serviceFactory.getPieService().findPieByBasketId(basketId);
                for(Pie pie: pies){
                    serviceFactory.getOrderProductService().save(orderId, pie.getId());
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        try {
            serviceFactory.getBasketService().changeTotal(TOTAL, basketId);
            serviceFactory.getBasketProductService().deleteBasketProductByBasketId(basketId);
            session.removeAttribute(USER_FOR_ORDER);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_order");
    }
}