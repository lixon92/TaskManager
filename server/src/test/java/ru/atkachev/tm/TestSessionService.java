package ru.atkachev.tm;

import org.junit.Test;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.bootstrap.Bootstrap;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.service.SessionService;
import ru.atkachev.tm.service.UserService;

public class TestSessionService {
    final private IServiceLocator serviceLocator = new Bootstrap();

    final private UserService userService = new UserService(serviceLocator);

    final private SessionService sessionService = new SessionService(serviceLocator);

    @Test
    public void testCreateSession() throws Exception {
        User user = userService.createUser(
                "test2",
                "name",
                "surname",
                "1234");
        Session session = sessionService.sessionStart(user.getLogin(), user.getPassword());
        System.out.println(user);
        System.out.println(session.getUser());
        System.out.println(session);
    }

    @Test
    public void testCreateSession1() throws Exception {
        User user = userService.getUserByLogin("test3");
        Session session = sessionService.sessionStart(user.getLogin(), user.getPassword());
        System.out.println(session.getUser());
        System.out.println(session);
    }

    @Test
    public void testCreateSessionClose() throws Exception {
        User user = userService.getUserByLogin("test3");
        Session session = sessionService.sessionStart(user.getLogin(), user.getPassword());
        System.out.println(session.getUser());
        System.out.println(session);
        sessionService.sessionClose(session);
    }



}
