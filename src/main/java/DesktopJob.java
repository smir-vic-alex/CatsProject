import com.vk.api.sdk.client.actors.UserActor;
import property.PropertyService;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Smirnov Victor on 09.04.17.
 */
public class DesktopJob {

    private PrintStream out = System.out;
    private Scanner in = new Scanner(System.in);
    private PropertyService propertyService = new PropertyService();
    public void doJob(){
        try {
            Config.loadProperties();
            out.println("Desktop version VK API is running");
            out.println("Please copy this url and put in browser: ");
            out.println(VKClientConnectionHelper.connectionUrl(00000, "page", "https://oauth.vk.com/blank.html", "code", "offline", "5.60"));
            out.println("Put code");
            String code = in.nextLine();

            UserActor actor = VKClientConnectionHelper.loginUserInVK(00000, "sec_code", "https://oauth.vk.com/blank.html", code);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
//https://oauth.vk.com/authorize?client_id=5920231&display=page&redirect_uri=https://oauth.vk.com/blank.html&response_type=code&&scope=offline&v=5.60
