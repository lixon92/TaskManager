package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.repository.SessionRepository;
import ru.atkachev.tm.repository.UserRepository;

public class SessionService {
    final private SessionRepository sessionRepository;
    final private UserRepository userRepository;

    public SessionService( SessionRepository sessionRepository, UserRepository userRepository){
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    public Session sessionStart(String login, String password) {
        final String userId = userRepository.getUserId(login, password);
        return sessionRepository.sessionStart(userId);
    }
}
