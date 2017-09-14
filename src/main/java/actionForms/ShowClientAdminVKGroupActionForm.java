package actionForms;

import org.apache.struts.action.ActionForm;

/**
 * Created by Виктор on 15.09.2017.
 */
public class ShowClientAdminVKGroupActionForm extends ActionForm {
    private Long group;

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }
}
