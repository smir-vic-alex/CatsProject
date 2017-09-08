package actions;

import accesses.EncryptUtils;
import actionForms.LoginActionForm;
import entities.User;
import exeptions.access.LoginException;
import exeptions.access.LoginNotFoundException;
import hibernate.services.AuthService;
import entities.Login;
import entities.Password;
import hibernate.services.UserService;
import org.apache.struts.action.*;
import utils.StringUtils;
import utils.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SBT-Smirnov-VA on 19.07.2017.
 */
public class LoginAction extends OperationActionBase {

    private static final AuthService service = new AuthService();
    private static final UserService userService = new UserService();

    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginActionForm loginActionForm = (LoginActionForm) form;

        Login login = getLogin(loginActionForm.getLogin());
        User user = userService.getUserByLogin(login);
        checkPassword(user.getPassword(), loginActionForm.getPassword());
        sessionUpdate(user);

        return mapping.findForward("clientPage");
    }

    private void sessionUpdate(User user) {
        WebContext.getCurrentRequest().getSession(false).setAttribute("login", true);
        WebContext.getCurrentRequest().getSession(false).setAttribute("user", user);
    }

    private void checkPassword(Password password, String inputPassword) throws LoginException {
        if (!password.getHash().equals(EncryptUtils.code(inputPassword))) {
            throwLoginException();
        }
    }

    private Login getLogin(String loginName) throws LoginNotFoundException {
        if (StringUtils.isEmpty(loginName)){
            throwLoginException();
        }

        Login login = service.findByLogin(loginName);
        if (login == null) {
            throwLoginException();
        }
        return login;
    }

    private void throwLoginException() throws LoginNotFoundException {
        incrementAttemptsCount();
        throw new LoginNotFoundException();
    }

    private void incrementAttemptsCount() {
        Integer attemptsCount = (Integer) WebContext.getCurrentRequest().getSession(false).getAttribute("attemptsCount");
        if (attemptsCount == null) {
            attemptsCount = 0;
        }
        attemptsCount++;
        WebContext.getCurrentRequest().getSession(false).setAttribute("attemptsCount", attemptsCount);
    }

}
