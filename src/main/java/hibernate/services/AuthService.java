package hibernate.services;

import hibernate.BusinessService;
import entities.Login;
import entities.Password;

/**
 * Created by SBT-Smirnov-VA on 20.07.2017.
 */
public class AuthService extends BusinessService {

    public Login findByLogin(String login) {
        return new Login();
    }

    public Password findPasswordByLogin(Login login) {
        return new Password();
    }

}
