package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    User findUserByLoginAndPassword(String login, String password) throws DaoException;
    User findUserBySurname(String surname) throws DaoException;
    void changeNote(String note, int userId) throws DaoException;
    List<User> getAllClients() throws DaoException;
}
