package actions.vk;

import actionForms.CodeVKActionForm;
import com.vk.api.sdk.objects.UserAuthResponse;
import entities.User;
import hibernate.services.NetworksService;
import networks.vk.clients.VKUser;
import networks.vk.connectors.VKConnectorFactory;
import networks.vk.connectors.VKConnectorType;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SBT-Smirnov-VA on 21.07.2017.
 */
public class CodeVKAction extends VKAction {

    private static final NetworksService networkService = new NetworksService();

    @Override
    public ActionForward start (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        CodeVKActionForm codeVKActionForm = (CodeVKActionForm) form;
        User user = (User) WebContext.getCurrentRequest().getSession(false).getAttribute("user");
        UserAuthResponse authResponse = (UserAuthResponse) VKConnectorFactory.getConnector(VKConnectorType.USER).auth(codeVKActionForm.getCode());
        networkService.saveOrUpdateVkNetworkCode( user.getId(), authResponse.getAccessToken());

        return mapping.findForward("success");
    }
}
