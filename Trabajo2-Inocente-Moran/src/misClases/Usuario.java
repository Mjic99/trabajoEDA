package misClases;

import java.util.Random;

import com.sun.istack.internal.Nullable;
import misArchivosCola.ArrayCola;

public class Usuario {
    private String nombre, password;
    private int cantMensajes;
    private ArrayCola<Mensaje> buzon = new ArrayCola<>();

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

    @Nullable
    public Mensaje eliminar(){
        if (cantMensajes==0){
            System.out.println("¡No hay mensajes!");
            return null;
        }
        int num = new Random().nextInt(cantMensajes) + 1;
        Mensaje mensaje = null;
        ArrayCola<Mensaje> aux = new ArrayCola<>();
        int i = 1;
        while(!buzon.colaVacia()){
            if(i==num){
                mensaje = buzon.desencolar();
            }
            else{
                aux.encolar(buzon.desencolar());
            }
            i++;
        }
        while(!aux.colaVacia()){
            buzon.encolar(aux.desencolar());
        }
        return mensaje;
    }

    public void agregar(Mensaje mensaje) {
        buzon.encolar(mensaje);
    }
}
