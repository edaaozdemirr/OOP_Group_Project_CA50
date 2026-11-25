package justice;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ActionSuggestion implements Summarizable {

    // Assessment values selected by the user
    private String problem;
    private String personAction;
    private String problemFrequency;
    private boolean immediateDanger;
    private boolean personWillingToCommunicate;
    private String urgencyLevel;

    // Assessment results
    private int totalScore;
    private String decisionResult;
    private String status;
    private String nextStep;

    // Dropdown menu options
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

    // GUI panel
    private JPanel guiPanel = new JPanel();

    // Labels
    private JLabel problemLabel = new JLabel("Problem:");
    private JLabel personActionLabel = new JLabel("Person Action:");
    private JLabel problemFrequencyLabel = new JLabel("Problem Frequency:");
    private JLabel immediateDangerLabel = new JLabel("Immediate Danger:");
    private JLabel personWillingToCommunicateLabel
            = new JLabel("Willing to Communicate:");
    private JLabel urgencyLevelLabel = new JLabel("Urgency Level:");

    // Dropdown menus
    private JComboBox<String> problemDropdown
            = new JComboBox<>(problemArray);

    private JComboBox<String> personActionDropdown
            = new JComboBox<>(personActionArray);

    private JComboBox<String> problemFrequencyDropdown
            = new JComboBox<>(problemFrequencyArray);

    private JComboBox<String> urgencyLevelDropdown
            = new JComboBox<>(urgencyLevelArray);

    // Checkboxes
    private JCheckBox immediateDangerCheckBox
            = new JCheckBox("Yes");

    private JCheckBox personWillingToCommunicateCheckBox
            = new JCheckBox("Yes");

    // Submit button
    private JButton submitButton
            = new JButton("Submit Assessment");

    // Constructor
    public ActionSuggestion() {

        guiPanel.setLayout(new GridLayout(7, 2, 15, 15));
        guiPanel.setBorder(
                BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );
        guiPanel.setBackground(Color.WHITE);

        // Add components
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

        guiPanel.add(new JLabel());
        guiPanel.add(submitButton);

        // Submit button functionality
        submitButton.addActionListener(e -> {

            String selectedProblem
                    = (String) problemDropdown.getSelectedItem();

            String selectedPersonAction
                    = (String) personActionDropdown.getSelectedItem();

            String selectedFrequency
                    = (String) problemFrequencyDropdown.getSelectedItem();

            boolean danger
                    = immediateDangerCheckBox.isSelected();

            boolean willingToCommunicate
                    = personWillingToCommunicateCheckBox.isSelected();

            String selectedUrgency
                    = (String) urgencyLevelDropdown.getSelectedItem();

        setValues(
            selectedProblem,
            selectedPersonAction,
            selectedFrequency,
            danger,
            willingToCommunicate,
            selectedUrgency
        );

    // Calculate the assessment score
    calculateAssessment();

    // Display the assessment result
    JOptionPane.showMessageDialog(
            guiPanel,
            "Assessment completed!\n\n"
            + "Total Score: " + totalScore
            + "\nDecision: " + decisionResult
            );
        });
    }

    // Store user input
    public void setValues(
            String problem,
            String personAction,
            String problemFrequency,
            boolean immediateDanger,
            boolean personWillingToCommunicate,
            String urgencyLevel
    ) {

        this.problem = problem;
        this.personAction = personAction;
        this.problemFrequency = problemFrequency;
        this.immediateDanger = immediateDanger;
        this.personWillingToCommunicate
                = personWillingToCommunicate;
        this.urgencyLevel = urgencyLevel;
    }

    // Display GUI
    public void showGUI() {

        JFrame frame = new JFrame(
                "CivicBridge - Action Assessment"
        );

        frame.setContentPane(guiPanel);
        frame.setSize(650, 400);
        frame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Interface implementation
    @Override
    public String getSummary() {

        return "Problem: " + problem
                + "\nPerson Action: " + personAction
                + "\nFrequency: " + problemFrequency
                + "\nImmediate Danger: " + immediateDanger
                + "\nWilling to Communicate: "
                + personWillingToCommunicate
                + "\nUrgency: " + urgencyLevel;
    }
    
    
    public void calculateAssessment() {

        totalScore = 0;

        // 1. Score the type of problem
        if (problem.equals("fight")
                || problem.equals("discrimination")
                || problem.equals("harassment")
                || problem.equals("human_rights_violation")) {

            totalScore -= 1;

        } else if (problem.equals("minor_disagreement")
                || problem.equals("misunderstanding")
                || problem.equals("accidental_damage")
                || problem.equals("roommate_disagreement")) {

            totalScore += 1;
        }

        // 2. Score the person's action
        if (personAction.equals("physical")) {
            totalScore -= 1;
        } else if (personAction.equals("none")) {
            totalScore += 1;
        }

        // 3. Score how often the problem happens
        if (problemFrequency.equals("one_time")) {
            totalScore += 1;
        } else if (problemFrequency.equals("ongoing")) {
            totalScore -= 1;
        }

        // 4. Score willingness to communicate
        if (personWillingToCommunicate) {
            totalScore += 1;
        } else {
            totalScore -= 1;
        }

        // 5. Score urgency
        if (urgencyLevel.equals("low")) {
            totalScore += 1;
        } else if (urgencyLevel.equals("high")) {
            totalScore -= 1;
        }

        // 6. Determine the final result
        if (immediateDanger) {

            decisionResult = "Support Organisation Needed";

        } else if (totalScore > 0) {

            decisionResult = "Can Be Solved By Person";

        } else if (totalScore < 0) {

            decisionResult = "Support Organisation Needed";

        } else {

            decisionResult = "Needs Further Assesment";
        }
    }
    public String getDecisionResult() {
        return decisionResult;
    }
    public int getTotalScore() {
        return totalScore;
    }

}
