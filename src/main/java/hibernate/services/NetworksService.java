package hibernate.services;

import entities.VKNetwork;
import hibernate.BusinessService;
import hibernate.HibernateExecutor;

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

}
