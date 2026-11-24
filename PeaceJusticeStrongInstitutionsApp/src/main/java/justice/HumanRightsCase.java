package justice;

public class HumanRightsCase extends Cases{
    private String rightsInvolved;

    public HumanRightsCase(String rightsInvolved, int caseId, String title, String category, String description, String caseLink){
        super(caseId, title, category, description, caseLink);
        this.rightsInvolved = rightsInvolved;
    }

    public void setRightsInvolved(String rightsInvolved){
        this.rightsInvolved= rightsInvolved;
    }
    public String getRightsInvolved(){
        return rightsInvolved;
    }

    @Override
    public String displayCase(){
        return super.displayCase() + " " + rightsInvolved;
    }
}
