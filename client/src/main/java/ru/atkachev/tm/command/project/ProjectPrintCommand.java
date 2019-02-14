package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Project;
import ru.atkachev.tm.endpoint.Session;

public class ProjectPrintCommand extends AbstractCommand {

    public ProjectPrintCommand(IServiceLocator serviceLocate){
        super(serviceLocate);
    }

    public String command(){
        return "pr p";
    }

    public void execute(){

        final Session session = serviceLocator.getSession();
        if (serviceLocator.getProjectEndpoint().getProjectList(session).isEmpty()){
            System.out.println("Empty");
        }
        int index = 1;
        for (Project project : serviceLocator.getProjectEndpoint().getProjectList(session) ){
            System.out.printf("%d. %s %s %s %n", index,
                    project.getName(), project.getId(), project.getUserId());
            index++;
        }
    }

    public String description(){
        return "Print projects";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
