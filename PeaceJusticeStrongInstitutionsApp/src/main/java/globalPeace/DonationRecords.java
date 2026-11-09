/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package globalPeace;

/**
 *
 * @author david
 */
public class DonationRecords {
    // Private fields to protect the data   
    private String name;
    private String dob;
    private String amount;

    // Constructor to initialize the record
    public DonationRecords(String name, String dob, String amount) {
        this.name = name;
        this.dob = dob;
        this.amount = amount;
    }
}
