package by.epam.bakery.service.api;

import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface OrderProductService {
    void save(int orderId, int pieId) throws ServiceException;
    List<OrderProduct> findByUserId(int userId) throws ServiceException;
}
