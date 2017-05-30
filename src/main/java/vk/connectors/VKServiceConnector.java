package vk.connectors;

import exeptions.connectors.ConnectorException;
import vk.clients.VKService;

/**
 * Коннектор для сервиса
 * Created by Виктор on 28.05.2017.
 */
public class VKServiceConnector implements VKConnector<VKService> {

    @Override
    public VKService login() throws ConnectorException {
        return new VKService();
    }
}
