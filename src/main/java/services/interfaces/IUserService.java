package services.interfaces;

import entities.Book;
import entities.User;

import java.util.List;

public interface IUserService {
    User getUserById(int id);
    boolean create(User user);
    User getUserByIdWithBooks(int id);
    List<User> getAllUsers();
    List<User> getUsersWithSame(int id);
    boolean removeUserById(int id);
}