package proyecto.contenedor;


public class Contenedor {

    private int id, puertoArribo;
    private float peso;

    public Contenedor(int id, float peso, int puertoArribo) {
        this.id = id;
        this.peso = peso;
        this.setPuertoArribo(puertoArribo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public int getPuertoArribo() {
        return puertoArribo;
    }

    public void setPuertoArribo(int puertoArribo) {
        if (puertoArribo < 1 || puertoArribo > 4){
            System.out.println("Número de puerto no válido");
        } else{
            this.puertoArribo = puertoArribo;
        }
    }

    @Override
    public String toString() {
        return "Contenedor:\t" + "id=" + id + "\tpeso=" + peso + "\tpuertoArribo=" + puertoArribo;
    }
}
