package misArchivosLista;


import com.sun.istack.internal.Nullable;

public class NodoLEG<E> {
    private E info;
    private NodoLEG<E> siguiente;

    public NodoLEG(E info) {
        this.info = info;
        this.siguiente = null;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    @Nullable
    public NodoLEG<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLEG<E> siguiente) {
        this.siguiente = siguiente;
    }    
}

