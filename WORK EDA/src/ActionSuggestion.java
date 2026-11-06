package src;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class ActionSuggestion  implements Summarizable {

    private String problem;
    private String personAction;
    private String problemFrequency;
    private boolean immediateDanger;
    private boolean personWillingToCommunicate;
    private String urgencyLevel;
    
    private int totalScore;
    private String decisionResult;
    private String status;
    private String nextStep;

    //dorpdown menu options for user input
    private String[] problemArray = {
        "fight", "discrimination", "harassment",
        "human_rights_violation", "bullying",
        "something_else", "property_dispute",
        "noise_complaint", "minor_disagreement",
        "misunderstanding", "accidental_damage",
        "roommate_disagreement"
    };

    private String[] personActionArray = {
        "physical", "verbal", "none"
    };

    private String[] problemFrequencyArray = {
        "one_time", "repeated", "ongoing"
    };

    private String[] urgencyLevelArray = {
        "low", "medium", "high"
    };

    //GUI panel and labels
    private JPanel guiPanel = new JPanel();

    private JLabel problemLabel = new JLabel("Problem:");
    private JLabel personActionLabel = new JLabel("Person Action:");
    private JLabel problemFrequencyLabel = new JLabel("Problem Frequency:");
    private JLabel immediateDangerLabel = new JLabel("Immediate Danger:");
    private JLabel personWillingToCommunicateLabel = new JLabel("Person Willing to Communicate:");
    private JLabel urgencyLevelLabel = new JLabel("Urgency Level:");

    //dropdown menus for user input
    private JComboBox<String> problemDropdown = new JComboBox<>(problemArray);

    private JComboBox<String> personActionDropdown = new JComboBox<>(personActionArray);

    private JComboBox<String> problemFrequencyDropdown = new JComboBox<>(problemFrequencyArray);

    private JComboBox<String> urgencyLevelDropdown = new JComboBox<>(urgencyLevelArray);

    //checkBoxes for boolean values
    private JCheckBox immediateDangerCheckBox = new JCheckBox();
    private JCheckBox personWillingToCommunicateCheckBox = new JCheckBox();

    //button to submit the form
    private JButton submitButton = new JButton("Submit");

    public ActionSuggestion() {

        guiPanel.setLayout(new GridLayout(7, 2, 15, 15));
        guiPanel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));
        guiPanel.setBackground(Color.WHITE);

        guiPanel.add(problemLabel);
        guiPanel.add(problemDropdown);

        guiPanel.add(personActionLabel);
        guiPanel.add(personActionDropdown);

        guiPanel.add(problemFrequencyLabel);
        guiPanel.add(problemFrequencyDropdown);

        guiPanel.add(immediateDangerLabel);
        guiPanel.add(immediateDangerCheckBox);

        guiPanel.add(personWillingToCommunicateLabel);
        guiPanel.add(personWillingToCommunicateCheckBox);

        guiPanel.add(urgencyLevelLabel);
        guiPanel.add(urgencyLevelDropdown);

        guiPanel.add(new JLabel());//empty label for spacing
        
        guiPanel.add(submitButton);
}


    //set values to the user input values
    public void setValues(
            String problem,
            String personAction,
            String problemFrequency,
            boolean immediateDanger,
            boolean personWillingToCommunicate,
            String urgencyLevel) {

        this.problem = problem;
        this.personAction = personAction;
        this.problemFrequency = problemFrequency;
        this.immediateDanger = immediateDanger;
        this.personWillingToCommunicate = personWillingToCommunicate;
        this.urgencyLevel = urgencyLevel;
    }

    public void showGUI() {

        JFrame frame = new JFrame("CivicBridge - Action Assessment");

        frame.setContentPane(guiPanel);
        frame.setSize(650, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override 
    public String getSummary() {
        return "Action summary";
    }
    // TODO: Add constructor
    // TODO: Add scoring method
    // TODO: Implement getSummary()

}
