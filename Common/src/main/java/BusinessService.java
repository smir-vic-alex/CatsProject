import org.hibernate.Session;

/**
 * Created by Виктор on 15.05.2017.
 */
public class BusinessService<T> {

    public void saveOrUpdate(final T object) {
        new HibernateExecutor<>().execute((session) ->
                {
                    session.saveOrUpdate(object);
                    return null;
                }
        );
    }

}
