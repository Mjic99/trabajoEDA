package misArchivosLista;

import misClases.Usuario;

public class ListaLEG<E extends Usuario> {
    private NodoLEG<E> primero;
    private int talla; 

    public ListaLEG() {
        this.primero=null;
        this.talla=0;
    }
    public NodoLEG<E> getPrimero() {
        return primero;
    }
    public int getTalla() {
        return talla;
    }
    
    public void insertarAlInicio(E x){        
        NodoLEG<E> nuevo=new NodoLEG<>(x);        
        nuevo.setSiguiente(primero);        
        primero = nuevo;
        talla++;
    }
    public void insertarAlFinal(E x){        
        NodoLEG<E> nuevo=new NodoLEG<>(x);    
        NodoLEG<E> aux=primero;
        
        if(primero ==null){
            primero=nuevo;
        }else{
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        talla++;       
    }
    
    public void agregarUsuario(E user){
        NodoLEG<E> nuevo = new NodoLEG<>(user);
        NodoLEG<E> ptr = primero;
        if(primero.getDato().getNombre().compareToIgnoreCase(user.getNombre())<0){
            insertarAlInicio(user);
            return;
        }
        while(ptr!=null){
            if(ptr.getDato().getNombre().equalsIgnoreCase(user.getNombre())){
                System.out.println("¡El usuario ya existe!");
                return;
            }
            if(ptr.getDato().getNombre().compareToIgnoreCase(user.getNombre())<0){
                if(ptr.getSiguiente()==null){
                    insertarAlFinal(user);
                    break;
                }
                else if(ptr.getSiguiente().getDato().getNombre().compareToIgnoreCase(user.getNombre())>0){
                    nuevo.setSiguiente(ptr.getSiguiente());
                    ptr.setSiguiente(nuevo);
                    break; 
                }   
            }
            ptr = ptr.getSiguiente();
        }
    }
}
