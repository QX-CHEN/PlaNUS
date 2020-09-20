import java.util.ArrayList;
import java.util.Scanner;

public class PlaNUS {

    public static final String COMMAND_HELP = "help";
    public static final String COMMAND_ADD = "add";
    public static final String COMMAND_LIST = "list";
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
            executeAddTask(commandArgs);
            break;
        case COMMAND_LIST:
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

    private static void executeAddTask(String commandArgs) {
        System.out.println("\nTask added:");
        if (commandArgs.contains("d/") && commandArgs.contains("t/") && commandArgs.contains("p/")) {
            addTaskWithDateAndTimeAndPriority(commandArgs);
        }
        else if (commandArgs.contains("d/") && commandArgs.contains("t/")) {
            addTaskWithDateAndTime(commandArgs);
        }
        else if (commandArgs.contains("d/") && commandArgs.contains("p/")) {
            addTaskWithDateAndPriority(commandArgs);
        }
        else if (commandArgs.contains("t/") && commandArgs.contains("p/")) {
            addTaskWithTimeAndPriority(commandArgs);
        }
        else if (commandArgs.contains("d/")) {
            addTaskWithDate(commandArgs);
        }
        else if (commandArgs.contains("t/")) {
            addTaskWithTime(commandArgs);
        }
        else if (commandArgs.contains("p/")) {
            addTaskWithPriority(commandArgs);
        }
        else {
            addTask(commandArgs);
        }
        System.out.println("Now you have " + tasks.size() + " task(s) in your list.\n");
    }

    private static void addTask(String commandArgs) {
        Task task = new Task(commandArgs);
        tasks.add(task);
        System.out.println(task.toString());
    }

    private static void addTaskWithPriority(String commandArgs) {
        int descriptionEndIndex = commandArgs.indexOf("/") - 2;
        int priorityBeginIndex = commandArgs.indexOf("p/") + 2;
        String description = commandArgs.substring(0, descriptionEndIndex);
        String priority = commandArgs.substring(priorityBeginIndex);
        TaskWithPriority task = new TaskWithPriority(description, priority);
        tasks.add(task);
        System.out.println(task.toString());
    }

    private static void addTaskWithTime(String commandArgs) {
        int descriptionEndIndex = commandArgs.indexOf("/") - 2;
        int timeBeginIndex = commandArgs.indexOf("t/") + 2;
        String description = commandArgs.substring(0, descriptionEndIndex);
        String time = commandArgs.substring(timeBeginIndex);
        TaskWithTime task = new TaskWithTime(description, time);
        tasks.add(task);
        System.out.println(task.toString());
    }

    private static void addTaskWithDate(String commandArgs) {
        int descriptionEndIndex = commandArgs.indexOf("/") - 2;
        int dateBeginIndex = commandArgs.indexOf("d/") + 2;
        String description = commandArgs.substring(0, descriptionEndIndex);
        String date = commandArgs.substring(dateBeginIndex);
        TaskWithDate task= new TaskWithDate(description, date);
        tasks.add(task);
        System.out.println(task.toString());
    }

    private static void addTaskWithTimeAndPriority(String commandArgs) {
        int descriptionEndIndex = commandArgs.indexOf("/") - 2;
        int timeBeginIndex = commandArgs.indexOf("t/") + 2;
        int timeEndIndex = commandArgs.indexOf(" ", timeBeginIndex);
        int priorityBeginIndex = commandArgs.indexOf("p/") + 2;
        String description = commandArgs.substring(0, descriptionEndIndex);
        String time = commandArgs.substring(timeBeginIndex, timeEndIndex);
        String priority = commandArgs.substring(priorityBeginIndex);
        TaskWithTimeAndPriority task = new TaskWithTimeAndPriority(description, time, priority);
        tasks.add(task);
        System.out.println(task.toString());
    }

    private static void addTaskWithDateAndPriority(String commandArgs) {
        int descriptionEndIndex = commandArgs.indexOf("/") - 2;
        int dateBeginIndex = commandArgs.indexOf("d/") + 2;
        int dateEndIndex = commandArgs.indexOf(" ", dateBeginIndex);
        int priorityBeginIndex = commandArgs.indexOf("p/") + 2;
        String description = commandArgs.substring(0, descriptionEndIndex);
        String date = commandArgs.substring(dateBeginIndex, dateEndIndex);
        String priority = commandArgs.substring(priorityBeginIndex);
        TaskWithDateAndPriority task = new TaskWithDateAndPriority(description, date, priority);
        tasks.add(task);
        System.out.println(task.toString());
    }

    private static void addTaskWithDateAndTime(String commandArgs) {
        int descriptionEndIndex = commandArgs.indexOf("/") - 2;
        int dateBeginIndex = commandArgs.indexOf("d/") + 2;
        int dateEndIndex = commandArgs.indexOf(" ", dateBeginIndex);
        int timeBeginIndex = commandArgs.indexOf("t/") + 2;
        String description = commandArgs.substring(0, descriptionEndIndex);
        String date = commandArgs.substring(dateBeginIndex, dateEndIndex);
        String time = commandArgs.substring(timeBeginIndex);
        TaskWithDateAndTime task = new TaskWithDateAndTime(description, date, time);
        tasks.add(task);
        System.out.println(task.toString());
    }

    private static void addTaskWithDateAndTimeAndPriority(String commandArgs) {
        int descriptionEndIndex = commandArgs.indexOf("/") - 2;
        int dateBeginIndex = commandArgs.indexOf("d/") + 2;
        int dateEndIndex = commandArgs.indexOf(" ", dateBeginIndex);
        int timeBeginIndex = commandArgs.indexOf("t/") + 2;
        int timeEndIndex = commandArgs.indexOf(" ", timeBeginIndex);
        int priorityBeginIndex = commandArgs.indexOf("p/") + 2;
        String description = commandArgs.substring(0, descriptionEndIndex);
        String date = commandArgs.substring(dateBeginIndex, dateEndIndex);
        String time = commandArgs.substring(timeBeginIndex, timeEndIndex);
        String priority = commandArgs.substring(priorityBeginIndex);
        TaskWithDateAndTimeAndPriority task = new TaskWithDateAndTimeAndPriority(description, date, time, priority);
        tasks.add(task);
        System.out.println(task.toString());
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
