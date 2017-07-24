package utils;

import session.Session;

/**
 * Created by SBT-Smirnov-VA on 24.07.2017.
 */
public class AuthUtils {

    private static ThreadLocal<Session> currentSession = new ThreadLocal<Session>();

    public static Session getCurrentSession(){
        return currentSession.get();
    }

    public static void setCurrentSession(Session session){
        currentSession.set(session);
    }
}
