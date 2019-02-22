package ru.atkachev.tm.command.data.bin;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.ClassNotFoundException_Exception;
import ru.atkachev.tm.endpoint.IOException_Exception;
//import ru.atkachev.tm.entity.Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BinLoadCommand extends AbstractCommand {
    public BinLoadCommand(final IServiceLocator serviceLocate) {
            super(serviceLocate);
    }

    @Override
    public String command() {
        return "l b";
    }

    @Override
    public void execute() {
//        try {
//            serviceLocator.getDomainEndpoint().binLoad();
//        } catch (IOException_Exception | ClassNotFoundException_Exception e) {
//            System.out.println("Error load bin");
//        }
    }

    @Override
    public String description() {
        return "Load from bin";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
