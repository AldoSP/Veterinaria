/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author aldoc
 */
public class FileIOController {

    private Gson gson = new Gson();

    public void writeToJSONFile(Object data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(data, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> T readFromJSONFile(String fileName, Class<T> dataType) {
        try (Reader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, dataType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
