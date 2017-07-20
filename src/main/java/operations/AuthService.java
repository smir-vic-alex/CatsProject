package operations;

import hibernate.BusinessService;

/**
 * Created by SBT-Smirnov-VA on 20.07.2017.
 */
public class AuthService extends BusinessService {

    public Login findByLogin(String login){
        return new Login();
    }

    public Password findPasswordByLogin(Login login, String password){
        return new Password();
    }

}
