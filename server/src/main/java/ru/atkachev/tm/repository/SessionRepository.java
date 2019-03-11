package ru.atkachev.tm.repository;

import lombok.NoArgsConstructor;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class SessionRepository {

    private EntityManager em;

    public SessionRepository(EntityManager em){
        this.em = em;
    }

    public void begin(){
        em.getTransaction().begin();
    }

    public void commit(){
        em.getTransaction().commit();
    }

    public void close(){
        em.close();
    }

    public Session sessionStart(final User user){
        final Session session = new Session(user);
        em.merge(session);
        return session;
    }

    public void sessionClose(final Session session){
        em.remove(em.find(Session.class, session));
    }

}
