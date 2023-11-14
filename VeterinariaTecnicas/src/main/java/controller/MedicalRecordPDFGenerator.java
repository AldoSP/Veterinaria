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
            document.add(new Paragraph("Historia Medica de: " + medicalRecord.getPet().getName()));
            document.add(new Paragraph("\n"));

            for (MedicalEvent event : medicalRecord.getEvents()) {
                document.add(new Paragraph("Descripción: " + event.getDescription()));
                document.add(new Paragraph("Edad: " + medicalRecord.getPet().getAge()));
                document.add(new Paragraph("Peso: " + medicalRecord.getPet().getWeight()));
                document.add(new Paragraph("Altura: " + medicalRecord.getPet().getHeight()));

                document.add(new Paragraph("Precio Consulta: " + event.getConsultationCost()));
                document.add(new Paragraph("Precio Consulta: " + event.getExtraExpenses()));
                document.add(new Paragraph("Precio Consulta: " + event.getPaidAmount()));

                document.add(new Paragraph("------------------------------"));
            }

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
