package by.epam.bakery.controller.command.impl.user;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeNameCommand implements Command {
    private static final String USER = "user";
    private static final String NEW_NAME = "newName";
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";
    private static final String WRONG_NAME_MESSAGE = "The new name is wrong";
    private static final String RIGHT_NAME_MESSAGE = "The name changed";
    private static final String PAGE = "page";
    private static Logger log = LogManager.getLogger(ChangeNameCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Changing name started.");
        String page = request.getParameter(PAGE);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String newName = request.getParameter(NEW_NAME);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        int userId = user.getId();
        try {
            serviceFactory.getUserService().changeName(newName, userId);
            user.setName(newName);
            session.setAttribute(USER, user);
            session.setAttribute(RIGHT, RIGHT_NAME_MESSAGE);
        } catch (ValidatorException ex){
            log.error(this.getClass() + ":" + ex.getMessage());
            session.setAttribute(WRONG, WRONG_NAME_MESSAGE);
        } catch (ServiceException e) {
            log.error(this.getClass() + ":" + e.getMessage());
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        log.debug("Changing name finished.");
        return CommandResult.redirect(request.getContextPath() + "controller?command=personal_account&page=" + page);
    }
}
