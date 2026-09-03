package Model;

public class Patient {
    private String fullName;
    private String email;
    private String dob;
    private String nic;
    private String contactNo;
    private String password;
    private String address;

    // Constructor
    public Patient(String fullName, String email, String dob, String nic, String contactNo, String password, String address) {
        this.fullName = fullName;
        this.email = email;
        this.dob = dob;
        this.nic = nic;
        this.contactNo = contactNo;
        this.password = password;
        this.address = address;
    }

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}