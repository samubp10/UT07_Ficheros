package ejercicios.ejer4;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
// Esta clase hereda de la clase Object. Todas las clases heredan de Object
// Clase padre, superclase o clase base
public class Vehiculo {

    private Long bastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    @Override
    public String toString() {
        return "Vehiculo{" + "bastidor=" + bastidor + ", matricula=" + crearMatricula()
                + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
                + ", tarifa=" + tarifa + ", disponible=" + disponible + '}';
    }

    public static String crearMatricula() {

        Random random = new Random();
        int enteroAleatorio;
        String matricula = "";
        for (int i = 0; i <= 4; i++) {
            enteroAleatorio = random.nextInt(10);
            matricula += String.valueOf(enteroAleatorio);
        }
        for (int i = 0; i < 3; i++) {
            char letraMayus = (char) (random.nextInt(26) + 'A');
            matricula += Character.toString(letraMayus);
        }
        return matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;

        if (Double.doubleToLongBits(this.tarifa) != Double.doubleToLongBits(other.tarifa)) {
            return false;
        }
        if (this.disponible != other.disponible) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.bastidor, other.bastidor)) {
            return false;
        }
        return true;
    }

    public Vehiculo(Long bastidor, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.bastidor = bastidor;
        this.matricula = crearMatricula();
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;

    }

    public Vehiculo() {
        this.bastidor = 1L;
        this.matricula = "0000 AAA";
        this.marca = "Sin marca";
        this.modelo = "Sin modelo";
        this.color = "Sin color";
    }

    public Long getBastidor() {
        return bastidor;
    }

    public void setBastidor(Long bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void metodoVehiculo() {
        System.out.println("Método de vehículo");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.bastidor);
        hash = 53 * hash + Objects.hashCode(this.matricula);
        hash = 53 * hash + Objects.hashCode(this.marca);
        hash = 53 * hash + Objects.hashCode(this.modelo);
        hash = 53 * hash + Objects.hashCode(this.color);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.tarifa) ^ (Double.doubleToLongBits(this.tarifa) >>> 32));
        hash = 53 * hash + (this.disponible ? 1 : 0);
        return hash;
    }
    
    
}
