package networks.vk.connectors;

import exeptions.connectors.ConnectorException;
import networks.vk.clients.VKClient;

/**
 * Коннектор к networks.vk.com
 * Created by Виктор on 28.05.2017.
 */
public interface VKConnector<T extends VKClient> {

    /**
     * Залогиниться пользователем
     * @return пользователь
     * @throws ConnectorException
     */
    public T login() throws ConnectorException;

}
