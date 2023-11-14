/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import view.BDsearch;
import view.PetIndivSearch;

/**
 *
 * @author antivirus (Juanma)
 */
public class ShowDB {
    static Conexion con1 = new Conexion();
    static Connection conet;
    static DefaultTableModel modelo;
    static Statement st;
    static ResultSet rs;
    
    public static void consultarMascotasAso(BDsearch show){
        String cedulaAcomSt = show.getCedula().getText();
        int cedulaAcom = Integer.parseInt(cedulaAcomSt);
        String sql = "select distinct HistoriasClinicas.* from AcompañanteMascota inner join HistoriasClinicas where AcompañanteMascota.Cedula = '"+cedulaAcom+"';";
        try{
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object[] Historias = new Object[8];
            modelo = (DefaultTableModel) show.getTable().getModel();
            while(rs.next()){
                Historias [0] = rs.getInt("ID");
                Historias [1] = rs.getString("Nombre_Mascota");
                Historias [2] = rs.getString("Especie");
                Historias [3] = rs.getString("Raza");
                Historias [4] = rs.getInt("Edad");
                Historias [5] = rs.getFloat("Peso");
                Historias [6] = rs.getString("Motivo_consulta");
                Historias [7] = rs.getString("Observaciones");
                
                modelo.addRow(Historias);
            }
            show.getTable().setModel(modelo);
            
        } catch (Exception e){
            
        }
    }
    public static void consultarAcompañante(BDsearch show){
        String cedulaAcomSt = show.getCedula().getText();
        int cedulaAcom = Integer.parseInt(cedulaAcomSt);
        String sql = "select * from AcompañanteMAscota where Cedula = '"+cedulaAcom+"';";
        try{
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                String nombreAcomp = rs.getString("Nombre_Acompañante");
                int cedula = rs.getInt("Cedula");
                String numCelular  = rs.getString("Numero_contacto");
                String Direc= rs.getString("Direccion");
                String cedulaSt = String.valueOf(cedula);
                show.getNameAcompañante().setText(nombreAcomp);
                show.getNumDocPro().setText(cedulaSt);
                show.getNumPhoneCont().setText(numCelular);
                show.getDireccion().setText(Direc);
            }
            
        } catch (Exception e){
            
        }
    }
    
        public static void consultarAcompañante2(PetIndivSearch show){
        String idSt = show.getIdNum().getText();
        int id = Integer.parseInt(idSt);
        String sql = "select * from AcompañanteMAscota where ID = '"+id+"';";
        try{
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                String nombreAcomp = rs.getString("Nombre_Acompañante");
                int cedula = rs.getInt("Cedula");
                String numCelular  = rs.getString("Numero_contacto");
                String Direc= rs.getString("Direccion");
                String cedulaSt = String.valueOf(cedula);
                show.getNameAcompañante().setText(nombreAcomp);
                show.getNumDocPro().setText(cedulaSt);
                show.getNumPhoneCont().setText(numCelular);
                show.getDireccion().setText(Direc);
            }
            
        } catch (Exception e){
            
        }
    }
        public static void consultarMascota(PetIndivSearch show){
        String idSt = show.getIdNum().getText();
        int id = Integer.parseInt(idSt);
        String sql = "select * from HistoriasClinicas where ID = '"+id+"';";
        try{
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()){
                String nombreMascota = rs.getString("Nombre_Mascota");
                int edad = rs.getInt("Edad");
                String especie  = rs.getString("Especie");
                String raza = rs.getString("Raza");
                float peso = rs.getFloat("Peso");
                String motivoCons  = rs.getString("Motivo_consulta");
                String observaciones = rs.getString("Observaciones");
                String edadSt = String.valueOf(edad);
                String pesoSt = String.valueOf(peso);
                show.getNamePet().setText(nombreMascota);
                show.getAge().setText(edadSt);
                if (especie.equals("Perro")){
                    show.getDog().setSelected(true);
                }
                else if (especie.equals("Gato")){
                    show.getCat().setSelected(true);
                }
                show.getBreed().setText(raza);
                show.getWeight().setText(pesoSt);
                show.getReasonCon().setText(motivoCons);
                show.getObservations().setText(observaciones);
            }
            
        } catch (Exception e){
            
        }
    }
        public static void consultarCosto(PetIndivSearch show){
        String idSt = show.getIdNum().getText();
        int id = Integer.parseInt(idSt);
        String sql = "select * from Costos where ID = '"+id+"';";
        try{
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            
            if(rs.next()){
               
                int costoCons = rs.getInt("Costo_consulta");
                int gastosEx = rs.getInt("Gastos_extra");
                int paga = rs.getInt("Paga");
                int valorRest = rs.getInt("Valor_restante");
                String costoConsSt = String.valueOf(costoCons);
                String gastosExSt = String.valueOf(gastosEx);
                String pagaSt = String.valueOf(paga);
                String valorRestSt = String.valueOf(valorRest);
                show.getConsultationCost().setText(costoConsSt);
                show.getExtraExpenses().setText(gastosExSt);
                show.getPay().setText(pagaSt);
                show.getValorRestante().setText(valorRestSt);
            }
            
        } catch (Exception e){
            
        }
    }
}
