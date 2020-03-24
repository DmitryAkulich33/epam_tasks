package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePieCommand implements Command {
    private static final String DEL_ID = "delId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int pieId = Integer.parseInt(request.getParameter(DEL_ID));
        try {
            serviceFactory.getPieService().deletePie(pieId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.redirect(request.getContextPath() + "controller?command=admin_pies");
    }
}
