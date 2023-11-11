/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.veterinariatecnicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author arboleda
 */
public class CConection {
    Connection conectar = null;
    String usuario = "root";
    String contrasenia = "";
    String bd = "veterinariajava";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(cadena,usuario,contrasenia);
            JOptionPane.showMessageDialog(null, "Se conecto a la base de datos, error: ");
            
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "No se conecto a la base de datos, error: "+ e.toString());
        }
        return conectar;
    }
}
