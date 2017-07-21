package accesses;

import operations.Login;

/**
 * Created by SBT-Smirnov-VA on 21.07.2017.
 */
public interface AuthorizationManager {
    public boolean isUserAuthorized(Login login, String uri);
}
