package callcenter;

import java.util.*;

/**
 *
 * @author luisa
 */
public class Cola<T> implements Iterable<T> {
    private class Nodo{
        T dato;
        Nodo sig;
        
        Nodo(T dato){
            this.dato = dato;
        }
    }
    
    Nodo inicio;
    Nodo fin;
    int tam;
    
    public Cola(){
        inicio=null;
        fin = null;
        tam = 0;
    }
    
    public void enqueque(T dato){
        Nodo nuevo = new Nodo (dato);
        if(empty()){
            inicio =nuevo;
        }else{
            fin.sig = nuevo;
        }
        fin = nuevo;
        tam ++;
    }
    
    public T dequeque(){
        if(empty()){
            throw new NoSuchElementException("La cola está vacía");
        }
        T dato= inicio.dato;
        inicio = inicio.sig;
        if(inicio == null){
            fin=null;
        }
        tam--;
        return dato;
    }
    
    public T peek(){
        if(empty()){
            throw new NoSuchElementException("La cola está vacía");
        }
        return inicio.dato;
    }
    
    public boolean empty(){
        return tam == 0;
    }
    
    public int size(){
        return tam;
    }
    
    public void enqueuePrioritario (T dato){
        Nodo nuevo = new Nodo(dato);
        nuevo.sig = inicio;
        inicio = nuevo;
        if(fin == null){
            fin = nuevo;
        }
        tam++;
    }
    
 
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo act = inicio;
            
            @Override
            public boolean hasNext(){
                return act != null;
            }
            
            @Override
            public T next(){
                T dato =act.dato;
                act = act.sig;
                return dato;
            }
        };
    }
    
}
