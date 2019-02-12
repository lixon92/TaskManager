package ru.atkachev.tm.command.data.bin;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
//import ru.atkachev.tm.entity.Project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinSaveCommand extends AbstractCommand {
    public BinSaveCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "bin s";
    }

    @Override
    public void execute() {
//        try{
//            Project[] project = serviceLocator.getProjectService().getProjectList().toArray(new Project[0]);
//
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.bin"));
//            objectOutputStream.writeObject(project);
//            objectOutputStream.close();
//        }
//        catch (IOException e){
//            System.out.println("Error!!!");
//        }
    }

    @Override
    public String description() {
        return "save projects in bin";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
