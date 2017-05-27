package vk.connectors;

import exeptions.connectors.VKGroupConnectorException;
import vk.clients.VKGroup;

/**
 * Коннектор для группы
 * Created by Виктор on 28.05.2017.
 */
public class VKGroupConnection implements VKConnector<VKGroup> {
    @Override
    public VKGroup login() throws VKGroupConnectorException {
        return new VKGroup();
    }
}
