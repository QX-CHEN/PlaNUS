public class TaskWithDate extends Task {
    private String date;

    public TaskWithDate(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString() + " " + date;
    }
}
