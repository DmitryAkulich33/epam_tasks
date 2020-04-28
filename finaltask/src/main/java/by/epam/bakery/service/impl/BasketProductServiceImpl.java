package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.BasketProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.service.api.BasketProductService;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.validator.PieDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BasketProductServiceImpl implements BasketProductService {
    private static Logger log = LogManager.getLogger(BasketProductServiceImpl.class.getName());
    private DaoHelperFactory daoHelperFactory;
    private PieDataValidator pieDataValidator = new PieDataValidator();

    public BasketProductServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void saveBasketProduct(int basketId, int pieId, String amount, double price) throws ServiceException, ValidatorException {
        log.debug("Service: saving basket product started.");
        if (!pieDataValidator.isPieAmountValid(amount)) {
            log.error("The number of pies is wrong");
            throw new ValidatorException("The number of pies is wrong");
        }
        int pieAmount = Integer.parseInt(amount);
        double cost = pieAmount * price;
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            dao.save(basketId, pieId, amount, cost);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: saving basket product finished.");
    }

    @Override
    public void deleteBasketProductByBasketId(int basketId) throws ServiceException {
        log.debug("Service: deleting basket product by basket id started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            dao.removeByBasketId(basketId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting basket product by basket id finished.");
    }

    @Override
    public void deleteBasketProductById(int basketProductId) throws ServiceException {
        log.debug("Service: deleting basket product by id started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            dao.removeById(basketProductId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting basket product by id finished.");
    }

    @Override
    public List<BasketProduct> findProductByBasketId(int basketId) throws ServiceException {
        log.debug("Service: search product by basket id.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            return dao.findByBasketId(basketId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
