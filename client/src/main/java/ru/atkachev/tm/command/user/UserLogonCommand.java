package ru.atkachev.tm.command.user;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;

public class UserLogonCommand extends AbstractCommand {

    public UserLogonCommand(IServiceLocator serviceLocator) {
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

        final Session session = serviceLocator.getSessionEndpoint().sessionStart(userLogin, userPassword);
        serviceLocator.setSession(session);
    }

    public String description() {
        return "logon";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
