/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stronginstitutions;

/**
 *
 * @author Nilantha
 */
//inheritnce in which the EducationalAuthority inherits form publicEntity(Super class)
public class EducationalAuthority extends PublicEntity {
    
    //encapsulation 
    private int fundedInstitutionsCount; //private integer field specific to this class
    
    //constructor, the 6 from the super class and then the seventh parameter 
    public EducationalAuthority(String entityName, String entityType, String region, 
                                double transparencyRating, double resourceEfficiency, 
                                String auditCompliance, int fundedInstitutionsCount){
        //call the parent class constructor
        super(entityName, entityType, region, transparencyRating, resourceEfficiency, auditCompliance);
        this.fundedInstitutionsCount = fundedInstitutionsCount;  
    }
    //getter method to return the value
    public int getFundedInstitutionsCount(){
        return fundedInstitutionsCount;
    }
    //to specify the method overrides a method with the same name from the super class
    @Override
    public String getReport(){
        return super.getReport() + "\nFunded Institutions Count: " + fundedInstitutionsCount;
    }
    // calls the getReport() implementaion and adds a new line to produce a final report.
        
}

