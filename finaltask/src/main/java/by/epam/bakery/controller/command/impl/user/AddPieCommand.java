package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPieCommand implements Command {
    private static final String PIE_ID = "pieId";
    private static final String PIE_PRICE = "piePrice";
    private static final String BASKET = "basket";
    private static final String USER = "user";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        double piePrice = Double.parseDouble(request.getParameter(PIE_PRICE));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        Basket basket = null;
        double total = 0.0;
        try {
            basket = serviceFactory.getBasketService().findBasketByUserLogin(user.getLogin());
            total = basket.getTotal();
            serviceFactory.getBasketService().changeTotal((total + piePrice), basket.getId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

//        try {
//            serviceFactory.getBasketService().saveBasket(user.getId(), piePrice);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        Pie pie = null;
//        try {
//            pie = serviceFactory.getPieService().findPieById(pieId);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        HttpSession session = request.getSession();
//        Basket basket = (Basket) session.getAttribute(BASKET);
//        basket.getPies().add(pie);
//        double total = 0.0;
//        try {
//            total = serviceFactory.getBasketService().getTotal(basket);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//        session.setAttribute(TOTAL, total);
//        session.setAttribute(BASKET, basket);
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_main_page");
    }
}
