package ru.atkachev.tm.command.user;

import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;
import ru.atkachev.tm.endpoint.SessionEndpoint;

public class UserLogonCommand extends AbstractCommand {

    public UserLogonCommand(final IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public String command() {
        return "logon";
    }

    public void execute() {

        System.out.println("enter user login");
        final String userLogin = serviceLocator.getConsoleServiceString();
        System.out.println("enter user password");
        final String userPassword = serviceLocator.getConsoleServiceString();


        final SessionEndpoint sessionEndpoint = serviceLocator.getSessionEndpoint();
            try {
            final Session session = sessionEndpoint.sessionStart(userLogin, DigestUtils.md5Hex(userPassword));
            serviceLocator.setSession(session);
        }  catch (ru.atkachev.tm.endpoint.IOException_Exception e){
            System.out.println("User not found.");
        }
    }

    public String description() {
        return "logon";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
