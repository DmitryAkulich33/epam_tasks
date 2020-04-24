package by.epam.bakery.controller.command.impl.admin;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminOrderProductCommand implements Command {
    private static final String ORDER_PRODUCTS = "orderProducts";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<OrderProduct> orderProducts;
        int page = Integer.parseInt(request.getParameter(PAGE));
        try {
            orderProducts = serviceFactory.getOrderProductService().findLimitOrderProduct((page - 1) * AMOUNT, AMOUNT);
            request.setAttribute(ORDER_PRODUCTS, orderProducts);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        try {
            int count = serviceFactory.getOrderService().findOrderPageAmount(AMOUNT);
            request.setAttribute(COUNT, count);
        } catch (ServiceException e) {
            return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
        }
        request.setAttribute(PAGE, page);
        return CommandResult.forward("/WEB-INF/jsp/admin/admin_order_product.jsp");
    }
}
