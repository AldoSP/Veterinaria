/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aldo.camera
 */
public class Vet extends Person{
    private String specialty;
    private int licenseNumber;

    public Vet(String specialty, int licenseNumber, int id, int phoneNumber, String name, String address, String email) {
        super(id, phoneNumber, name, address, email);
        this.specialty = specialty;
        this.licenseNumber = licenseNumber;
    }
    
    

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
