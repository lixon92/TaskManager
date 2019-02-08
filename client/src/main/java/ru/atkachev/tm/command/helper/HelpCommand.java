package ru.atkachev.tm.command.helper;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelpCommand extends AbstractCommand {
//    final private Map<String, AbstractCommand> commands = serviceLocate.getCommandList();
//    final private List<String> keys = new ArrayList<>(commands.keySet());

    public HelpCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public void execute() {
//
//       for(int i = 0; i < keys.size(); i++) {
//           String key = keys.get(i);
//           String description = commands.get(key).description();
//           System.out.printf("%-10s %-10s%n", key, description);
//       }
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
