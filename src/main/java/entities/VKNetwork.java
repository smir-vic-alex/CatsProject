package entities;

/**
 * Created by SBT-Smirnov-VA on 07.09.2017.
 */
public class VKNetwork extends Network
{
    private String vkAccessToken;

    public String getVkAccessToken() {
        return vkAccessToken;
    }

    public void setVkAccessToken(String vkAccessToken) {
        this.vkAccessToken = vkAccessToken;
    }
}
