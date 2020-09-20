public class TaskWithDateAndPriority extends TaskWithDate {
    private String priority;

    public TaskWithDateAndPriority(String description, String date, String priority) {
        super(description, date);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() + " " + priority;
    }
}
