/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stronginstitutions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nilantha
 */
public class ConsultSubmission {

    private String policyTitle;
    private String vote;
    private String comment;
    private String submittedAt;
    
    public ConsultSubmission(String policyTitle, String vote, String comment){
        this.policyTitle = policyTitle;
        this.vote = vote;
        this.comment = comment;
        this.submittedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    
    public String getPolicyTitle(){return policyTitle;}
    public String getVote(){return vote;}
    public String getComment(){return submittedAt;}
    public String getSubmittedAt(){return submittedAt;}
    
    public String formatEntry(){
        return "[" + submittedAt + "] Policy: " + policyTitle
                + " | Vote: " + vote
                + "\nComment: " + (comment.isEmpty() ? "(No comment)" : comment)
                + "\n -------------------------- \n ";
    }
    
}
