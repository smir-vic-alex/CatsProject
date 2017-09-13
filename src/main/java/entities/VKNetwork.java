package entities;

/**
 * Created by SBT-Smirnov-VA on 07.09.2017.
 */
public class VKNetwork extends Network
{
    private String vkAccessCode;

    public String getVkAccessCode() {
        return vkAccessCode;
    }

    public void setVkAccessCode(String vkAccessToken) {
        this.vkAccessCode = vkAccessToken;
    }
}
