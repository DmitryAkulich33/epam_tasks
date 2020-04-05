package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.Order;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseOrderStatusCommand implements Command {
    private static final String STATUS = "status";
    private static final String ORDERS = "orders";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String status = request.getParameter(STATUS);
        List<Order> orders;
        try {
            orders = serviceFactory.getOrderService().findOrderByStatus(status);
            request.setAttribute(ORDERS, orders);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return CommandResult.forward("/WEB-INF/jsp/admin_order.jsp");
    }
}