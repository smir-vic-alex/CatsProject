import vk.connectors.VKConnectorFactory;
import vk.connectors.VKConnectorType;

/**
 * Стартер приложения
 * Created by Smirnov Victor on 30.03.17.
 */
public class MainStarter {

    public static void main(String[] args){

        try {
            VKConnectorFactory.getConnector(VKConnectorType.GROUP).login();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
