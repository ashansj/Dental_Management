package Util;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

public class PDFGenerator {

    public static String generateAppointmentPDF(int appointmentId, String name, int age, String mobile, String dentist, java.util.Date date, String time, String treatment) throws Exception {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);

        String userHome = System.getProperty("user.home");
        File dir = new File(userHome + "/Desktop/Appointments");
        if (!dir.exists()) { dir.mkdirs(); }

        String filePath = dir.getAbsolutePath() + "/Appointment_" + appointmentId + ".pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, new Color(0, 102, 153));
        Paragraph title = new Paragraph("SUNRISE DENTAL CLINIC", titleFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.DARK_GRAY);
        Paragraph subtitle = new Paragraph("Official Appointment Slip\n\n", subtitleFont);
        subtitle.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(subtitle);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2f, 3f});

        addTableCell(table, "Appointment ID:", true);
        addTableCell(table, "APN-" + appointmentId, false);
        addTableCell(table, "Patient Name:", true);
        addTableCell(table, name, false);
        addTableCell(table, "Patient Age:", true);
        addTableCell(table, String.valueOf(age), false);
        addTableCell(table, "Mobile Number:", true);
        addTableCell(table, mobile, false);
        addTableCell(table, "Dentist Name:", true);
        addTableCell(table, dentist, false);
        addTableCell(table, "Appointment Date:", true);
        addTableCell(table, dateStr, false);
        addTableCell(table, "Appointment Time:", true);
        addTableCell(table, time, false);
        addTableCell(table, "Treatment Type:", true);
        addTableCell(table, treatment, false);

        document.add(table);
        document.close();
        
        return filePath;
    }

    private static void addTableCell(PdfPTable table, String text, boolean isHeader) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 11, isHeader ? Font.BOLD : Font.NORMAL);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(8);
        if (isHeader) { cell.setBackgroundColor(new Color(230, 230, 230)); }
        table.addCell(cell);
    }
}