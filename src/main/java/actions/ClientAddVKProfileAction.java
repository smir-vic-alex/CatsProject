package actions;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import settings.SettingFactory;
import settings.vk.VKApiUserSetting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SBT-Smirnov-VA on 20.07.2017.
 */
public class ClientAddVKProfileAction extends OperationActionBase {

    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try{
           return new ActionForward(SettingFactory.getSetting(VKApiUserSetting.class).getAuthUrl(), true);
        }
        catch (Exception e) {
            return mapping.findForward("error");
        }
    }
}
