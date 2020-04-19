package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAddPieToOrderCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String PIE_PRICE = "piePrice";
    private static final String USER_FOR_ORDER = "userForOrder";
    private static final String PIE_AMOUNT = "pieAmount";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_FOR_ORDER);
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        double piePrice = Double.parseDouble(request.getParameter(PIE_PRICE));
        int amount = Integer.parseInt(request.getParameter(PIE_AMOUNT));
        double cost = amount * piePrice;
        Basket basket;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            double total = basket.getTotal();
            int basketId = basket.getId();
            serviceFactory.getBasketService().changeTotal((total + cost), basketId);
            serviceFactory.getBasketProductService().saveBasketProduct(basketId, pieId, amount, cost);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_add_new_order");
    }
}
