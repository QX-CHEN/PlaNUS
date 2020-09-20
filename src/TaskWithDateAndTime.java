public class TaskWithDateAndTime extends TaskWithDate {
    private String time;

    public TaskWithDateAndTime(String description, String date, String time) {
        super(description, date);
        this.time = time;
    }

    @Override
    public String toString() {
        return super.toString() + " " + time;
    }
}
