package misArchivosLista;

import misClases.Mensaje;
import misClases.Usuario;

import java.util.Random;

public class ListaLEG<E extends Usuario> {

    private NodoLEG<E> nodo;
    private int talla; 

    public ListaLEG() {
        nodo = null;
        talla = 0;
    }

    public NodoLEG<E> getNodo() {
        return nodo;
    }

    public int getTalla() {
        return talla;
    }

    public void setNodo(NodoLEG<E> nodo) {
        this.nodo = nodo;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public void insertarAlInicio(E x){
        NodoLEG<E> nuevo = new NodoLEG<>(x);
        nuevo.setSiguiente(nodo);
        nodo = nuevo;
        talla++;
    }

    public void insertarAlFinal(E x){        
        NodoLEG<E> nuevo = new NodoLEG<>(x);
        NodoLEG<E> aux = nodo;
        
        if (nodo == null) {
            nodo = nuevo;
        } else {
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        talla++;       
    }

    public boolean enviarMensaje(String senderName, String destinationName, Mensaje mensaje) {
        NodoLEG<E> ptr = nodo;
        NodoLEG<E> destination = null;
        boolean foundSender = false;
        boolean foundDestination = false;
        while (ptr != null) {
            if (ptr.getInfo().getNombre().equals(senderName)) {
                foundSender = true;
            } else if (ptr.getInfo().getNombre().equals(destinationName)) {
                destination = ptr;
                foundDestination = true;
            }
            if (foundSender && foundDestination) {
                destination.getInfo().agregarACola(mensaje);
                break;
            }
            ptr = ptr.getSiguiente();
        }
        if (!foundSender || !foundDestination) {
            System.out.println("¡El usuario no existe!");
            return false;
        }
        return true;
    }

    public Mensaje getFirstMessage() {
        Usuario usuario = nodo.getInfo();
        if (usuario.getCantMensajes() == 0){
            System.out.println("¡No hay mensajes!");
            return null;
        }
        Mensaje mensaje = usuario.getBuzon().desencolar();
        nodo.getInfo().setCantMensajes(usuario.getCantMensajes() - 1);
        if (nodo.getInfo().getCantMensajes() < 0) nodo.getInfo().setCantMensajes(0);
        return mensaje;
    }
    
    public void agregarUsuario(E user){
        NodoLEG<E> nuevo = new NodoLEG<>(user);
        NodoLEG<E> ptr = nodo;
        if (nodo == null || nodo.getInfo().getNombre().compareTo(user.getNombre()) < 0) {
            insertarAlInicio(user);
            return;
        }
        while (ptr != null){
            if (ptr.getInfo().getNombre().equalsIgnoreCase(user.getNombre())) {
                System.out.println("¡El usuario ya existe!");
                return;
            }
            if (ptr.getInfo().getNombre().compareTo(user.getNombre())>0) {
                if(ptr.getSiguiente() == null){
                    insertarAlFinal(user);
                    break;
                } else if (ptr.getSiguiente().getInfo().getNombre().compareTo(user.getNombre()) < 0) {
                    nuevo.setSiguiente(ptr.getSiguiente());
                    ptr.setSiguiente(nuevo);
                    break; 
                }   
            }
            ptr = ptr.getSiguiente();
        }
    }
}
