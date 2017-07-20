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
public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginActionForm loginActionForm = (LoginActionForm) form;
        AuthOperation authOperation = new AuthOperation();

        try {
            authOperation.initialize(loginActionForm.getLogin(), loginActionForm.getPassword());
        }
        catch (AccessLoginFailedException e){
            saveError(request, "Login failed");
        }

        return mapping.findForward("clientPage");
    }

    private void saveError(HttpServletRequest request, String error)
    {
        ActionMessages msgs = new ActionMessages();
        ActionMessage msg = new ActionMessage(error, false);
        msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
        saveErrors(request, msgs);
    }
}
