package proyecto.buque;

import proyecto.contenedor.Contenedor;


public class Buque {

    private Contenedor[] contenedores = new Contenedor[50];
    private int numeroContenedores = 0;

    public Buque() {
    }

    public int getNumeroContenedores() {
        return numeroContenedores;
    }
    
    public void addContenedor(Contenedor contenedor){
        if (numeroContenedores >= 50){
            System.out.println("No hay espacio suficiente");
        } else {
            for (int i = 0; i < numeroContenedores; i++) {
                if (contenedores[i].getId() == contenedor.getId()) {
                    System.out.println("Ya hay un contenedor con el mismo ID");
                    return;
                }
            }
            contenedores[numeroContenedores] = contenedor;
            numeroContenedores++;
        }
    }
    
    public float getPesoTotal() {
        float pesoTotal = 0;
        for (int i = 0; i < numeroContenedores; i++){
            pesoTotal += contenedores[i].getPeso();
        }
        return pesoTotal;
    }
    
    public void getInfoContenedores() {
        Contenedor[] contenedoresOrdenados = contenedores;
        for (int i=0; i<numeroContenedores; i++){
            for(int j=0; j<numeroContenedores-1; j++){
                if (contenedoresOrdenados[j].getId() > contenedoresOrdenados[j+1].getId()){
                    Contenedor temp = contenedoresOrdenados[j];
                    contenedoresOrdenados[j] = contenedoresOrdenados[j+1];
                    contenedoresOrdenados[j+1] = temp;
                }
            }
        }
        for(int i=0; i<numeroContenedores; i++){
            System.out.println("Contenedor con ID: " + contenedoresOrdenados[i].getId()+", peso: " +  contenedoresOrdenados[i].getPeso() + " y puerto: " + contenedoresOrdenados[i].getPuertoArribo());
        }
    }

    public Contenedor getContenedorPesado() {
        float peso = contenedores[0].getPeso();
        Contenedor contenedorPesado = contenedores[0];
        for (int i = 1; i < numeroContenedores; i++) {
            if (contenedores[i].getPeso() > peso) {
                peso = contenedores[i].getPeso();
                contenedorPesado = contenedores[i];
            }
        }
        return contenedorPesado;
    }

    public int[] getContenedoresPorPuerto() {
        int[] contenedoresPorPuerto = new int[4];
        for (int i = 0; i < numeroContenedores; i++) {
            int idPuerto = contenedores[i].getPuertoArribo() - 1;
            contenedoresPorPuerto[idPuerto] += 1;
        }
        return contenedoresPorPuerto;
    }
}
