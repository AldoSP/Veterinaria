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

public class MedicalRecordPDFGenerator {

    public static void generatePDF(MedicalEvent medicalEvent, String fileName) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Add content to the PDF from the MedicalRecord object
            document.add(new Paragraph("Historia Medica de: " + medicalEvent.getPet().getName()));
            document.add(new Paragraph("ID de Historia: " + medicalEvent.getEventID()));
            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Descripción: " + medicalEvent.getDescription()));
            document.add(new Paragraph("Edad: " + medicalEvent.getPet().getAge()));
            document.add(new Paragraph("Peso: " + medicalEvent.getPet().getWeight()));
            document.add(new Paragraph("Altura: " + medicalEvent.getPet().getHeight()));

            document.add(new Paragraph("Precio Consulta: " + medicalEvent.getConsultationCost()));
            document.add(new Paragraph("Gastos Adicionales: " + medicalEvent.getExtraExpenses()));
            document.add(new Paragraph("Monto Pagado: " + medicalEvent.getPaidAmount()));

            document.add(new Paragraph("------------------------------"));

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
