/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.veterinariatecnicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author juan.arboleda
 */
public class CConection {
    Connection conectar = null;
    String usuario = "root";
    String contrasenia = "";
    String bd = "veterinariajava";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            JOptionPane.showMessageDialog(null, "Se conectó a la base de datos");
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la base de datos, error: " + e.toString());
        }
        return conectar;
    }
    
    public void insertarMascota() {
    try {
        if (conectar == null || conectar.isClosed()) {
            conectar = estableceConexion();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la mascota:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad de la mascota:");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese el historial médico de la mascota:");
        String historialMedico = scanner.nextLine();

        System.out.println("Ingrese la especie de la mascota:");
        String especie = scanner.nextLine();

        System.out.println("Ingrese la raza de la mascota:");
        String raza = scanner.nextLine();

        System.out.println("Ingrese el color de la mascota:");
        String color = scanner.nextLine();

        System.out.println("Ingrese el estado de la mascota (1 o 0):");
        int estado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese el peso de la mascota:");
        float peso = scanner.nextFloat();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese la altura de la mascota:");
        float altura = scanner.nextFloat();
        scanner.nextLine(); // Limpiar el buffer

        String sql = "INSERT INTO pet (petname, age, medicalrecord, species, breed, color, petstatus, weight, height) " +
                     "VALUES ('" + nombre + "', " + edad + ", '" + historialMedico + "', '" + especie + "', '" + raza + 
                     "', '" + color + "', " + estado + ", " + peso + ", " + altura + ")";
        Statement stmt = conectar.createStatement();
        stmt.executeUpdate(sql);

        System.out.println("Mascota ingresada correctamente.");

        stmt.close();
        scanner.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    /* 
    consulta a la tabla "pet" y muestra en la consola los IDs y nombres de las mascotas. 
    */
    public void consultarPet() {
        try {
            if (conectar == null || conectar.isClosed()) {
                conectar = estableceConexion();
            }
            
            Statement stmt = conectar.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pet");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String petname = rs.getString("petname");
                // Obtén otras columnas de la misma manera
                
                System.out.println("ID: " + id + ", Pet Name: " + petname);
                // Realiza operaciones necesarias con otros datos
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertarVeterinario() {
        try {
            if (conectar == null || conectar.isClosed()) {
                conectar = estableceConexion();
            }

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese la matrícula profesional del veterinario:");
            String matriculaProfesional = scanner.nextLine();

            System.out.println("Ingrese la especialidad del veterinario:");
            String especialidad = scanner.nextLine();

            String sql = "INSERT INTO vet (matricula_profesional, especialidad) " +
                         "VALUES ('" + matriculaProfesional + "', '" + especialidad + "')";
            Statement stmt = conectar.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("Veterinario ingresado correctamente.");

            stmt.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}