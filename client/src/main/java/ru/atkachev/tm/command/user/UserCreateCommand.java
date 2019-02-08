package ru.atkachev.tm.command.user;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class UserCreateCommand extends AbstractCommand {

    private boolean secure = false;

    public UserCreateCommand(IServiceLocator serviceLocate){
        super(serviceLocate);
    }

    public String command() {
        return "u r";
    }

    public void execute() {
//
//        System.out.println("enter user login");
//        final String login = serviceLocate.getTerminalService();
//        System.out.println("enter user first name");
//        final String firstName = serviceLocate.getTerminalService();
//        System.out.println("enter user last name");
//        final String lastName = serviceLocate.getTerminalService();
//        System.out.println("enter user password");
//        final String password = serviceLocate.getTerminalService();
//        serviceLocate.getUserService().createUser(login, firstName, lastName, password);
    }

    public String description() {
        return "Register user";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
