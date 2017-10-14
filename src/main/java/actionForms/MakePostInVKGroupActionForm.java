package actionForms;

import org.apache.struts.action.ActionForm;

public class MakePostInVKGroupActionForm extends ActionForm {
    private String message;
    private String groupId;
    private String typeNetwork;

    public String getTypeNetwork() {
        return typeNetwork;
    }

    public void setTypeNetwork(String typeNetwork) {
        this.typeNetwork = typeNetwork;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
