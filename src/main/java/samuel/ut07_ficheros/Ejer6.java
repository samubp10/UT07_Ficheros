package samuel.ut07_ficheros;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samuel
 */
import java.io.File;

import java.util.Scanner;

import java.io.FileNotFoundException;

public class Ejer6 {

    public static void main(String[] args) {

        // Fichero a leer
        String idFichero = "array.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            // Mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine(); //Se lee la línea
                System.out.println(linea); // Se imprime en pantalla
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // El mismo ejemplo pero separando cada elemento
        // leído usando el método split() de la clase String */
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            System.out.println("Separando cada elemento del fichero: ");

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador coma
                tokens = linea.split(",");

                for (String string : tokens) {
                    System.out.print(string + "\t");
                }

                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}


