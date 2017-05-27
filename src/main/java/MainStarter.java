import vk.connectors.VKConnectorFactory;
import vk.connectors.VKConnectorType;

/**
 * Created by Smirnov Victor on 30.03.17.
 */
public class MainStarter {

    public static void main(String[] args){

        try {
            VKConnectorFactory.getConnector(VKConnectorType.USER).login();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
