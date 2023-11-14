/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author antivirus (Juanma)
 */
public class Conexion {
    String bd="VetAppDB";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public Conexion(){
        try{
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd,user,password);   
        } catch(Exception e){
            System.err.println("No se pudo establecer la conexion con la base de datos. Error: " +e);
        }        
    }
    public Connection getConnection(){
        return cx;
    }
    
}
