package networks.vk.clients;

/**
 * Внутреннее представление клиента как сообщество (группа)
 * Created by Виктор on 28.05.2017.
 */
public class VKGroup implements VKClient {
    private String name;
    private String urlPhoto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
