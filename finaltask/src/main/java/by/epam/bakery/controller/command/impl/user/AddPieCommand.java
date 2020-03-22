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
    private static final String USER = "user";
//    private static final String PIE_NAME = "pieName";
//    private static final String PIE_PRICE = "piePrice";
//    private static final String PIE_WEIGHT = "pieWeight";
//    private static final String PIE_PICTURE = "piePicture";
//    private static final String PIE_DESCRIPTION = "pieDescription";
    private static final String PIE_ID = "pieId";
    private static final String BASKET = "basket";


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
//        String pieName = request.getParameter(PIE_NAME);
//        String piePicture = request.getParameter(PIE_PICTURE);
//        String pieDescription = request.getParameter(PIE_DESCRIPTION);
//        double piePrice = Double.parseDouble(request.getParameter(PIE_PRICE));
//        int pieWeight = Integer.parseInt(request.getParameter(PIE_WEIGHT));
        int pieId = Integer.parseInt(request.getParameter(PIE_ID));
        Pie pie = null;
        try {
            pie = serviceFactory.getPieService().findPieById(pieId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute(BASKET);
        basket.getPies().add(pie);
        session.setAttribute(BASKET, basket);
        return CommandResult.redirect(request.getContextPath() + "controller?command=show_main_page");
    }
}
