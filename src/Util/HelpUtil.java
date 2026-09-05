package Util;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class HelpUtil {


    public static void showCommonHelp(JFrame parentFrame) {
        String helpMessage = "Sunrise Dental Management System - Admin Help\n\n"
                    + "• Navigation: Use the left-side menu to easily switch between Home, Dentist Dashboard, and Patient Dashboard.\n"
                    + "• Data Management: You can create, search, update, approve, or delete records using the respective forms and action buttons.\n"
                    + "• Support: For any system errors or technical assistance, please contact the IT support team.";

        JOptionPane.showMessageDialog(
            parentFrame,
            helpMessage,
            "Admin Help & Support",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void showDentistHelp(JFrame parentFrame, String sectionType) {
        String helpMessage = "";
        
        if (sectionType.equalsIgnoreCase("schedule")) {
            helpMessage = "Dentist Working Time Update Help:\n\n"
                        + "• Work Date & Status: Select your available date and set your working status (Pending, Available, Unavailable).\n"
                        + "• Time Slots: Enter your planned start time and end time accurately using the pickers and AM/PM options.\n"
                        + "• Updated List: View your submitted schedule history and status in the table below.";
                        
        } else if (sectionType.equalsIgnoreCase("prescription")) {
            helpMessage = "Patient Treatment & Prescription Help:\n\n"
                        + "• Appointment ID: Enter or verify the patient's appointment ID to load details.\n"
                        + "• Medications: Check the required medicines (Amoxicillin, Paracetamol, etc.) and specify the quantities using the spinners.\n"
                        + "• Notes & Submit: Add any extra medical notes in the text box and click 'Submit' to save the prescription.";
        }

        JOptionPane.showMessageDialog(
            parentFrame,
            helpMessage,
            "Dentist Help & Support - " + sectionType,
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}