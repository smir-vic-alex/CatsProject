package vk.clients;

import accesses.Access;
import com.vk.api.sdk.client.actors.GroupActor;

import java.util.List;

/**
 * Внутреннее представление клиента как сообщество (группа)
 * Created by Виктор on 28.05.2017.
 */
public class VKGroup implements VKClient{
    private Long id;
    private List<Access> accesses;
    private GroupActor groupActor;

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

    public GroupActor getGroupActor() {
        return groupActor;
    }

    public void setGroupActor(GroupActor groupActor) {
        this.groupActor = groupActor;
    }
}
