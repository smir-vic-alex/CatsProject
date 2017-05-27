package vk.connectors;

import exeptions.connectors.ConnectorNotFoundException;

/**
 * Фабрика коннекторов
 * Created by Виктор on 28.05.2017.
 */
public class VKConnectorFactory {

    public static VKConnector getConnector(VKConnectorType type) throws ConnectorNotFoundException{
        switch (type){
            case GROUP:
                return new VKGroupConnection();
            case USER:
                return new VKUserConnector();
            case SERVICE:
                return new VKServiceConnector();
            default:
                throw new ConnectorNotFoundException();
        }

    }
}
