public class TaskWithDateAndTimeAndPriority extends TaskWithDateAndTime {
    private String priority;

    public TaskWithDateAndTimeAndPriority(String description, String date, String time, String priority) {
        super(description, date, time);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return super.toString() + " " + priority;
    }
}
