/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import view.Form;

/**
 *
 * @author antivirus (Juanma)
 */
public class InsertToBD {
    static Conexion con1 = new Conexion();
    static Connection conet;
    static Statement st;
    ResultSet rs;
    
    public static void GuardarAcompañante(Form view){
        String idSt = view.getIdNum().getText();
        String nombreCompleto = view.getNameAcompañante().getText();
        String cedulaSt = view.getNumDocPro().getText();
        String numeroContSt = view.getNumPhoneCont().getText();
        String direc = view.getDireccion().getText();
        int id = Integer.parseInt(idSt);
        int cedula = Integer.parseInt(cedulaSt);
        try{
            String sql2 ="insert into AcompañanteMascota (ID, Nombre_Acompañante, Cedula, Numero_contacto, Direccion) "
                    + "values ("+id+", '"+nombreCompleto+"', "+ cedula+", '"+numeroContSt+"', '"+direc+"')";
            conet = con1.getConnection();
            st = conet.createStatement();
            st.executeUpdate(sql2);
        } catch (Exception e){
            
        }
        
    }
    
    public static void AgregarHistoriaClinica(Form view){
        String idSt = view.getIdNum().getText();
        String nombreMascosta = view.getNamePet().getText();
        String especie = "";
        String raza = view.getBreed().getText();
        String edadSt = view.getAge().getText();
        String pesoSt = view.getWeight().getText();
        String motivo = view.getReasonCon().getText();
        String observaciones = view.getObservations().getText();
        String cedulaAcompañante = view.getNumDocPro().getText();
        if (view.getDog().isSelected()){
            especie = "Perro";
        }
        else if (view.getCat().isSelected()){
            especie = "Gato";
        }
        int id = Integer.parseInt(idSt);
        int edad = Integer.parseInt(edadSt);
        int peso = Integer.parseInt(pesoSt);
        
        try{
            String sql ="insert into HistoriasClinicas (ID, Nombre_Mascota, Especie, Raza, Edad, Peso, Motivo_consulta, Observaciones,CedulaAcompañanteAsoc) "
                    + "values ('"+id+"', '"+nombreMascosta+"', '"+ especie+"', '"+ raza+"', "+ edad+", "+ peso+", '"+ motivo+"', '"+ observaciones+"', "+cedulaAcompañante+")";
            conet = con1.getConnection();
            st = conet.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e){
            
        }
    }
    
     public static void GuardarCostos(Form view){
        String idSt = view.getIdNum().getText();
        String costoConsSt = view.getConsultationCost().getText();
        String gastosExSt = view.getExtraExpenses().getText();
        String pagaSt = view.getPay().getText();
        int id = Integer.parseInt(idSt);
        int costoCons = Integer.parseInt(costoConsSt);
        int gastosEx = Integer.parseInt(gastosExSt);
        int paga = Integer.parseInt(pagaSt);
        int valorRestan = (costoCons + gastosEx) - paga;
        
        try{
            String sql2 ="insert into costos (ID, Costo_consulta, Gastos_extra, Paga, Valor_restante) "
                    + "values ("+id+", '"+costoCons+"', "+ gastosEx+", '"+paga+"', '"+valorRestan+"')";
            conet = con1.getConnection();
            st = conet.createStatement();
            st.executeUpdate(sql2);
        } catch (Exception e){
            
        }
        
    }
}
