/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stronginstitutions;
//imports for the menu (navigation)
import globalPeace.Donations;
import globalPeace.PeaceBuilderInfoFrame;
import justice.ActionGUI;
import justice.CasesGUI;
import main.MainDashboard;

//imports for the functionality
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nilantha
 */
public class InstitutionViewerFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InstitutionViewerFrame.class.getName());
    //The full list of institutions
    private final ArrayList<PublicEntity> masterEntities = new ArrayList<>();
    //Used when the user add filters
    private final ArrayList<PublicEntity> displayedEntities = new ArrayList<>();
    /**
     * Creates new form InstitutionViewerFrame
     */
    
    public InstitutionViewerFrame() {
        initComponents();
        loadInitialData();
        refreshTable();
        
       
    }
    private void loadInitialData(){
            masterEntities.clear();
            displayedEntities.clear();
            
            //all the master data displayed when filters are not added
            masterEntities.add(new HealthcareBoard(
                    "Health Service Executive (HSE)" , "Healthcare Board" , "Ireland",
                    7.4, 6.8, "Partially Compliant", 54
            ));
            masterEntities.add(new EducationalAuthority(
                    "Higher Education Authority (HEA)" , "Educational Authority" , "Ireland",
                    8.5, 8.2, "Compliant", 25
            ));
            masterEntities.add(new PublicEntity(
                    "Enviromantal Protection Agency (EPA)" , "Public Entity" , "Ireland",
                    8.8, 8.4, "Compliant"
            ));
            displayedEntities.addAll(masterEntities); //display the data into the table
    }
    private void refreshTable(){
        //retrieve the data in the table and cast it to the DefaultTableModel to be able to add or clear rows programmatically
        DefaultTableModel model = (DefaultTableModel) metricViewerTable.getModel();
        model.setRowCount(0); //clear all the exsixting rows (Placeholder rows deleted)
        
        for (PublicEntity entity : displayedEntities){ //step through all objects stored in displayedEntities
            //Object[] allow mixed data types.
            model.addRow(new Object[]{ //creates and new object array (one row in the table)
                //populate the columns by calling the getter methods 
                entity.getEntityName(),
                entity.getEntityType(),
                entity.getRegion(),
                entity.getTransparencyRating(),
                entity.getResourceEfficiency(),
                entity.getAuditCompliance()
            });
        }
        
    }
    
    
    private void applyFilters(){
        displayedEntities.clear();
        
        //read the search filter inputs
        String query = searchTextField.getText().trim().toLowerCase();
        if(query.equals("search by name")){
            query = "";
        }
        
        String selectedType = "All Types";
        if(typesBox.getSelectedItem() != null){
            selectedType = typesBox.getSelectedItem().toString().trim();
        }
        
        String selectedRegion = "All Regions";
        if(regionsBox.getSelectedItem() != null){
            selectedRegion = regionsBox.getSelectedItem().toString().trim();
        }
        
        String selectedRating = "All Ratings";
        if (ratingsBox.getSelectedItem() != null){
            selectedRating = ratingsBox.getSelectedItem().toString().trim();
        } 
        
        //Without this matching filtered items will not be added into displayedEntities Array!!!
        for (PublicEntity entity : masterEntities){
            boolean matchesName = query.isEmpty() || entity.getEntityName().toLowerCase().contains(query);
            
            boolean matchesType = selectedType.equals("All Types") || entity.getEntityName().toLowerCase().contains(selectedType.toLowerCase());
            
            boolean matchesRegion = selectedRegion.isEmpty() || selectedRegion.equals("All Regions") || entity.getRegion().equalsIgnoreCase(selectedRegion);
            
            if(matchesName && matchesType && matchesRegion){
                displayedEntities.add(entity);
            }
        }
        switch (selectedRating){
            case "Highest Transparency":
                displayedEntities.sort((a,b) -> Double.compare(b.getTransparencyRating(), a.getTransparencyRating()));
                break;
            case "Highest Efficiency":
                displayedEntities.sort((a,b)-> Double.compare(b.getResourceEfficiency(),a.getResourceEfficiency()));
                break;
            case "Highest Compliance":
                displayedEntities.sort((a,b)-> b.getAuditCompliance().compareToIgnoreCase(a.getAuditCompliance()));
                break;
            default:
                break;
            
        }
        
        refreshTable();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        metricViewerTable = new javax.swing.JTable();
        titleLbl = new javax.swing.JLabel();
        discriptionLbl = new javax.swing.JLabel();
        viewReportBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailsTF = new javax.swing.JTextArea();
        instituteDetailsLbl = new javax.swing.JLabel();
        activeLbl = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        findPublicLbl = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        typesBox = new javax.swing.JComboBox<>();
        regionsBox = new javax.swing.JComboBox<>();
        ratingsBox = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        main = new javax.swing.JMenu();
        dashboard = new javax.swing.JMenuItem();
        globalPeace = new javax.swing.JMenu();
        donations = new javax.swing.JMenuItem();
        info = new javax.swing.JMenuItem();
        justice = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        strongInstitutions = new javax.swing.JMenu();
        metricViewer = new javax.swing.JMenuItem();
        auditFeedback = new javax.swing.JMenuItem();
        infastructurePolicy = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        metricViewerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Health Service Executive (HSE)", "HealthcareBoard", "Ireland", null, null, null},
                {"Higher Education Authority (HEA)", "EducationalAuthority", "Ireland", null, null, null},
                {"An Garda Síochána", "PublicEntity (Law Enforcement)", "Ireland", null, null, null},
                {"Environmental Protection Agency (EPA Ireland)", "PublicEntity (Regulatory Authority)", "Ireland", null, null, null},
                {"European Court of Auditors (ECA)", "PublicEntity (EU Institution)", "European union", null, null, null},
                {"European Ombudsman", "PublicEntity (EU Accountability Body)", "European Union", null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Entity name", "Type", "Region", "Transparency Rating", "Resource efficiency", "Audit Compliance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        metricViewerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                metricViewerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(metricViewerTable);

        titleLbl.setFont(new java.awt.Font("Segoe UI Historic", 0, 24)); // NOI18N
        titleLbl.setText("Public Institution And Governance viewer");

        discriptionLbl.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        discriptionLbl.setText("Explore the institutions that are responsible");

        viewReportBtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        viewReportBtn.setText("View Full Report\n");
        viewReportBtn.addActionListener(this::viewReportBtnActionPerformed);

        detailsTF.setColumns(20);
        detailsTF.setRows(5);
        detailsTF.setText("Health Service Executive\nHealthcare Board\nRegion: Ireland\n\n\nTranparency Rating: \nResource Efficiency\nAudit Compliance\nFounded\nWebsite\nSummary\n\n\n");
        jScrollPane3.setViewportView(detailsTF);

        instituteDetailsLbl.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        instituteDetailsLbl.setText("Institution Details");

        activeLbl.setText("Active\n");

        jTextPane1.setText("Recent Report Summary\n");
        jScrollPane1.setViewportView(jTextPane1);

        findPublicLbl.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        findPublicLbl.setText("Find Public Institutions");

        searchTextField.setText("Search by name\n");
        searchTextField.addActionListener(this::searchTextFieldActionPerformed);

        typesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Types", "Healthcare Board", "Education Board", "Public Entity" }));
        typesBox.addActionListener(this::typesBoxActionPerformed);

        regionsBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Regions", "Ireland", "European Union", " " }));
        regionsBox.addActionListener(this::regionsBoxActionPerformed);

        ratingsBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Ratings", "Highest Transparency", "Highest Efficiency", "Highest Compliance" }));
        ratingsBox.addActionListener(this::ratingsBoxActionPerformed);

        searchBtn.setText("Search\n");
        searchBtn.addActionListener(this::searchBtnActionPerformed);

        resetBtn.setText("Reset");
        resetBtn.addActionListener(this::resetBtnActionPerformed);

        main.setText("Main");

        dashboard.setText("Main dashboard");
        dashboard.addActionListener(this::dashboardActionPerformed);
        main.add(dashboard);

        MenuBar.add(main);

        globalPeace.setText("Global Peace");

        donations.setText("Donations");
        donations.addActionListener(this::donationsActionPerformed);
        globalPeace.add(donations);

        info.setText("Info");
        info.addActionListener(this::infoActionPerformed);
        globalPeace.add(info);

        MenuBar.add(globalPeace);

        justice.setText("Justice");

        jMenuItem1.setText("Take Action Form");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        justice.add(jMenuItem1);

        jMenuItem2.setText("Explore Cases");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        justice.add(jMenuItem2);

        MenuBar.add(justice);

        strongInstitutions.setText("Strong Institutions");

        metricViewer.setText("Institution Performance & Metric Viewer");
        metricViewer.addActionListener(this::metricViewerActionPerformed);
        strongInstitutions.add(metricViewer);

        auditFeedback.setText("Audit Feedback Form");
        auditFeedback.addActionListener(this::auditFeedbackActionPerformed);
        strongInstitutions.add(auditFeedback);

        infastructurePolicy.setText("Infastructure Policy Hub");
        infastructurePolicy.addActionListener(this::infastructurePolicyActionPerformed);
        strongInstitutions.add(infastructurePolicy);

        MenuBar.add(strongInstitutions);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(discriptionLbl)
                    .addComponent(findPublicLbl)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(typesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(regionsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ratingsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(resetBtn))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(instituteDetailsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(activeLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(viewReportBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discriptionLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(findPublicLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(instituteDetailsLbl)
                            .addComponent(activeLbl))
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regionsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ratingsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn)
                            .addComponent(resetBtn))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewReportBtn)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReportBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewReportBtnActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void typesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typesBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typesBoxActionPerformed

    private void ratingsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratingsBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ratingsBoxActionPerformed

    private void regionsBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionsBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regionsBoxActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        MainDashboard mainDash = new MainDashboard();
        mainDash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardActionPerformed

    private void donationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donationsActionPerformed
        Donations donateForm = new Donations();
        donateForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_donationsActionPerformed

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        PeaceBuilderInfoFrame PeaceInfoForm = new PeaceBuilderInfoFrame();
        PeaceInfoForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_infoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ActionGUI actionForm = new ActionGUI();
        actionForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CasesGUI casesForm = new CasesGUI();
        casesForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void metricViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metricViewerActionPerformed
        //Creating a new instance of the GUI
        InstitutionViewerFrame viewerFrame = new InstitutionViewerFrame();
        viewerFrame.setVisible(true); //Make the GUI frame visible on the screen
        this.dispose();      //closes the main dashboard
    }//GEN-LAST:event_metricViewerActionPerformed

    private void auditFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auditFeedbackActionPerformed
        AuditFeedbackForm feedbackForm = new AuditFeedbackForm();
        feedbackForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_auditFeedbackActionPerformed

    private void infastructurePolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infastructurePolicyActionPerformed
        InfrastructurePolicyHub policyHub = new InfrastructurePolicyHub();
        policyHub.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_infastructurePolicyActionPerformed
    
    //Display the data in the right side Text field when clicked on the row
    private void metricViewerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_metricViewerTableMouseClicked
        int selectedRow = metricViewerTable.getSelectedRow();
        if (selectedRow >= 0){
            int modelRow = metricViewerTable.convertRowIndexToModel(selectedRow);
            PublicEntity selected = displayedEntities.get(modelRow);
            detailsTF.setText(selected.getReport());
        }
    }//GEN-LAST:event_metricViewerTableMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        applyFilters();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        searchTextField.setText("");
        typesBox.setSelectedIndex(0);
        regionsBox.setSelectedIndex(0);
        ratingsBox.setSelectedIndex(0);
        applyFilters();
    }//GEN-LAST:event_resetBtnActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new InstitutionViewerFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JToggleButton activeLbl;
    private javax.swing.JMenuItem auditFeedback;
    private javax.swing.JMenuItem dashboard;
    private javax.swing.JTextArea detailsTF;
    private javax.swing.JLabel discriptionLbl;
    private javax.swing.JMenuItem donations;
    private javax.swing.JLabel findPublicLbl;
    private javax.swing.JMenu globalPeace;
    private javax.swing.JMenuItem infastructurePolicy;
    private javax.swing.JMenuItem info;
    private javax.swing.JLabel instituteDetailsLbl;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenu justice;
    private javax.swing.JMenu main;
    private javax.swing.JMenuItem metricViewer;
    private javax.swing.JTable metricViewerTable;
    private javax.swing.JComboBox<String> ratingsBox;
    private javax.swing.JComboBox<String> regionsBox;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JMenu strongInstitutions;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JComboBox<String> typesBox;
    private javax.swing.JButton viewReportBtn;
    // End of variables declaration//GEN-END:variables
}
