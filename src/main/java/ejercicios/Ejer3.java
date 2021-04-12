/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author samuel
 */
public class Ejer3 {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "array.txt";

// Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {
            Random random = new Random();
            char letra = ' ';
            for (int i = 0; i < 50; i++) {
                do {
                    int enteroAleatorio = random.nextInt(2);

                    if (enteroAleatorio == 0) {
                        letra = (char) (random.nextInt(26) + 'a');
                    } else if (enteroAleatorio == 1) {
                        letra = (char) (random.nextInt(26) + 'A');
                    }

                    // Usamos metodo write() para escribir en el buffer
                    flujo.write(letra + ", ");

                } while (letra != 120 || letra != 90);
                // Metodo newLine() añade línea en blanco
                flujo.newLine();
            }
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
