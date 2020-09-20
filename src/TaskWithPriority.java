public class TaskWithPriority extends Task {
    private String priority;

    public TaskWithPriority(String description, String priority) {
        super(description);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() + " " + priority;
    }
}
