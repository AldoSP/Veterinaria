/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.veterinariatecnicas;

import controller.MedicalRecordPDFGenerator;
import java.util.Date;
import model.MedicalEvent;
import model.MedicalRecord;
import model.Medication;
import model.Owner;
import model.Pet;
import model.Vet;

/**
 *
 * @author aldoc
 */
public class TestMedicalRecordPDFGenerator {

    public static void main(String[] args) {
        Owner owner = new Owner(1, 123456789, "John Doe", "123 Main St", "johndoe@example.com");
        Pet pet = new Pet(1, 3, "Fido", "Dog", "Labrador", "Golden", 12.5, 25.0, true, owner);
        Vet vet = new Vet("General Practice", 123456, 101, 987654321, "Dr. Smith", "456 Oak St", "drsmith@example.com");
        // Medical Event 1
        MedicalEvent event1 = new MedicalEvent(new Date(), "Regular Checkup", vet);
        Medication med1 = new Medication("Vitamin Supplement", 2.5, new Date(), new Date(), "Once a day");
        event1.addMedication(med1);

        // Medical Event 2
        MedicalEvent event2 = new MedicalEvent(new Date(), "Injury Treatment", vet);
        Medication med2 = new Medication("Painkiller", 5.0, new Date(), new Date(), "Twice a day");
        event2.addMedication(med2);

        MedicalRecord medicalRecord = new MedicalRecord(pet);
        pet.setMedicalRecord(medicalRecord);
        medicalRecord.addMedicalEvent(medicalRecord, event1);
        medicalRecord.addMedicalEvent(medicalRecord, event2);

        // Generate PDF
        MedicalRecordPDFGenerator.generatePDF(medicalRecord, "Fido_Medical_Record.pdf");
        
    }

}
