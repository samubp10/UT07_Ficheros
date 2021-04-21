/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.ejer9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author samuel
 */
public class ejer9 {

    public static void main(String[] args) {
        String linea = "";
        String[] tokens;
        int tipoVehiculo;
        String idFichero = "vehículos.csv";
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        ArrayList<Deportivo> deportivos = new ArrayList<Deportivo>();
        ArrayList<Turismo> turismos = new ArrayList<Turismo>();
        ArrayList<Furgoneta> furgonetas = new ArrayList<Furgoneta>();
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(":");
                Vehiculo tmp = new Vehiculo();
                for (String string : tokens) {
                    tipoVehiculo = Integer.parseInt(tokens[0]);
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

        String idfichero = "Turismo.csv";

        try ( BufferedWriter flujo1 = new BufferedWriter(new FileWriter(idfichero))) {
            flujo1.write("TipoVehiculo:Matricula:Marca:Modelo:Color");
            flujo1.newLine();
            for (Vehiculo veh1 : vehiculos) {

                if (veh1 instanceof Turismo) {
                    flujo1.write(0 + ":" + veh1.getMatricula()
                            + ":" + veh1.getMarca()
                            + ":" + veh1.getModelo()
                            + ":" + veh1.getColor()
                            + ":" + veh1.getBastidor()
                            + ":" + veh1.getTarifa()
                            + ":" + veh1.isDisponible()
                            + ":" + ((Turismo) veh1).getNumeroPuertas());
                }

                // Metodo newLine() añade línea en blanco
                flujo1.newLine();
            }
            // Metodo flush() guarda cambios en disco 
            flujo1.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
