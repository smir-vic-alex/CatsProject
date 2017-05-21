import com.vk.api.sdk.client.actors.UserActor;
import vk.VKClientConnectionHelper;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Smirnov Victor on 09.04.17.
 */
public class DesktopJob {

    private PrintStream out = System.out;
    private Scanner in = new Scanner(System.in);
    public void doJob(){
        try {
            out.println(VKClientConnectionHelper.initialize());
            out.println("Put code");
            String code = in.nextLine();

            UserActor actor = VKClientConnectionHelper.loginUserInVK(code);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
