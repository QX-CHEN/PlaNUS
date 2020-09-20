public class TaskWithTime extends Task {
    private String time;

    public TaskWithTime(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String toString() {
        return super.toString() + " " + time;
    }
}
