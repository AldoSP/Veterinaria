/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aldoc
 */
public class MedicalEvent {

    private Date date; //The date in which the MedicalEvent took place
    private String description; //Description of what happened
    private Vet vet; //The vet that helped the pet.
    private int consultationCost, extraExpenses, paidAmount;
    private ArrayList<Medication> medicationList = new ArrayList<>();

    public MedicalEvent(Date date, String description, Vet vet) {
        this.date = date;
        this.description = description;
        this.vet = vet;
    }

    public MedicalEvent(String description, int consultationCost, int extraExpenses, int paidAmount) {
        this.description = description;
        this.consultationCost = consultationCost;
        this.extraExpenses = extraExpenses;
        this.paidAmount = paidAmount;
    }
    

    public void addMedication(Medication medication) {
        medicationList.add(medication);
    }

    public void removeMedication(Medication medication) {
        medicationList.remove(medication);
    }

    //Getters & Setters
    public ArrayList<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(ArrayList<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public int getConsultationCost() {
        return consultationCost;
    }

    public void setConsultationCost(int consultationCost) {
        this.consultationCost = consultationCost;
    }

    public int getExtraExpenses() {
        return extraExpenses;
    }

    public void setExtraExpenses(int extraExpenses) {
        this.extraExpenses = extraExpenses;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }
    
}
