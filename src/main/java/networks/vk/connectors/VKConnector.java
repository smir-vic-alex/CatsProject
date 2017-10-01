package networks.vk.connectors;

import exeptions.connectors.ConnectorException;

/**
 * Коннектор к networks.vk.com
 * Created by Виктор on 28.05.2017.
 */
public interface VKConnector<T> {

    /**
     * Аутентификация пользователя через код
     *
     * @return пользователь
     * @throws ConnectorException
     */
    public T auth(String code) throws ConnectorException;

}
