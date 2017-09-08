package actions;

import accesses.EncryptUtils;
import actionForms.RegisterActionForm;
import entities.User;
import hibernate.HibernateAction;
import hibernate.HibernateExecutor;
import hibernate.services.AuthService;
import entities.Login;
import entities.Password;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SBT-Smirnov-VA on 25.07.2017.
 */
public class RegisterAction extends LookupDispatchAction {

    private static final AuthService authService = new AuthService();
    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RegisterActionForm registerActionForm = (RegisterActionForm) form;

        if (!StringUtils.isNotEmpty(registerActionForm.getLogin(), registerActionForm.getPassword())){
            return mapping.findForward("register");
        }

        if (authService.findByLogin(registerActionForm.getLogin()) == null){
            authService.saveOrUpdate(registerActionForm.getLogin());
            authService.saveOrUpdate(registerActionForm.getPassword());
        }
        return mapping.findForward("success");
    }

    private User createNewUser(final String lgn, final String passwd){

        try {
            return new HibernateExecutor<User>().execute((session) ->
                {
                    Login login = new Login();
                    login.setLogin(lgn);

                    Password password = new Password();
                    password.setHash(EncryptUtils.code(passwd));

                    User newUser = new User();
                    newUser.setLogin(login);
                    newUser.setPassword(password);

                    session.saveOrUpdate(newUser);
                    return null;
                }
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
