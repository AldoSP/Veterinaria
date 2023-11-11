/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author aldoc
 */
public class Owner extends Person {

    private ArrayList<Pet> petList = new ArrayList<>();

    public Owner(int id, int phoneNumber, String name, String address, String email) {
        super(id, phoneNumber, name, address, email);
    }

    public ArrayList<Pet> getPetList() {
        return petList;
    }

    public void setPetList(ArrayList<Pet> petList) {
        this.petList = petList;
    }
}
