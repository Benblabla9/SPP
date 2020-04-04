package classSPP;

public class Project {
    private String nameProject;
    private String description;
    private String objectiveGeneral;
    private String objectiveImmediate;
    private String objectiveMediate;
    private String methodology;
    private String resources;
    private String activities;
    private String responsabilities;
    private String status;
    private int idProject;
    private int duration;
    private int quantityPracticing;
    private LinkedOrganization organization;
    private ResponsibleProject responsible;
    
    public Project (int idProject, String nameProject, String description, String objectiveGeneral, String objectiveImmediate, String objectiveMediate, String methodology, String resources, String activities, String responsabilities, int duration, int quantityPracticing) {
        this.idProject = idProject;
        this.nameProject = nameProject;
        this.description = description;
        this.objectiveGeneral = objectiveGeneral;
        this.objectiveImmediate = objectiveImmediate;
        this.objectiveMediate = objectiveMediate;
        this.methodology = methodology;
        this.resources = resources;
        this.activities = activities;
        this.responsabilities = responsabilities;
        status = "disponible";
        this.duration = duration;  
        this.quantityPracticing = quantityPracticing;
    }
    
    public Project () {
        
    }
    
    public String getNameProject () {
        return nameProject;
    }
    
    public void setNameProject (String nameProject) {
        this.nameProject = nameProject;
    }
    
    public String getDescription () {
        return description;
    }
    
    public void setDescription (String description) {
        this.description = description;
    }
    
    public String getObjectiveGeneral () {
        return objectiveGeneral;
    }
    
    public void setObjectiveGeneral (String objectiveGeneral) {
        this.objectiveGeneral = objectiveGeneral;
    }
    
    public String getObjectiveImmediate () {
        return objectiveImmediate;
    }
    
    public void setObjectiveImmediate (String objectiveImmediate) {
        this.objectiveImmediate = objectiveImmediate;
    }
    
    public String getObjectiveMediate () {
        return objectiveMediate;
    }
    
    public void setObjectiveMediate (String objectiveMediate) {
        this.objectiveMediate = objectiveMediate;
    }
    
    public String getMethodology () {
        return methodology;
    }
    
    public void setMethodology (String methodology) {
        this.methodology = methodology;
    }
    
    public String getResources () {
        return resources;
    }
    
    public void setResources (String resources) {
        this.resources = resources;
    }
    
    public String getActivities () {
        return activities;
    }
    
    public void setActivities (String activities) {
        this.activities = activities;
    }
    
    public String getResponsabilities () {
        return responsabilities;
    }
    
    public void setResponsabilities (String responsabilities) {
        this.responsabilities = responsabilities;
    }
    
    public String getStatus () {
        return status;
    }
    
    public int getDuration () {
        return duration;
    }
    
    public void setDuration (int duration) {
        this.duration = duration;
    }
    
    public int getQuantityPracticing () {
        return quantityPracticing;
    }
    
    public void setQuantityPracticing (int quantityPracticing) {
        this.quantityPracticing = quantityPracticing;
    }
   
    public void setIdProject (int idProject) {
        this.idProject = idProject;
    }
    
    public int getIdProject () {
        return idProject;
    }
    
    
    public LinkedOrganization getOrganization (){
        return organization;
    }
    
    public void setOrganization (LinkedOrganization organization){
        this.organization = organization;
    }
    
    public ResponsibleProject getResponsible () {
        return responsible;
    }
    
    public void setResponsible (ResponsibleProject responsible) {
        this.responsible = responsible;
    }
}