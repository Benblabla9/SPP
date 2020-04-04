package classSPP;

public class LinkedOrganization{
    private String name;
    private String email;
    private String phoneNumber;
    private String adress;
    private String city;
    private String state;
    private String sector;
    private int idOrganization;
    private int directUsers;
    private int indirectUsers;
    
    public LinkedOrganization (int idOrganization, String name, int directUsers, int indirectUsers, String email, String phoneNumber, String adress, String city, String state, String sector){
        this.idOrganization = idOrganization;
        this.name = name;
        this.directUsers = directUsers;
        this.indirectUsers = indirectUsers;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.sector = sector;
    }
    
    public LinkedOrganization (){}
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getPhoneNumber () {
        return phoneNumber;
    }
    
    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getAdress () {
        return adress;
    }
    
    public void setAdress (String adress) {
        this.adress = adress;
    }
    
    public String getCity () {
        return city;
    }
    
    public void setCity (String city) {
        this.city = city;
    }
    
    public String getState () {
        return state;
    }
    
    public void setState (String state) {
        this.state = state;
    }
    
    public String getSector () {
        return sector;
    } 
    
    public void setSector (String sector) {
        this.sector =sector;
    }
    
    public int getDirectUsers () {
        return directUsers;
    }
    
    public void setDirectUsers (int directUsers) {
        this.directUsers = directUsers;
    }
    
    public int getIndirectUsers () {
        return indirectUsers;
    }
    
    public void setIndirectUsers (int directUsers) {
        this.indirectUsers = indirectUsers;
    }
    
    public int getIdOrganization () {
        return idOrganization;
    }
    
    public void setIdOrganization (int idOrganization) {
        this.idOrganization = idOrganization;
    }
}
