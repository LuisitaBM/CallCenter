package callcenter;

import java.util.*;

/**
 *
 * @author luisa
 */
public class Llamada {
    public enum Tipo { NORMAL, PRIORITARIA }
    
    private static final Random RANDOM = new Random();
    
    int id;
    String cliente;
    Tipo tipo;
    double duracion;

    public Llamada(int id, String cliente, Tipo tipo, double duracion) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.duracion = duracion;
    }
    
    public int obtePuntuacion(){
        return RANDOM.nextInt(10)+1;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Llamada #" + id + " | Cliente=" + cliente + " | tipo=" + tipo + " | Duracion=" + duracion + " min";
    }    
    
    
}
