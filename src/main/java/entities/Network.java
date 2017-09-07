package entities;

/**
 * Created by SBT-Smirnov-VA on 07.09.2017.
 */
public class Network {

    private Long id;
    private String type;
    private String vkAccessToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVkAccessToken() {
        return vkAccessToken;
    }

    public void setVkAccessToken(String vkAccessToken) {
        this.vkAccessToken = vkAccessToken;
    }
}
