package actions.vk;

import actionForms.MakePostInVKGroupActionForm;
import com.vk.api.sdk.client.actors.UserActor;
import entities.User;
import entities.VKGroupNetwork;
import entities.VKUserNetwork;
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

public class MakePostInVKGroupAction extends VKAction
{
    private static final NetworksService networksService = new NetworksService();
    @Override
    public ActionForward start(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MakePostInVKGroupActionForm form = (MakePostInVKGroupActionForm) frm;

        VKUserConnector connector = (VKUserConnector)VKConnectorFactory.getConnector(VKConnectorType.USER);
        User user = (User) WebContext.getCurrentRequest().getSession(false).getAttribute("user");

        //TODO доделать поиск по id группы из actionForm
        VKGroupNetwork groupNetwork = (VKGroupNetwork)networksService.getNetworkByUserId(user.getId(), "VKG");
        VKUserNetwork userNetwork = (VKUserNetwork) networksService.getNetworkByUserId(user.getId(), "VK");
        connector.createPost(new UserActor(userNetwork.getVkUserId(), userNetwork.getVkAccessCode()), -groupNetwork.getVkUserId(), form.getMessage());

        return mapping.findForward("success");
    }
}
