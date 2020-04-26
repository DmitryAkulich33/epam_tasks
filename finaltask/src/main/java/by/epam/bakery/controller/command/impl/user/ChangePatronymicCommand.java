package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePatronymicCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_PATRONYMIC = "newPatronymic";
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";
    private static final String WRONG_PATRONYMIC_MESSAGE = "The new patronymic is wrong";
    private static final String RIGHT_PATRONYMIC_MESSAGE = "The patronymic changed";
    private static final String PAGE = "page";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter(PAGE);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newPatronymic = request.getParameter(NEW_PATRONYMIC);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changePatronymic(newPatronymic, userId);
            user.setPatronymic(newPatronymic);
            session.setAttribute(USER, user);
            session.setAttribute(RIGHT, RIGHT_PATRONYMIC_MESSAGE);
        } catch (ValidatorException ex){
            session.setAttribute(WRONG, WRONG_PATRONYMIC_MESSAGE);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=personal_account&page=" + page);
    }
}

