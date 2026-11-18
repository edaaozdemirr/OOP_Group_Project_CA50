/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stronginstitutions;

/**
 *
 * @author Nilantha
 */
public class PublicEntity implements reportable{
    protected String entityName;
    protected String entityType;
    protected String region;
    protected double transparencyRating;
    protected double resourceEfficiency;
    protected String auditCompliance;

    public PublicEntity(String entityName, String entityType, String region, double transparencyRating, double resourceEfficiency, String auditCompliance){
        this.entityName = entityName;
        this.entityType = entityType;
        this.region = region;
        this.transparencyRating = transparencyRating;
        this.resourceEfficiency = resourceEfficiency;
        this.auditCompliance = auditCompliance;
    }
    
    public String getEntityName(){return entityName;}
    public String getEntityType(){return entityType;}
    public String getRegion(){return region;}
    public double getTransparencyRating(){return transparencyRating;}
    public double getResourceEfficiency(){return resourceEfficiency;}
    public String getAuditCompliance(){return auditCompliance;}
    
    @Override
    public String getReport(){
    
        return "Entity: " + entityName + "[" + entityType + "] - Region: " + region + "\nTransparency: " + transparencyRating + " | Compliance: " + auditCompliance;
    
    }


}