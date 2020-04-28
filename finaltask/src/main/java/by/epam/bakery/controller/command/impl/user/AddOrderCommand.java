package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.*;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddOrderCommand implements Command {
    private static final String USER = "user";
    private static final String BASKET_TOTAL = "total";
    private static final String BASKET_PRODUCT = "basketProducts";
    private static Logger log = LogManager.getLogger(AddOrderCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Adding order started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        double basketTotal = Double.parseDouble(request.getParameter(BASKET_TOTAL));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        if (basketTotal == 0) {
            return CommandResult.forward("/WEB-INF/jsp/user/basket.jsp");
        } else {
            try {
                serviceFactory.getOrderService().save(userId, basketTotal, null, null, StatusEnum.NOT_READY.getValue());
                Order order = serviceFactory.getOrderService().findLastOrderByUserId(userId);
                int orderId = order.getId();
                List<BasketProduct> basketProducts = (List<BasketProduct>) session.getAttribute(BASKET_PRODUCT);
                for(BasketProduct basketProduct: basketProducts){
                    serviceFactory.getOrderProductService().save(orderId, basketProduct.getPie().getId(), basketProduct.getAmount(), basketProduct.getCost());
                }
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
        }
        log.debug("Adding order finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=clear_basket");
    }
}
