package networks.vk.clients;

import accesses.Access;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.UserAuthResponse;

import java.util.List;

/**
 * Внутреннее представление пользователя
 * Created by Виктор on 28.05.2017.
 */
public class VKUser implements VKClient{
    private Long id;
    private List<Access> accesses;
    private UserActor userActor;
    private UserAuthResponse resources;

    public VKUser(UserActor userActor) {
        this.userActor = userActor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Access> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<Access> accesses) {
        this.accesses = accesses;
    }

    public UserActor getUserActor() {
        return userActor;
    }

    public void setUserActor(UserActor userActor) {
        this.userActor = userActor;
    }

    public UserAuthResponse getResources() {
        return resources;
    }

    public void setResources(UserAuthResponse resources) {
        this.resources = resources;
    }
}
