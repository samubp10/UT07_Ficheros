/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.ejer4;

import ejercicios.ejer4.Vehiculo;

/**
 *
 * @author profesor
 */
public class Deportivo extends Vehiculo {

    private int cilindrada;

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Deportivo() {
        // Implícitamente está llamando a super();
    }

    public Deportivo(int cilindrada, Long bastidor,  String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(bastidor,  marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }

    public void activarModoSport() {
        System.out.println("Activando modo sport en deportivo");
    }

    @Override
    public String toString() {
        return super.toString() + "Deportivo{" + "cilindrada=" + cilindrada + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.cilindrada;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        final Deportivo other = (Deportivo) obj;

        if (this.cilindrada != other.cilindrada) {
            return false;
        }
        return true;
    }

}
