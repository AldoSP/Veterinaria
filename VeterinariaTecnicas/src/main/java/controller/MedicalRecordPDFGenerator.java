/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author aldoc
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import model.MedicalEvent;
import model.MedicalRecord;
import model.Medication;

public class MedicalRecordPDFGenerator {

    public static void generatePDF(MedicalRecord medicalRecord, String fileName) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Add content to the PDF from the MedicalRecord object
            document.add(new Paragraph("Medical Record of " + medicalRecord.getPet().getName()));

            for (MedicalEvent event : medicalRecord.getEvents()) {
                document.add(new Paragraph("Date: " + event.getDate()));
                document.add(new Paragraph("Description: " + event.getDescription()));
                document.add(new Paragraph("Vet: " + event.getVet().getName()));
                // Iterate through medications within the event
                for (Medication medication : event.getMedicationList()) {
                    document.add(new Paragraph("Medication: " + medication.getName()));
                    document.add(new Paragraph("Dosage: " + medication.getDosage()));
                    document.add(new Paragraph("Start Date: " + medication.getStartDate() + "End Date: " + medication.getEndDate()));
                    document.add(new Paragraph("Notes: "));
                }
                document.add(new Paragraph("------------------------------"));
            }

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
