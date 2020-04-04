package classSPP;

public class Practicing extends User{
    private String enrollment;
    private String turn;
    private String period;
    
    public Practicing() {
        
    }
    
    public Practicing (String name, String lastName, String gender, String email, String alternateEmail, String phone, String enrollment, String turn, String period) {
        super (name, lastName, gender, email, alternateEmail, phone);
        this.enrollment = enrollment;
        this.turn = turn;
        this.period = period;
    }
    
    public String getEnrollment () {
        return enrollment;
    }
    
    public void setEnrollment (String enrollment) {
        this.enrollment = enrollment;
    }
    
    public String getTurn () {
        return turn;
    }
    
    public void setTurn (String turn) {
        this.turn = turn;
    }
    
    public String getPeriod () {
        return period;
    }
    
    public void setPeriod (String period){
        this.period = period;
    }
}