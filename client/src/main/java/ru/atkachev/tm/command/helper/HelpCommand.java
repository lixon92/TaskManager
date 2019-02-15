package ru.atkachev.tm.command.helper;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelpCommand extends AbstractCommand {
//    final private Map<String, AbstractCommand> commands = serviceLocator.getCommandList();
//    final private List<String> keys = new ArrayList<>(commands.keySet());

    public HelpCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public void execute(){
       for( AbstractCommand command : serviceLocator.getCommandList() ) {
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
