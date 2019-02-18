package ru.atkachev.tm.command.helper;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class HelpCommand extends AbstractCommand {

    public HelpCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public void execute(){
       for( final AbstractCommand command : serviceLocator.getCommandList() ) {
           System.out.printf("%-10s %-10s%n", command.command(), command.description());
       }
    }

    @Override
    public String description() {
        return "Help";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
