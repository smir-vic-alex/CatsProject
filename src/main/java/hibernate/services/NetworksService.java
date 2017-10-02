package hibernate.services;

import com.vk.api.sdk.objects.GroupAuthResponse;
import com.vk.api.sdk.objects.UserAuthResponse;
import entities.Network;
import entities.VKGroupNetwork;
import entities.VKUserNetwork;
import hibernate.BusinessService;
import hibernate.HibernateExecutor;
import org.hibernate.query.Query;

import java.util.Map;

/**
 * Created by SBT-Smirnov-VA on 07.09.2017.
 */
public class NetworksService extends BusinessService {

    public VKUserNetwork saveOrUpdateVkNetworkCode(final Long userId, final UserAuthResponse response){
        return new HibernateExecutor<VKUserNetwork>().execute((session)->{
            VKUserNetwork vkUserNetwork = new VKUserNetwork();
            vkUserNetwork.setVkAccessCode(response.getAccessToken());
            vkUserNetwork.setVkUserId(response.getUserId());
            vkUserNetwork.setUserId(userId);
            vkUserNetwork.setType("VK");
            session.saveOrUpdate(vkUserNetwork);
            return vkUserNetwork;
        });
    }

    public Network getNetworkByUserId(final Long userId, final String type){
        return new HibernateExecutor<Network>().execute((session) -> {
            Query<Network> query = session.createNamedQuery("entities.get.network.by.user.id", Network.class);
            query.setParameter("userId", userId);
            query.setParameter("type", type);
            return query.getSingleResult();
        });
    }
    //TODO не происходит апдейт записи
    public VKGroupNetwork saveOrUpdateVkGroupsNetworkCode(final Long userId, final GroupAuthResponse response){
        return new HibernateExecutor<VKGroupNetwork>().execute((session)->{
            for (Map.Entry<Integer, String> entry : response.getAccessTokens().entrySet())
            {
                VKGroupNetwork vkGroupNetwork = new VKGroupNetwork();
                vkGroupNetwork.setVkAccessCode(entry.getValue());
                vkGroupNetwork.setVkUserId(entry.getKey());
                vkGroupNetwork.setUserId(userId);
                vkGroupNetwork.setType("VKG");
                session.saveOrUpdate(vkGroupNetwork);
            }
            return null;
        });
    }

}
