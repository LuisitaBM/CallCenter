package callcenter;

import java.util.*;

/**
 *
 * @author luisa
 */
public class CallCenter {
    Cola<Llamada> cola;
    double tiemtt;
    LinkedList<Integer> puntuaciones;
    
    public CallCenter(){
        cola = new Cola<>();
        tiemtt =0;
        puntuaciones = new LinkedList<>();
    }
    
    public void recibirLlamada(Llamada llamada){
        if(llamada.getTipo() == Llamada.Tipo.PRIORITARIA){
            cola.enqueuePrioritario(llamada);
        }else{
            cola.enqueque(llamada);
        }
    }
    
    public Llamada atenderLlamadita(){
        if(cola.empty()){
            System.out.println("No hay llamadas pendientes");
            return null;
        }
        Llamada llamada = cola.dequeque();
        tiemtt += llamada.getDuracion();
        puntuaciones.add(llamada.obtePuntuacion());
        return llamada;
    }
    
    public void cancelarLlamada(){
        if(cola.empty()){
            System.out.println("No hay llamadas pendientes, descansa un rato we");
            return;
        }
        Llamada cancelada = cola.dequeque();
        System.out.println("Llamada cancelada "+cancelada.getCliente());
    }
    
    public void mostrarCola(){
        if(cola.empty()){
            System.out.println("No hay llamadas pendientes");
            return;
        }
        System.out.println("----Llamadas pendientes----");
        for(Llamada l : cola){
            System.out.println("Cliente: "+ l.getCliente() + " | Duración: " + l.getDuracion() + " min");
        }
    }
    
    public double tiempoTtlPend(){
        double suma = 0;
        for(Llamada l : cola){
            suma += l.getDuracion();
        }
        return suma;
    }
    
    public int llamadasPendientes(){
        return cola.size();
    }
    
    public void atenderTodas(){
        while(!cola.empty()){
            Llamada l = atenderLlamadita();
            int puntuacion = puntuaciones.getLast();
            System.out.println("Atendido: " + l.getCliente()
                    + " | Duración: " + l.getDuracion() + " min"
                    + " | Puntuación: " + puntuacion);
        }
    }
    
    public int obtenerpromedio() {
        if (puntuaciones.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (int p : puntuaciones) {
            suma += p;
        }
        return (int) Math.round((double) suma / puntuaciones.size());
    }
    
    public double getTiempoTotal() {
        return tiemtt;
    }
}
