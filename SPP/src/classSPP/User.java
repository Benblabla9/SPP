package classSPP;

public class User{
    protected String name;
    protected String lastName;
    protected String gender;
    protected String email;
    protected String alternateEmail;
    protected String phone;
    private String status;
    
    public User () {
        
    }
    public User (String name, String lastName, String gender, String email, String alternateEmail, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.alternateEmail = alternateEmail;
        this.phone = phone;
        status = "activo";
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getLastName () {
        return lastName;
    }
    
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    
    public String getGender () {
        return gender;
    }
    
    public void setGender (String gender) {
        this.gender = gender;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getAlternateEmail () {
        return alternateEmail;
    }
    
    public void setAlternateEmail (String email) {
        this.alternateEmail = alternateEmail;
    }
    
    public String getPhone () {
        return phone;
    }
    
    public void setPhone (String phone) {
        this.phone = phone;
    }
    public String getStatus (){
        return status;
    }
}