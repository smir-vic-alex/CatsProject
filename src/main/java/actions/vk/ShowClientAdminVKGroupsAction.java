package actions.vk;

import actions.LookupDispatchAction;
import networks.vk.clients.VKUser;
import networks.vk.connectors.VKConnectorFactory;
import networks.vk.connectors.VKConnectorType;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Виктор on 15.09.2017.
 */
public class ShowClientAdminVKGroupsAction extends LookupDispatchAction {

    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        VKUser vkUser = (VKUser) VKConnectorFactory.getConnector(VKConnectorType.USER).login();


        return mapping.findForward("success");
    }
}
