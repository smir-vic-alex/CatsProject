package property;

import org.hibernate.query.Query;
import services.BusinessService;
import services.HibernateExecutor;

/**
 * Created by Виктор on 17.05.2017.
 */
public class PropertyService extends BusinessService<Property> {

    public Property getPropetyByKey(final String key) {
        return new HibernateExecutor<Property>().execute((session) ->
                {
                    Query<Property> query = session.createQuery( "property.Property.get.by.key", Property.class);
                    query.setParameter("key", key);
                    return query.getSingleResult();
                }
        );
    }

}
