package classSPP;

public class ReportPartial extends Report {
    private int numberReport;
    private String resultsObtained; 
    private int hoursCovered;
    private String observations;

    public ReportPartial (int numberReport, String resultsObtained, int hoursCovered, String activities, int score, String completionDate, String deliverDate) {
        super(activities,score,completionDate,deliverDate);
        this.numberReport = numberReport;
        this.resultsObtained = resultsObtained;
        this.hoursCovered = hoursCovered;
    }

    public int getNumberReport () {
	return numberReport;
    }

    public void setNumberReport (int numberReport) {
	this.numberReport = numberReport;
    }

    public String getResultsObtained () {
	return resultsObtained;
    }

    public void setResultsObtained (String resultsObtained) {
	this.resultsObtained = resultsObtained;
    }

    public int getHoursCovered() {
        return hoursCovered;
    }

    public void setHoursCovered (int hoursCovered) {
        this.hoursCovered = hoursCovered;
    }

    public String getObservations () {
        return observations;
    }

    public void setObservations (String observations) {
	this.observations = observations;
    }

}