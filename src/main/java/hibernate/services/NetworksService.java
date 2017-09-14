package hibernate.services;

import entities.Network;
import entities.VKNetwork;
import hibernate.BusinessService;
import hibernate.HibernateExecutor;
import org.hibernate.query.Query;

/**
 * Created by SBT-Smirnov-VA on 07.09.2017.
 */
public class NetworksService extends BusinessService {

    public VKNetwork saveOrUpdateVkNetworkCode(final Long userId, final String code){
        return new HibernateExecutor<VKNetwork>().execute((session)->{
            VKNetwork vkNetwork = new VKNetwork();
            vkNetwork.setVkAccessCode(code);
            vkNetwork.setUserId(userId);
            vkNetwork.setType("VK");
            session.saveOrUpdate(vkNetwork);
            return vkNetwork;
        });
    }

    public Network getNetworkByUserId(final Long userId){
        return new HibernateExecutor<Network>().execute((session) -> {
            Query<Network> query = session.createNamedQuery("entities.get.network.by.user.id", Network.class);
            query.setParameter("userId", userId);
            return query.getSingleResult();
        });
    }

}
