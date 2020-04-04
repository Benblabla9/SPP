package classSPP;

public class Coordinator extends User{
    private int staffNumber;
    private String registrationDate;
    private String dischargeDate;
    
    public Coordinator () {
        
    }
    public Coordinator (String name, String lastName, String gender, String email, String alternateEmail, String phone, int staffNumber, String registrationDate, String dischargeDate) {
        super (name, lastName, gender, email, alternateEmail, phone);
        this.staffNumber = staffNumber;
        this.registrationDate = registrationDate;
        this.dischargeDate = dischargeDate;
    }
    
    public int getStaffNumber () {
        return staffNumber;
    }
    
    public void setStaffNumber (int staffNumber) {
        this.staffNumber = staffNumber;
    }
    
    public String getRegistrationDate () {
        return registrationDate;
    }
    
    public void setRegistrationDate (String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public String getDischargeDate () {
        return dischargeDate;
    }
    
    public void setDischargeDate (String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}