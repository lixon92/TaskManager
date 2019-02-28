package ru.atkachev.tm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.SessionRepository;
import ru.atkachev.tm.repository.UserRepository;
import ru.atkachev.tm.service.SessionService;
import ru.atkachev.tm.service.UserService;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    UserRepository userRepository = new UserRepository();
    UserService userService = new UserService(userRepository);

    SessionRepository sessionRepository = new SessionRepository();
    SessionService sessionService = new SessionService(sessionRepository, userRepository);

    @Test
    public void testSaveUser() throws Exception {
        //Создаем автомобиль для записи в БД
        userService.createUser("login", "name", "surname", "1234");
    }

    @Test
    public void testSaveSession() throws Exception {

        User user = userService.createUser("login", "name", "1234");
        sessionRepository.sessionStart(user);

    }

}
