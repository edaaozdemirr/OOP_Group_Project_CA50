package justice;

public class Cases{
    private int caseId; //case number
    private String title; //case name
    private String category; //general/human rights
    private String description; // case info
    private String caseLink; //URL to case

    public Cases(int caseId, String title, String category, String description, String caseLink){
        this.caseId = caseId;
        this.title = title;
        this.category = category;
        this.description = description;
        this.caseLink = caseLink;

    }
    public int getCaseId(){
        return caseId;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDescription(){
        return description;
    }
    public String getCaseLink(){
        return caseLink;
    }
    public String displayCase(){
        return "Case ID: " + getCaseId() + "\nCase Title: " + getTitle()
        + "\nCase Category: " + getCategory() + "\nCase Description: " + getDescription()
        + "\nCase Link: " + getCaseLink();
    }
    public String getSummary(){
        return "Summary:\nCase Title: " + getTitle() + "\nCase Category: " + getCategory()
        + "\nCase Description: " + getDescription();

    }
}
