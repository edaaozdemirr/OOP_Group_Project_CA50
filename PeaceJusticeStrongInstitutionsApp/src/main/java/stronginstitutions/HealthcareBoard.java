/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stronginstitutions;

/**
 *
 * @author Menomi
 */
public class HealthcareBoard extends PublicEntity{
     private int activeHospitals;
    
    public HealthcareBoard(String entityName, String entityType, String region, 
                                double transparencyRating, double resourceEfficiency, 
                                String auditCompliance, int activeHospitals){
        super(entityName, entityType, region, transparencyRating, resourceEfficiency, auditCompliance);
        this.activeHospitals = activeHospitals;  
    }
    public int getActiveHospitals(){
        return activeHospitals;
    }
    public void setActiveHospitals(int activeHospitals){
        this.activeHospitals = activeHospitals;
    }
    @Override
    public String getReport(){
        return super.getReport() + "\nActive Hospitals: " + activeHospitals;
    }
    
}
