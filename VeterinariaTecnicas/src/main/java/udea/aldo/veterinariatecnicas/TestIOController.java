/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.veterinariatecnicas;

import controller.FileIOController;
import model.Person;

/**
 *
 * @author aldoc
 */
public class TestIOController {

    public static void main(String[] args) {
        // Using the provided constructor for Person
        Person person = new Person(1, 123456789, "John Doe", "123 Main St", "johndoe@example.com");

        // Now, let's test writing this to a JSON file
        FileIOController fileIOController = new FileIOController();
        fileIOController.writeToJSONFile(person, "sample.json");

        // To test reading from the JSON file
        Person personFromJSON = fileIOController.readFromJSONFile("sample.json", Person.class);

    }

}
