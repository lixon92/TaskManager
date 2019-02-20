package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.repository.SessionRepository;
import ru.atkachev.tm.repository.UserRepository;
import ru.atkachev.tm.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SessionService {
    final private SessionRepository sessionRepository;
    final private UserRepository userRepository;

    public SessionService(final SessionRepository sessionRepository, final UserRepository userRepository ){
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    public Session sessionStart(final String login, final String password) throws IOException {
        Connection connection = Util.getConnection();
        try {
            final String userId = userRepository.getUserId(connection, login, password);
            if (userId == null) throw new IOException();
            return sessionRepository.sessionStart(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
