/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author Samuel
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejer1 {

//  1.- Implementa un programa que genere un fichero de texto en la carpeta 
//  raíz del proyecto, llamado “matriz.txt”, donde se escriba la siguiente tabla
//  de valores numéricos. Utiliza el tabulador para ir separando cada número 
//  y el salto de línea para añadir nuevas líneas. Ten en cuenta que 
//  el programa debe ser escalable, de forma que se pueda 
//  generar cualquier matriz que siga el patrón.
    
   public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "matriz.txt";

// Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {

            for (int f = 1; f <= 4; f++) {
                for (int i = f * 100; i < (f * 100 + 4); i++) {
                    flujo.write(i + "\t");
                }

                flujo.newLine();

                flujo.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}