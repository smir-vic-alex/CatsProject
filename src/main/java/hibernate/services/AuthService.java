package hibernate.services;

import hibernate.BusinessService;
import entities.Login;
import hibernate.HibernateExecutor;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

/**
 * Created by SBT-Smirnov-VA on 20.07.2017.
 */
public class AuthService extends BusinessService {

    public Login findByLogin(final String login) {
        return new HibernateExecutor<Login>().execute((session) ->
                {
                    try {
                        Query<Login> query = session.createNamedQuery("entities.Login.get.login.by.login", Login.class);
                        query.setParameter("login", login);
                        return query.getSingleResult();
                    } catch (NoResultException e) {
                        return null;
                    }
                }
        );
    }
}
