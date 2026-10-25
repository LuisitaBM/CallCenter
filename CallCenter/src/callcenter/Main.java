package callcenter;

/**
 *
 * @author luisa
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba de cola generica");
        Cola<String> c = new Cola<>();
        c.enqueque("Luisa Benitez");
        c.enqueque("Fernanda Miranda");
        c.enqueuePrioritario("Christopher Barreras");
        System.out.println("Peek: "+c.peek());
        System.out.println("Size: "+c.size());
        System.out.println("Dequeue: "+c.dequeque());
        System.out.println("Empty: "+c.empty());
        
        System.out.println("\n --Call Center--");
        CallCenter cc = new CallCenter();
 
        cc.recibirLlamada(new Llamada(1, "Ana", Llamada.Tipo.NORMAL, 5.5));
        cc.recibirLlamada(new Llamada(2, "Luisa", Llamada.Tipo.NORMAL, 3.0));
        cc.recibirLlamada(new Llamada(3, "Christopher", Llamada.Tipo.PRIORITARIA, 7.25));
        cc.recibirLlamada(new Llamada(4, "Samara", Llamada.Tipo.NORMAL, 2.0));
        cc.recibirLlamada(new Llamada(5, "Nicole", Llamada.Tipo.PRIORITARIA, 4.0));
        
        cc.mostrarCola();
        System.out.println("Pendientes: "+cc.llamadasPendientes());
        System.out.println("Tiempo pendiente: "+cc.tiempoTtlPend()+" min");
        
        System.out.println("\n--- Atender una llamada ---");
        Llamada atendida = cc.atenderLlamadita();
        System.out.println("Atendida: " + atendida);
 
        System.out.println("\n--- Cancelar una llamada ---");
        cc.cancelarLlamada();
        System.out.println();
        cc.mostrarCola();
 
        System.out.println("\n--- Atender todas ---");
        cc.atenderTodas();
 
        System.out.println("\nTiempo total atendido: " + cc.getTiempoTotal() + " min");
        System.out.println("Promedio de puntuación: " + cc.obtenerpromedio());
        System.out.println("Pendientes: " + cc.llamadasPendientes());
    }
    
}
