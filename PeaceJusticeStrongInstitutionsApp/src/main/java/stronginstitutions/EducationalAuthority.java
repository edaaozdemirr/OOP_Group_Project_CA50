/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stronginstitutions;

/**
 *
 * @author Nilantha
 */
public class EducationalAuthority extends PublicEntity {
    private int fundedInstitutionsCount;
    
    public EducationalAuthority(String entityName, String entityType, String region, 
                                double transparencyRating, double resourceEfficiency, 
                                String auditCompliance, int fundedInstitutionsCount){
        super(entityName, entityType, region, transparencyRating, resourceEfficiency, auditCompliance);
        this.fundedInstitutionsCount = fundedInstitutionsCount;  
    }
    public int getFundedInstitutionsCount(){
        return fundedInstitutionsCount;
    }
    @Override
    public String getReport(){
        return super.getReport() + "\nFunded Institutions Count: " + fundedInstitutionsCount;
    }
        
}

