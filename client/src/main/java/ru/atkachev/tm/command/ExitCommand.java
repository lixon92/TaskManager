package ru.atkachev.tm.command;

import ru.atkachev.tm.api.IServiceLocator;

public class ExitCommand extends AbstractCommand {
    public ExitCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String description() {
        return "exit";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
