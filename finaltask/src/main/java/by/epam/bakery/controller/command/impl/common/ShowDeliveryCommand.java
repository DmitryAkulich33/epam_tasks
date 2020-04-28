package by.epam.bakery.controller.command.impl.common;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDeliveryCommand implements Command {
    private static Logger log = LogManager.getLogger(ShowDeliveryCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("User is logged in to delivery page.");
        return CommandResult.forward("/WEB-INF/jsp/common/delivery.jsp");
    }
}
