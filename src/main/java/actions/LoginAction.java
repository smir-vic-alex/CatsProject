package actions;

import actionForms.LoginActionForm;
import exeptions.access.AccessLoginFailedException;
import operations.AuthOperation;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SBT-Smirnov-VA on 19.07.2017.
 */
public class LoginAction extends OperationActionBase {

    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginActionForm loginActionForm = (LoginActionForm) form;
        AuthOperation authOperation = new AuthOperation();

        try {
            authOperation.initialize(loginActionForm.getLogin(), loginActionForm.getPassword());
            request.getSession().setAttribute("login", "true");
        }
        catch (AccessLoginFailedException e){
            saveError(request, "Login failed");
        }

        return mapping.findForward("clientPage");
    }

}
