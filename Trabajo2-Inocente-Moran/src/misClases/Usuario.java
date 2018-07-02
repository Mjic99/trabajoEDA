package misClases;

import java.util.Random;
import misArchivosCola.ArrayCola;

public class Usuario {
    private String nombre, password;
    private int cantMensajes;
    private ArrayCola<Mensaje> buzon;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        cantMensajes = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    
    public Mensaje eliminar(){
        if (cantMensajes==0){
            System.out.println("¡No hay mensajes!");
            return null;
        }
        Random r = new Random();
        int num = r.nextInt(cantMensajes)+1;
        Mensaje mensaje = null;
        ArrayCola<Mensaje> aux = new ArrayCola<>();
        int i = 1;
        while(!buzon.esVacia()){
            if(i==num){
                mensaje = buzon.desencolar();
            }
            else{
                aux.encolar(buzon.desencolar());
            }
            i++;
        }
        while(!aux.esVacia()){
            buzon.encolar(aux.desencolar());
        }
        return mensaje;
    }
}
