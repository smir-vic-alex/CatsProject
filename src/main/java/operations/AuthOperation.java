package operations;

import exeptions.access.AccessLoginFailedException;

/**
 * Created by SBT-Smirnov-VA on 20.07.2017.
 */
public class AuthOperation extends Operation {

    private static final AuthService AUTH_SERVICE = new AuthService();

    public void initialize(String login, String password) throws AccessLoginFailedException
    {
        Login userLogin = AUTH_SERVICE.findByLogin(login);
        if (userLogin != null)
        {
            Password userPassword = AUTH_SERVICE.findPasswordByLogin(userLogin, password);
//            if (userPassword.getPassword().equals(password))
//            {
                return;
//            }
//            throw new AccessLoginFailedException();
        }

        throw new AccessLoginFailedException();
    }

}
