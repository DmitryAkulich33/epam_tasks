package by.epam.bakery.controller.command.impl.courier;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandResult;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourierOrderIncreasePageCommand implements Command {
    private static final String ORDER_PRODUCTS = "orderProducts";
    private static final String PAGE = "page";
    private static final String COUNT = "count";
    private static final int AMOUNT = 5;
    private static Logger log = LogManager.getLogger(CourierOrderIncreasePageCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        log.debug("Page number increase for orders started.");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        int currentPage = Integer.parseInt(request.getParameter(PAGE));
        int increasePage = currentPage + 1;
        int count = Integer.parseInt(request.getParameter(COUNT));
        List<OrderProduct> orderProducts;
        if (increasePage <= count) {
            try {
                orderProducts = serviceFactory.getOrderProductService().findLimitOrderProduct((increasePage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(ORDER_PRODUCTS, orderProducts);
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
            request.setAttribute(PAGE, increasePage);
        } else {
            try {
                orderProducts= serviceFactory.getOrderProductService().findLimitOrderProduct((currentPage - 1) * AMOUNT, AMOUNT);
                request.setAttribute(ORDER_PRODUCTS, orderProducts);
            } catch (ServiceException e) {
                log.error(this.getClass() + ":" + e.getMessage());
                return CommandResult.forward("/WEB-INF/jsp/common/error.jsp");
            }
            request.setAttribute(PAGE, currentPage);
        }
        request.setAttribute(COUNT, count);
        log.debug("Page number increase for orders finished.");
        return CommandResult.forward("/WEB-INF/jsp/courier/courier_order.jsp");
    }
}
