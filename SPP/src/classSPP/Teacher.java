package classSPP;

public class Teacher extends User{
    private String staffNumber;
    private String turn;
    private String registrationDate;
    private String dischargeDate;
    

    public Teacher(String staffNumber, String turn, String registrationDate, String dischargeDate, String name, String lastName, String gender, String email, String alternateEmail, String phone) {
        super(name, lastName, gender, email, alternateEmail, phone);
        this.staffNumber = staffNumber;
        this.turn = turn;
        this.registrationDate = registrationDate;
        this.dischargeDate = dischargeDate;
    }
    
    
    public String getStaffNumber () {
        return staffNumber;
    }
    
    public void setStaffNumber (String staffNumber) {
        this.staffNumber = staffNumber;
    }
    
    public String getTurn () {
        return turn;
    }
    
    public void setTurn (String turn) {
        this.turn = turn;
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