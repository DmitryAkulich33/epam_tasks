package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AdminUsersCommand implements Command {
    private static final String USERS = "users";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<User> users = null;
        try {
            users = serviceFactory.getUserService().showAllUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute(USERS, users);
        return CommandResult.forward("/WEB-INF/jsp/admin_users.jsp");
    }
}