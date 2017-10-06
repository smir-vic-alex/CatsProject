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
public class NetworksService extends BusinessService<Network> {

    public VKUserNetwork saveOrUpdateVkNetworkCode(final Long userId, final UserAuthResponse response)
    {
        return new HibernateExecutor<VKUserNetwork>().execute((session)->
        {
            VKUserNetwork vkUserNetwork = new VKUserNetwork();
            vkUserNetwork.setVkAccessCode(response.getAccessToken());
            vkUserNetwork.setVkUserId(response.getUserId());
            vkUserNetwork.setUserId(userId);
            //TODO спрятать тип в Network
            vkUserNetwork.setType("VK");
            session.saveOrUpdate(vkUserNetwork);
            return vkUserNetwork;
        });
    }

    public <T extends Network> T getVKNetworkByUserId(final Long userId, final Class<T> clazz)
    {
        return new HibernateExecutor<T>().execute((session) ->
        {
            try
            {
                Query<T> query = session.createNamedQuery("entities.get.network.by.user.id", clazz);
                query.setParameter("userId", userId);
                query.setParameter("type", getVkType(clazz));
                return query.getSingleResult();
            }
            catch (Exception e) {
                return null;
            }
        });
    }

    private static <T extends Network>String getVkType(Class<T> clazz) throws Exception {
        if (VKUserNetwork.class == clazz)
            return "VK";
        else if (VKGroupNetwork.class == clazz)
            return "VKG";
        throw new Exception();
    }


    //TODO не происходит апдейт записи
    public VKGroupNetwork saveOrUpdateVkGroupsNetworkCode(final Long userId, final GroupAuthResponse response)
    {
        return new HibernateExecutor<VKGroupNetwork>().execute((session)->
        {
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
