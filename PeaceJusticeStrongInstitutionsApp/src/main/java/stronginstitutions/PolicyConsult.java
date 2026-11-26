/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stronginstitutions;

/**
 *
 * @author Menomi
 */
public class PolicyConsult {
    private String id;
    private String title;
    private String summary;
    private String referenceLinks;
    
    public PolicyConsult(String id, String title, String summary, String referenceLinks){
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.referenceLinks = referenceLinks;
    
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getSUmmary(){
        return summary;
    }
    public String getReferenceLinks(){
        return referenceLinks;
    }
    
    @Override
    public String toString(){
        return title;
    }
    
}
