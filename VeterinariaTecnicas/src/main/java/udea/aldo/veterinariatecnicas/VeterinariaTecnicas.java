/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package udea.aldo.veterinariatecnicas;

/**
 *
 * @author aldoc
 */
public class VeterinariaTecnicas {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CConection objetoConexion = new CConection();
        objetoConexion.estableceConexion();
        objetoConexion.insertarMascota(); // Inserta una mascota

        // Insertar un veterinario
        objetoConexion.insertarVeterinario();

        // Consultar las mascotas existentes
        System.out.println("Mascotas actuales en la base de datos:");
        objetoConexion.consultarPet();
    }
}
