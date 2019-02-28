package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class SessionRepository {

    final private Map<String, Session> sessionMap = new HashMap<>();
    final private EntityManager em = Persistence.createEntityManagerFactory("ConnectDB").createEntityManager();

    public Session sessionStart(final String userId){
        final Session session = new Session(userId);
        sessionMap.put(session.getId(), session);
        em.getTransaction().begin();
        em.merge(session);
        em.getTransaction().commit();
        return session;
    }

    public Session sessionStart(final User user){
        final Session session = new Session(user);
        sessionMap.put(session.getId(), session);
        em.getTransaction().begin();
        em.merge(session);
        em.getTransaction().commit();
        return session;
    }

}
