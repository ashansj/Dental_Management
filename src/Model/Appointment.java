package Model;

import java.util.Date;

public class Appointment {
    private int id;
    private String patientName;
    private int age;
    private String mobileNumber;
    private String dentist;
    private Date appointmentDate;
    private String time;
    private String treatmentType;

    public Appointment(String patientName, int age, String mobileNumber, String dentist, Date appointmentDate, String time, String treatmentType) {
        this.patientName = patientName;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.dentist = dentist;
        this.appointmentDate = appointmentDate;
        this.time = time;
        this.treatmentType = treatmentType;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getMobileNumber() { return mobileNumber; }
    public String getDentist() { return dentist; }
    public Date getAppointmentDate() { return appointmentDate; }
    public String getTime() { return time; }
    public String getTreatmentType() { return treatmentType; }
}