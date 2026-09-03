package Model;

public class Schedule {
    private String date;
    private String startTime;
    private String endTime;
    private String status;

    public Schedule(String date, String startTime, String endTime, String status) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public String getDate() { return date; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getStatus() { return status; }
}