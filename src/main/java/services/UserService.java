package services;

import entities.Book;
import entities.User;
import repositories.interfaces.IUserRepository;
import services.interfaces.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService implements IUserService {
    @Inject
    private IUserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        return users;
    }
    public List<User> getUsersWithSame(int id) {
        List<User> users = userRepository.getUsersWithSame(id);
        return users;
    }
    public boolean removeUserById(int id) {
        boolean deleted = userRepository.removeUserById(id);
        return deleted;
    }
    @Override
    public boolean create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByIdWithBooks(int id) {
        return userRepository.getUserByIdWithBooks(id);
    }
}