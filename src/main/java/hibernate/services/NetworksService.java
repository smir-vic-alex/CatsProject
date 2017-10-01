package hibernate.services;

import com.vk.api.sdk.objects.GroupAuthResponse;
import com.vk.api.sdk.objects.UserAuthResponse;
import entities.Network;
import entities.VKGroupNetwork;
import entities.VKUserNetwork;
import hibernate.BusinessService;
import hibernate.HibernateExecutor;
import org.hibernate.query.Query;

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

    public Network getNetworkByUserId(final Long userId){
        return new HibernateExecutor<Network>().execute((session) -> {
            Query<Network> query = session.createNamedQuery("entities.get.network.by.user.id", Network.class);
            query.setParameter("userId", userId);
            return query.getSingleResult();
        });
    }

    //TODO не сохранились vkUserId и vkAccessCode
    public VKGroupNetwork saveOrUpdateVkGroupNetworkCode(final Long userId, final GroupAuthResponse response){
        return new HibernateExecutor<VKGroupNetwork>().execute((session)->{
            VKGroupNetwork vkGroupNetwork = new VKGroupNetwork();
            vkGroupNetwork.setVkAccessCode(response.getAccessTokens().get(0));
            vkGroupNetwork.setVkUserId(response.getAccessTokens().keySet().toArray(new Integer[1])[0]);
            vkGroupNetwork.setUserId(userId);
            vkGroupNetwork.setType("VKG");
            session.saveOrUpdate(vkGroupNetwork);
            return vkGroupNetwork;
        });
    }

}
