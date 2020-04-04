package classSPP;

public class Report {
    protected  String activities;
    protected  int score;
    protected  String completionDate;
    protected  String deliverDate;

    public Report (String activities, int score, String completionDate, String deliverDate) {
	this.activities = activities;
        this.score = score;
        this.completionDate = completionDate;
        this.deliverDate = deliverDate;
    }

    public String getActivities () {
	return activities;
    }

    public void setActivities (String activities) {
	this.activities = activities;
    }

    public int getScore () {
       	return score;
    }

    public void setScore (int score) {
        this.score = score;
    }	

    public String getCompletionDate () {
	return completionDate;
    }

    public void setCompletionDate (String completionDate) {
	this.completionDate = completionDate;
    }

    public String getDeliverDate () {
	return deliverDate;
    }

    public void setDeliverDate (String deliverDate) {
	this.deliverDate = deliverDate;
    }

}