package misClases;

public class Mensaje {
    private String texto, fecha;

    public Mensaje(String texto, String fecha) {
        this.texto = texto;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Mensaje:\n" + "Fecha: " + fecha + "\nTexto" + texto;
    }
    
    
}
