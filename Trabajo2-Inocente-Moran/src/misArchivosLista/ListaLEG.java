package misArchivosLista;

import misClases.Mensaje;
import misClases.Usuario;

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

    public void enviarMensaje(String userName, Mensaje mensaje) {
        NodoLEG<E> ptr = nodo;
        boolean found = false;
        while (ptr != null) {
            if (ptr.getInfo().getNombre().equals(userName)) {
                ptr.getInfo().agregarACola(mensaje);
                found = true;
                break;
            }
            ptr = ptr.getSiguiente();
        }
        if (!found) {
            System.out.println("¡El usuario no existe!");
        }
    }
    
    public void agregarUsuario(E user){
        NodoLEG<E> nuevo = new NodoLEG<>(user);
        NodoLEG<E> ptr = nodo;
        if (nodo == null || nodo.getInfo().getNombre().compareToIgnoreCase(user.getNombre()) < 0) {
            insertarAlInicio(user);
            return;
        }
        while (ptr != null){
            if (ptr.getInfo().getNombre().equalsIgnoreCase(user.getNombre())) {
                System.out.println("¡El usuario ya existe!");
                return;
            }
            if (ptr.getInfo().getNombre().compareToIgnoreCase(user.getNombre())>0) {
                if(ptr.getSiguiente() == null){
                    insertarAlFinal(user);
                    break;
                } else if (ptr.getSiguiente().getInfo().getNombre().compareToIgnoreCase(user.getNombre()) < 0) {
                    nuevo.setSiguiente(ptr.getSiguiente());
                    ptr.setSiguiente(nuevo);
                    break; 
                }   
            }
            ptr = ptr.getSiguiente();
        }
    }
}
