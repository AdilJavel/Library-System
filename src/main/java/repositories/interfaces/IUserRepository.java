package repositories.interfaces;

import libs.LoginLib;
import entities.User;

import java.util.List;

public interface IUserRepository{

    User getUserByLogin(String username, String password);
    User getUserByUsername(String issuer);
    boolean create(User user);
    List<User> getAllUsers();
    boolean delete(int id);
}