package ru.atkachev.tm.bootstrap;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.command.data.bin.BinLoadCommand;
import ru.atkachev.tm.command.data.bin.BinSaveCommand;
import ru.atkachev.tm.command.data.json.JSONSaveCommand;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap implements IServiceLocator {

    final private Scanner scanner = new Scanner(System.in);

    private final Map<String, AbstractCommand> commands = new HashMap<>();

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

        registry(new BinSaveCommand(this));
        registry(new BinLoadCommand(this));
        registry(new XMLSaveCommand(this));
        registry(new JSONSaveCommand(this));

        registry(new HelpCommand(this));
        registry(new Helper(this));

        for(;;){
            inputText = scanner.nextLine();
            inputCommand = commands.get(inputText);
            if ( inputCommand != null ){
                System.out.println("[" + inputCommand.description() + "]");
                inputCommand.execute();
                System.out.println("[OK]");
            }
            else {
                System.out.println("[FAIL]");
            }
        }
    }

    // складывает в Мапу команды и объекты команд
    private void registry(final AbstractCommand abstractCommand){
        commands.put(abstractCommand.command(), abstractCommand);
    }

    public Map <String, AbstractCommand> getCommandList(){
        return commands;
    }
    public ProjectService getProjectService(){
        return projectService;
    }
    public TaskService getTaskService(){
        return taskService;
    }
    public String getTerminalService(){
        return scanner.nextLine();
    }
    public UserService getUserService() {
        return userService;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
