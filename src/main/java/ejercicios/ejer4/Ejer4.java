/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.ejer4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Samuel
 */
//4.- Usando las clases de herencia de Vehículos, implementa un programa que 
//realice lo siguiente:
// - Inventa un método o un constructor, en Turismo, Deportivo y Furgoneta de forma 
//que se generen objetos de forma aleatoria. Lo ideal es que no se repitan las 
//matrículas. El resto de atributos se pueden repetir
//
// - Crea 90 vehículos (30 Turismos, 30 Deportivos y 30 Furgonetas) con valores 
//aleatorios y guárdalos en una lista de objetos tipo Vehículo.
//
// - Guarda los vehículos en un fichero de texto llamado “vehículos.csv”, haciendo 
//uso del método polimórfico toString(), teniendo en cuenta que el string devuelto 
//lleve separados los campos del objeto por el carácter dos puntos (:).
//
// - Cada línea del fichero estará compuesta por un número, dos puntos(:) y los datos
//del vehículo en cuestión (cada campo separado por el carácter dos puntos (:)) 
//El número de cada línea será 0, 1 o 2 si el objeto es un Turismo, un Deportivo 
//o una Furgoneta, respectivamente. 
//
// - Cada vehículo irá en una línea distinta del fichero.
//
// - Ejemplos de líneas, los campos no tienen porqué coincidir con los de tus clases:
// 
//0:4534JTK:Seat:Ibiza:Blanco:… (Este vehículo sería un Turismo)
//1:3322FFF:Ford:Kuga:Rojo:… (Este vehículo sería un Deportivo)
// 
//Abre el fichero CSV creado con una aplicación de hojas de cálculo y comprueba 
//que los valores que se han cargado son correctos. Realiza una mejora sobre el 
//ejercicio, para que la primera línea del fichero contenga los nombres de los campos
//de cada columna. Ejemplo de fichero:
//	TipoVehiculo:Matricula:Marca	:Modelo...
//	0:4534JTK:Seat:Ibiza:Blanco:…   (Este vehículo sería un Turismo)
//      1:3322FFF:Ford:Kuga:Rojo:…      (Este vehículo sería un Deportivo
//
//)
public class Ejer4 {

    public static String generarMarca() {
        Random random = new Random();
        ArrayList<String> Marcas = new ArrayList<>();
        Marcas.add("BMW");
        Marcas.add("Volvo");
        Marcas.add("Mercedes");
        Marcas.add("Fiat");
        Marcas.add("Renault");
        Marcas.add("Audi");
        int enteroAleatorio = random.nextInt(6);
        String Marca;
        Marca = Marcas.get(enteroAleatorio);

        return Marca;
    }

    public static String generarModelo() {
        Random random = new Random();
        ArrayList<String> Modelos = new ArrayList<>();
        Modelos.add("S");
        Modelos.add("A");
        Modelos.add("B");
        Modelos.add("C");
        int enteroAleatorio = random.nextInt(4);
        String Modelo;
        Modelo = Modelos.get(enteroAleatorio);
        return Modelo;
    }

    public static String generarColor() {
        Random random = new Random();
        ArrayList<String> Colores = new ArrayList<>();
        Colores.add("Blanco");
        Colores.add("Azul");
        Colores.add("Amarillo");
        Colores.add("Rosa");
        Colores.add("Dorado");
        Colores.add("Negro");
        Colores.add("Morado");
        Colores.add("Verde");
        Colores.add("Rojo");
        Colores.add("Verde");
        int enteroAleatorio = random.nextInt(10);
        String Modelo;
        Modelo = Colores.get(enteroAleatorio);
        return Modelo;
    }

    public static Vehiculo generarVehiculo(int numero) {

        Random random = new Random();
        int enteroAleatorio = random.nextInt(3);

        long longaleatorio = Math.abs(random.nextLong());

        boolean verdaderoFalso = random.nextBoolean();
        double tarifa = random.nextDouble();
        Vehiculo veh1 = new Deportivo();
        if (numero < 30) {
            enteroAleatorio = random.nextInt(10);

            Vehiculo vehiculo1 = new Deportivo(enteroAleatorio, longaleatorio, generarMarca(), generarModelo(), generarColor(), enteroAleatorio, verdaderoFalso);
            return vehiculo1;

        } else if (numero < 61) {
            enteroAleatorio = random.nextInt(101);
            Vehiculo vehiculo1 = new Furgoneta(enteroAleatorio, enteroAleatorio, longaleatorio, generarMarca(), generarModelo(), generarColor(), enteroAleatorio, verdaderoFalso);
            return vehiculo1;
        } else {
            enteroAleatorio = random.nextInt(101);
            int numPuertas = random.nextInt(6) + 1;
            Vehiculo vehiculo1 = new Turismo(numPuertas, longaleatorio, generarMarca(), generarModelo(), generarColor(), enteroAleatorio, verdaderoFalso);
            return vehiculo1;
        }

    }

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "vehículos.csv";

// Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {
            flujo.write("TipoVehiculo:Matricula:Marca:Modelo:Color");
            flujo.newLine();
            for (int i = 0; i < 91; i++) {

                Vehiculo veh1 = generarVehiculo(i);

                if (veh1 instanceof Deportivo) {
                    flujo.write(1 + ":" + veh1.getMatricula() 
                            + ":" + veh1.getMarca()
                            + ":" + veh1.getModelo() 
                            + ":" + veh1.getColor()
                            + ":" + veh1.getBastidor() 
                            + ":" + veh1.getTarifa()
                            + ":" + veh1.isDisponible()
                            + ":" + ((Deportivo) veh1).getCilindrada());

                } else if (veh1 instanceof Turismo) {
                    flujo.write(0 + ":" + veh1.getMatricula() 
                            + ":" + veh1.getMarca() 
                            + ":" + veh1.getModelo()
                            + ":" + veh1.getColor() 
                            + ":" + veh1.getBastidor()
                            + ":" + veh1.getTarifa() 
                            + ":" + veh1.isDisponible() 
                            + ":" + ((Turismo) veh1).getNumeroPuertas());
                } else if (veh1 instanceof Furgoneta) {
                    flujo.write(2 + ":" + veh1.getMatricula() 
                            + ":" + veh1.getMarca() 
                            + ":" + veh1.getModelo() 
                            + ":" + veh1.getColor() 
                            + ":" + veh1.getBastidor() 
                            + ":" + veh1.getTarifa() 
                            + ":" + veh1.isDisponible()
                            + ":" + ((Furgoneta) veh1).getCarga() 
                            + ":" + ((Furgoneta) veh1).getVolumen());
                }

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
