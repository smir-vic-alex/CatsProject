package actions.vk;

import actionForms.ShowClientAdminVKGroupActionForm;
import actions.LookupDispatchAction;
import com.vk.api.sdk.objects.groups.GroupFull;
import entities.User;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 15.09.2017.
 */
public class ShowClientAdminVKGroupsAction extends LookupDispatchAction {

    private static final NetworksService networkService = new NetworksService();

    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) WebContext.getCurrentRequest().getSession(false).getAttribute("user");
        VKUserNetwork vkUserNetwork = (VKUserNetwork)networkService.getNetworkByUserId(user.getId(), "VK");
        VKUserConnector connector = ((VKUserConnector)VKConnectorFactory.getConnector(VKConnectorType.USER));
        List<GroupFull> list =  connector.getGroups(vkUserNetwork.getVkUserId(), vkUserNetwork.getVkAccessCode());

        ShowClientAdminVKGroupActionForm actionForm = (ShowClientAdminVKGroupActionForm) form;
        actionForm.setVkGroups(convertToVKGroupList(list));

        return mapping.findForward("success");
    }

    private List<VKGroup> convertToVKGroupList(List<GroupFull> groupFulls){

        List<VKGroup> vkGroupList = new ArrayList<>(groupFulls.size());
        for (GroupFull group : groupFulls) {
            VKGroup vkGroup = new VKGroup();

            vkGroup.setId(group.getId());
            vkGroup.setName(group.getName());
            vkGroup.setUrlPhoto(group.getPhoto50());
            vkGroupList.add(vkGroup);
        }
        return vkGroupList;
    }
}
