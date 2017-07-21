package actions;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import settings.SettingFactory;
import settings.vk.VKApiUserSetting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SBT-Smirnov-VA on 21.07.2017.
 */
public class VKRedirectAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = new ActionForward();
        forward.setPath(SettingFactory.getSetting(VKApiUserSetting.class).getAuthUrl());
        forward.setRedirect(true);
        return forward;
    }
}
