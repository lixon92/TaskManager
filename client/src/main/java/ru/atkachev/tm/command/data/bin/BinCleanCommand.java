package ru.atkachev.tm.command.data.bin;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class BinCleanCommand extends AbstractCommand {
    public BinCleanCommand(final IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "c b";
    }

    @Override
    public void execute() {

    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
