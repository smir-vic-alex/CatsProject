package actions.vk;

import actions.LookupDispatchAction;
import entities.User;
import entities.VKNetwork;
import hibernate.services.NetworksService;
import networks.vk.connectors.VKConnectorFactory;
import networks.vk.connectors.VKConnectorType;
import networks.vk.connectors.VKUserConnector;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import utils.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Виктор on 15.09.2017.
 */
public class ShowClientAdminVKGroupsAction extends LookupDispatchAction {

    private static final NetworksService networkService = new NetworksService();

    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) WebContext.getCurrentRequest().getSession(false).getAttribute("user");
        String token = ((VKNetwork)networkService.getNetworkByUserId(user.getId())).getVkAccessCode();
        ((VKUserConnector)VKConnectorFactory.getConnector(VKConnectorType.USER)).getGroups(token);
        return mapping.findForward("success");
    }
}
