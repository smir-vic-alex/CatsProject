package actions;

import actionForms.RegisterActionForm;
import operations.AuthService;
import operations.Login;
import operations.Password;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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

        if (authService.findByLogin(registerActionForm.getLogin()) == null){
            authService.saveOrUpdate(new Login());
            authService.saveOrUpdate(new Password());
        }
        return mapping.findForward("success");
    }
}
