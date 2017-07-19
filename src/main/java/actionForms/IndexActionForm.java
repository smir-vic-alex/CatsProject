package actionForms;

import org.apache.struts.action.ActionForm;

/**
 * Created by SBT-Smirnov-VA on 19.07.2017.
 */
public class IndexActionForm extends ActionForm {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
