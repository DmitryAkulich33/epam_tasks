package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminUsersDecreasePageCommand implements Command {
    private static final String USERS = "users";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 3;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int decreasePage = currentPage - 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<User> users;
        if (decreasePage >= 1) {
            try {
                users = serviceFactory.getUserService().findLimitUser((decreasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(USERS, users);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, decreasePage);
        } else {
            try {
                users = serviceFactory.getUserService().findLimitUser((currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(USERS, users);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        return CommandResult.forward("/WEB-INF/jsp/admin_users.jsp");
    }
}
