package networks.vk.connectors;

import exeptions.connectors.ConnectorException;
import networks.vk.clients.VKService;

/**
 * Коннектор для сервиса
 * Created by Виктор on 28.05.2017.
 */
public class VKServiceConnector implements VKConnector<VKService> {

    @Override
    public VKService auth(String code) throws ConnectorException {
        return new VKService();
    }
}
