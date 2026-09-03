package Model;

public class Dentist {
    private String name;
    private String contactNo;
    private String address;
    private String email;
    private String password;
    
    // Schedule fields
    private String workDate;
    private String startTime;
    private String endTime;

    // Constructor for Dentist Details
    public Dentist(String name, String contactNo, String address, String email, String password) {
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    // Constructor for Schedule
    public Dentist(String workDate, String name, String startTime, String endTime) {
        this.workDate = workDate;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getContactNo() { return contactNo; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getWorkDate() { return workDate; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
}