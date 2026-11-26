/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stronginstitutions;


/**
 *
 * @author Menomi
 */
public class ConsultSubmission {

    private String policyTitle;
    private String vote;
    private String comment;
    
    
    public ConsultSubmission(String policyTitle, String vote, String comment){
        this.policyTitle = policyTitle;
        this.vote = vote;
        this.comment = comment;
        
    }
    
    public String getPolicyTitle(){
        return policyTitle;
    }
    public String getVote(){
        return vote;
    }
    public String getComment(){
        return comment;
    }
    
    
       
}
