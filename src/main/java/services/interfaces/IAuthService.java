package services.interfaces;

import libs.AccessToken;
import libs.LoginLib;
import entities.User;

public interface IAuthService {
    AccessToken authenticateUser(LoginLib data) throws Exception;

    User getUserByUsername(String issuer);
}