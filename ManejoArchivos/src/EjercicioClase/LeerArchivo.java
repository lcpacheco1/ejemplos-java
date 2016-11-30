package EjercicioClase;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Prueba de la clase ArchivoTexto.
// Este programa lee un archivo de texto y muestra cada registro.
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LeerArchivo {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("calific.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {
        double[] arreglo = new double[4];
        int c = 0;
        try // lee registros del archivo, usando el objeto Scanner
        {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();//Sacar la linea de datos almacenados en el archivo

                double suma = 0.0;
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));
                suma = Integer.parseInt(linea_partes.get(2)) + Integer.parseInt(linea_partes.get(3));
                suma = suma / 2;
                arreglo[c] = suma;
                //System.out.println(arreglo[c]);
                System.out.printf("Promedio de calificaciones de %s %s es: %.2f\n", linea_partes.get(0), linea_partes.get(1), arreglo[c]);
                c++;

            } // fin de try
            double nmenor = arreglo[0];
            for (int i = 0; i < arreglo.length; i++) {
                if (nmenor < arreglo[i]) {
                    nmenor = arreglo[i];
                }

            }
            System.out.println("El mejor promedio es:" + nmenor);
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
    // cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo

} // fin de la clase LeerArchivoTexto

