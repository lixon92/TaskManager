package ru.atkachev.tm.command.data.bin;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.IOException_Exception;
//import ru.atkachev.tm.entity.Project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinSaveCommand extends AbstractCommand {
    public BinSaveCommand(final IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "s b";
    }

    @Override
    public void execute() {
//        try {
//            serviceLocator.getDomainEndpoint().binSave();
//        } catch (IOException_Exception e) {
//            System.out.println("Error save bin!");
//        }
    }

    @Override
    public String description() {
        return "Save projects in bin";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
