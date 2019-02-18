package ru.atkachev.tm.bootstrap;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.command.ExitCommand;
import ru.atkachev.tm.command.data.bin.BinCleanCommand;
import ru.atkachev.tm.command.data.bin.BinLoadCommand;
import ru.atkachev.tm.command.data.bin.BinSaveCommand;
import ru.atkachev.tm.command.data.json.JSONCleanCommand;
import ru.atkachev.tm.command.data.json.JSONLoadCommand;
import ru.atkachev.tm.command.data.json.JSONSaveCommand;
import ru.atkachev.tm.command.data.xml.XMLCleanCommand;
import ru.atkachev.tm.command.data.xml.XMLLoadCommand;
import ru.atkachev.tm.command.data.xml.XMLSaveCommand;
import ru.atkachev.tm.command.helper.HelpCommand;
import ru.atkachev.tm.command.helper.Helper;
import ru.atkachev.tm.command.project.ProjectCreateCommand;
import ru.atkachev.tm.command.project.ProjectDeleteCommand;
import ru.atkachev.tm.command.project.ProjectPrintCommand;
import ru.atkachev.tm.command.project.ProjectUpdateCommand;
import ru.atkachev.tm.command.task.TaskCreateCommand;
import ru.atkachev.tm.command.task.TaskDeleteCommand;
import ru.atkachev.tm.command.task.TaskPrintCommand;
import ru.atkachev.tm.command.task.TaskUpdateCommand;
import ru.atkachev.tm.command.user.UserCreateCommand;
import ru.atkachev.tm.command.user.UserLogonCommand;
import ru.atkachev.tm.endpoint.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap implements IServiceLocator {

    final private Scanner scanner = new Scanner(System.in);
    final private Map<String, AbstractCommand> commands = new HashMap<>();
    final private ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();
    final private TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();
    final private UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();
    final private SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();
    final private DomainEndpoint domainEndpoint = new DomainEndpointService().getDomainEndpointPort();

    private Session session;

    public void init(){
        String inputText;
        AbstractCommand inputCommand;

        registry(new ProjectCreateCommand(this));
        registry(new ProjectPrintCommand(this));
        registry(new ProjectDeleteCommand(this));
        registry(new ProjectUpdateCommand(this));

        registry(new TaskCreateCommand(this));
        registry(new TaskPrintCommand(this));
        registry(new TaskDeleteCommand(this));
        registry(new TaskUpdateCommand(this));

        registry(new UserCreateCommand(this));
        registry(new UserLogonCommand(this));

        registry(new BinCleanCommand(this));
        registry(new BinSaveCommand(this));
        registry(new BinLoadCommand(this));

        registry(new XMLSaveCommand(this));
        registry(new XMLLoadCommand(this));
        registry(new XMLCleanCommand(this));

        registry(new JSONSaveCommand(this));
        registry(new JSONLoadCommand(this));
        registry(new JSONCleanCommand(this));

        registry(new HelpCommand(this));
        registry(new Helper(this));
        registry(new ExitCommand(this));

        for (;;) {
            inputText = scanner.nextLine();
            inputCommand = commands.get(inputText);
            if (inputCommand != null){
                if(inputCommand.isSecure() && session == null){
                    System.out.println("Access denied");
                    continue;
                }
                inputCommand.execute();
                System.out.println("[OK]");
                continue;
            }
            System.out.println("[FAIL]");
        }
    }

    // складывает в Мапу команды и объекты команд
    private void registry(final AbstractCommand abstractCommand) {
        commands.put(abstractCommand.command(), abstractCommand);
    }

    @Override
    public ProjectEndpoint getProjectEndpoint(){
        return projectEndpoint;
    }
    @Override
    public TaskEndpoint getTaskEndpoint() {
        return taskEndpoint;
    }
    @Override
    public UserEndpoint getUserEndpoint() {
        return userEndpoint;
    }
    @Override
    public SessionEndpoint getSessionEndpoint() {
        return sessionEndpoint;
    }
    @Override
    public DomainEndpoint getDomainEndpoint() {
        return domainEndpoint;
    }

    @Override
    public Session getSession() {
        return session;
    }
    @Override
    public void setSession(final Session session) {
        this.session = session;
    }

    public String getConsoleServiceString(){
        return scanner.nextLine();
    }
    public double getConsoleServiceDouble(){
        return scanner.nextDouble();
    }
    public int getConsoleServiceInteger(){
        return scanner.nextInt();
    }

    public Collection<AbstractCommand> getCommandList() {
        return commands.values();
    }
}