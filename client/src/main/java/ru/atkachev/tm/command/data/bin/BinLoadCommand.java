package ru.atkachev.tm.command.data.bin;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
//import ru.atkachev.tm.entity.Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BinLoadCommand extends AbstractCommand {
    public BinLoadCommand(IServiceLocator serviceLocate) {
            super(serviceLocate);
    }

    @Override
    public String command() {
        return "bin d";
    }

    @Override
    public void execute() {
//        try{
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.bin"));
//            final Project[] projects = (Project[]) objectInputStream.readObject();
//            final List<Project> projectList = new ArrayList<>();
//            for (Project project : projects) {
//                projectList.add(project);
//            }
//            serviceLocate.getProjectService().setProjectList(projectList);
//            objectInputStream.close();
//        }catch (IOException e){
//            System.out.println("Error!!!IOException");
//        }catch (ClassNotFoundException e){
//            System.out.println("Error!!! ClassNotFound");
//        }
    }

    @Override
    public String description() {
        return "bin s";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
