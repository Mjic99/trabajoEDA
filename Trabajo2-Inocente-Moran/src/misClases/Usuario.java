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

    public int getCantMensajes() {
        return cantMensajes;
    }

    @Nullable
    public Mensaje eliminarDeCola(){
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
        cantMensajes--;
        if (cantMensajes < 0) cantMensajes = 0;
        return mensaje;
    }

    public void agregarACola(Mensaje mensaje) {
        buzon.encolar(mensaje);
        cantMensajes++;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", password=" + password + ", cantMensajes=" + cantMensajes + '}';
    }
    
}
