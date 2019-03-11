package ru.atkachev.tm.command.user;

import org.apache.commons.codec.digest.DigestUtils;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class UserCreateCommand extends AbstractCommand {

    public UserCreateCommand(final IServiceLocator serviceLocate){
        super(serviceLocate);
    }

    public String command() {
        return "u r";
    }

    public void execute() {

        System.out.println("enter user login");
        final String login = serviceLocator.getConsoleServiceString();
        System.out.println("enter user first name");
        final String firstName = serviceLocator.getConsoleServiceString();
//        System.out.println("enter user last name");
//        final String lastName = serviceLocator.getConsoleServiceString();
        System.out.println("enter user password");
        final String password = serviceLocator.getConsoleServiceString();
        serviceLocator.getUserEndpoint().createUser(login, firstName, "4", DigestUtils.md5Hex(password));
    }

    @Override
    public String description() {
        return "Register user";
    }

    @Override
    public boolean isSecure() {
        return false;
    }

}
