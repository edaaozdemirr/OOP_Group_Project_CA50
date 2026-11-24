package justice;

public class CasesNotes{
    private int noteId;
    private String noteText;
    private int caseId;

    public CasesNotes(int noteId, String noteText, int caseId){
        this.noteId= noteId;
        this.noteText= noteText;
        this.caseId= caseId;
    }
    public int getNoteId(){
        return noteId;
    }
    public String getNoteText(){
        return noteText;
    }
    public int getCaseId(){
        return caseId;
    }
    public void setNoteText(String noteText){ //update note text
        this.noteText = noteText;
    }
    public String displayNote(){
        return noteText;
    }
    public void editNote(String newText){
        setNoteText(newText);
    }
}
