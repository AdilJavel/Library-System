package services;

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

    @Override
    public boolean create(User user) {
        return userRepository.create(user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }
}