package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Session;

import java.util.HashMap;
import java.util.Map;

public class SessionRepository {
    final private Map<String, Session> sessionMap = new HashMap<>();

    public Session sessionStart(final String userId){
        final Session session = new Session(userId);
        sessionMap.put(session.getId(), session);
        return session;
    }
}
