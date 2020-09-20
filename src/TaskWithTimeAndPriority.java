public class TaskWithTimeAndPriority extends TaskWithTime {
    private String priority;

    public TaskWithTimeAndPriority(String description, String time, String priority) {
        super(description, time);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() + " " + priority;
    }
}
