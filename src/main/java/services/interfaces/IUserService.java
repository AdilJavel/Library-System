package services.interfaces;

import entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    boolean create(User user);

    boolean delete(int id);
}