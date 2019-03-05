package ru.atkachev.tm.service;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.SessionRepository;
import ru.atkachev.tm.repository.UserRepository;
import javax.persistence.EntityManager;
import java.io.IOException;

public class SessionService {

    final private IServiceLocator serviceLocator;

    public SessionService(IServiceLocator serviceLocator){
        this.serviceLocator = serviceLocator;
    }

    private EntityManager createEntityManager(){
        return serviceLocator.getEntityManagerFactory().createEntityManager();
    }
    private SessionRepository getSessionRepository(){
        return new SessionRepository(createEntityManager());
    }
    private UserRepository getUserRepository(){
        return new UserRepository(createEntityManager());
    }

    public Session sessionStart(final String login, final String password) throws IOException {
        final SessionRepository sessionRepository = getSessionRepository();
        final UserRepository userRepository = getUserRepository();

        userRepository.begin();
        final User user = userRepository.getUserByLogin(login);
        userRepository.commit();
        userRepository.close();
        if(!user.getPassword().equals(password)) throw new IOException();

        sessionRepository.begin();
        final Session session = sessionRepository.sessionStart(user);
        sessionRepository.commit();
        sessionRepository.close();

        return session;
    }

    public void sessionClose(Session session){
        final SessionRepository repository = getSessionRepository();

        repository.begin();
        repository.sessionClose(session);
        repository.commit();
        repository.close();

    }

}
