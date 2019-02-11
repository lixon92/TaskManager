package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.repository.SessionRepository;

public class SessionService {
    final private SessionRepository sessionRepository;

    public SessionService( SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public Session sessionStart(String userId) {
        return sessionRepository.sessionStart(userId);
    }
}
