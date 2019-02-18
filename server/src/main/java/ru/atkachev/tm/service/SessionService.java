package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.repository.SessionRepository;
import ru.atkachev.tm.repository.UserRepository;

import java.io.IOException;

public class SessionService {
    final private SessionRepository sessionRepository;
    final private UserRepository userRepository;

    public SessionService(final SessionRepository sessionRepository, final UserRepository userRepository ){
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    public Session sessionStart(final String login, final String password) throws IOException {
        final String userId = userRepository.getUserId(login, password);
        if (userId == null) throw new IOException();
        return sessionRepository.sessionStart(userId);
    }
}
