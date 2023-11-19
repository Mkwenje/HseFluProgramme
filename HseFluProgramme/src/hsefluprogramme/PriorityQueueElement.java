package hsefluprogramme;

/**
 *
 * @author sereen
 */
public class PriorityQueueElement {
    private int iKey;
    private Patient patient;
     
    public PriorityQueueElement(int iInPriority, Patient inPatient){
        iKey = iInPriority;
        patient = inPatient;
    }

    public int getiKey() {
        return iKey;
    }
    
    public void setiKey(int iInKey) {
	iKey = iInKey;
    }
	
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient inPatient) {
        patient = inPatient;
    }

    public String printPatient() {        
    return "Name = " + patient.getnName() + 
        ", Age = " + patient.getAge() + 
        ", Medical Condition = " + patient.getMedCon() + 
        ", Priority = " + iKey + "\n";
    }
}