package proyecto.contenedor;


public class Contenedor {
    private String id;
    private float peso;
    private int puertoArribo;

    public Contenedor(String id, float peso, int puertoArribo) {
        this.id = id;
        this.peso = peso;
        this.setPuertoArribo(puertoArribo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public int getPuertoArribo() {
        return puertoArribo;
    }

    public void setPuertoArribo(int puertoArribo) {
        if (puertoArribo<1 || puertoArribo>4){
            System.out.println("Número de puerto no válido");
        }
        else{
            this.puertoArribo = puertoArribo;
        }
    }

    @Override
    public String toString() {
        return "Contenedor:\n" + "id=" + id + "\n\tpeso=" + peso + "\n\tpuertoArribo=" + puertoArribo;
    }
}
