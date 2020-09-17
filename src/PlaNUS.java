import java.util.ArrayList;
import java.util.Scanner;

public class PlaNUS {

    public static final String COMMAND_HELP = "help";
    public static final String COMMAND_ADD = "add";
    public static final String COMMAND_DISPLAY = "list";
    public static final String COMMAND_BYE = "bye";
    private static ArrayList<Task> tasks;
    private static boolean isExit;

    public static void main(String[] args) {
        showWelcomeMessage();
        initProgram();
        while(!isExit) {
            String userInput = getUserInput();
            executeCommand(userInput);
        }
    }

    private static void showWelcomeMessage() {
        System.out.println("\nWelcome to\n" +
                "    ____  __      _   ____  _______\n" +
                "   / __ \\/ /___ _/ | / / / / / ___/\n" +
                "  / /_/ / / __ `/  |/ / / / /\\__ \\ \n" +
                " / ____/ / /_/ / /|  / /_/ /___/ / \n" +
                "/_/   /_/\\__,_/_/ |_/\\____//____/  " +
                "v1.0\n");
    }

    private static void initProgram() {
        tasks = new ArrayList<>();
        isExit = false;
    }

    private static String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void executeCommand(String userInput) {
        String[] commandTypeAndParams = splitCommandWordAndArgs(userInput);
        String commandType = commandTypeAndParams[0];

        switch (commandType) {
        case COMMAND_HELP:
            showCommands();
            break;
        case COMMAND_ADD:
            String commandArgs = commandTypeAndParams[1];
            addTask(commandArgs);
            break;
        case COMMAND_DISPLAY:
            showList();
            break;
        case COMMAND_BYE:
            exitProgram();
            break;
        }
    }

    private static final void showCommands() {
        System.out.println("\nList of available commands:");
        System.out.println("- help: show list of available commands");
        System.out.println("- add: add a task");
        System.out.println("- list: show list of tasks");
        System.out.println("- bye: exit the program\n");
    }

    private static String[] splitCommandWordAndArgs(String userInput) {
        return userInput.split(" ", 2);
    }

    private static void addTask(String commandArgs) {
        Task task = new Task(commandArgs);
        tasks.add(task);
        System.out.println("\nTask added:");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in your list.\n");
    }

    private static void showList() {
        System.out.println("\nHere is your list of tasks:");
        for (Task task : tasks) {
            System.out.println((tasks.indexOf(task)+1) + ". " + task.toString());
        }
        System.out.println();
    }

    private static void exitProgram() {
        isExit = true;
        System.out.println("\nBye! See you again!");
    }
}
