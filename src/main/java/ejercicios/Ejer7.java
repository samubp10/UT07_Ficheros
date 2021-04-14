/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import ejercicios.ejer4.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Samuel
 */
public class Ejer7 {

    public static void main(String[] args) {
        String linea = "";
        String[] tokens;
        String idFichero = "vehículos.csv";
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(":");
                Vehiculo tmp = new Vehiculo();
                for (String string : tokens) {

                    tmp.setBastidor(Long.parseLong(tokens[5]));
                    tmp.setColor(tokens[4]);
                    tmp.setMatricula(tokens[1]);
                    tmp.setMarca(tokens[2]);
                    tmp.setModelo(tokens[3]);
                    tmp.setTarifa(Double.parseDouble(tokens[6]));
                    tmp.setDisponible(Boolean.valueOf(tokens[7]));

                }
                vehiculos.add(tmp);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        vehiculos.sort(new Comparator<Vehiculo>() {
            public int compare(Vehiculo v1, Vehiculo v2) {
                return v1.getMarca().compareTo(v2.getMarca());
            }
        });

        for (Vehiculo veh1 : vehiculos) {
            System.out.println(veh1);
        }
    }
}
