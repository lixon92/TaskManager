package ru.atkachev.tm.command.user;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class UserLogonCommand extends AbstractCommand {

    public UserLogonCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "logon";
    }

    public void execute() {
        System.out.println("enter user login");
        final String userLogin = serviceLocate.getConsoleServiceString();
        System.out.println("enter user password");
        final String userPassword = serviceLocate.getConsoleServiceString();
        final String userID = serviceLocate.getUserEndpoint().getUserId(userLogin, userPassword);
        serviceLocate.setSession(serviceLocate.getSessionEndpoint().sessionStart(userID));
    }

    public String description() {
        return "logon";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
