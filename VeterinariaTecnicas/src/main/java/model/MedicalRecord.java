/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aldoc
 */
public class MedicalRecord { // A medical record is made of MedicalEvents for one Pet

    private Pet pet;
    private List<MedicalEvent> events;

    public MedicalRecord(Pet pet) {
        this.pet = pet;
        this.events = new ArrayList<>();
    }

    public void addMedicalEvent(MedicalRecord record, MedicalEvent event) {
        record.getEvents().add(event);
    }
    //Getters & Setters

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<MedicalEvent> getEvents() {
        return events;
    }

    public void setEvents(List<MedicalEvent> events) {
        this.events = events;
    }
}
