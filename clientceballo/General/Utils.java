/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JTable;

/**
 *
 * @author Dell
 */
public class Utils {
     public static void printTable(JTable table) throws PrinterException {
        // Create a MessageFormat for the header and footer
        MessageFormat header = new MessageFormat("Borrowers Record");
        MessageFormat footer = new MessageFormat("Page {0}");

        // Print the table
        boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        if (complete) {
            System.out.println("Printing Complete");
        } else {
            System.out.println("Printing Cancelled");
        }
    }
}
