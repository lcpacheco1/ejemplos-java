/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo1;

/**
 *
 * @author SALAS
 */
public class EjecutorNuevoArchivo {

    public static void main(String args[]) {
        NuevoArchivo aplicacion = new NuevoArchivo();

        aplicacion.abrir_archivo();
        aplicacion.agregar_informacion();
        aplicacion.cerrar_archivo();
    }
}
