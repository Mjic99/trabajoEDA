/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.buque;

import proyecto.contenedor.Contenedor;

/**
 *
 * @author v6216
 */
public class Buque {
    private Contenedor[] contenedores = new Contenedor[50];
    private int numeroContenedores;

    public Buque() {
        this.numeroContenedores = 0;
    }

    public int getNumeroContenedores() {
        return numeroContenedores;
    }
    
    public void addContenedor(Contenedor cont){
        boolean encontrado;
        int i;
        if (numeroContenedores >= 50){
            System.out.println("No hay espacio suficiente");
        }
        else{
            encontrado = false;
            i = 0;
            while (!encontrado && i<numeroContenedores){
                if (contenedores[i].getId() == cont.getId()){
                    encontrado = true;
                }
                i++;
            }
            if (!encontrado){
                contenedores[numeroContenedores] = cont;
                numeroContenedores++;
            }
            else{
                System.out.println("Ya hay un contenedor con el mismo ID");
            }
        }
    }
    
    public float getPesoTotal(){
        float pesoTotal = 0f;
        for (int i=0; i<numeroContenedores; i++){
            pesoTotal += contenedores[i].getPeso();
        }
        return pesoTotal;
    }
    
    public void getInfoContenedores(){
        Contenedor[] copia = contenedores;
        Contenedor aux;
        for (int i=0; i<numeroContenedores; i++){
            for(int j=0; j<numeroContenedores-1; j++){
                if (Integer.parseInt(copia[j].getId())>Integer.parseInt(copia[j+1].getId())){
                    aux = copia[j];
                    copia[j] = copia[j+1];
                    copia[j+1] = aux;
                }
            }
        }
        for(int i=0; i<numeroContenedores; i++){
            System.out.println("Contenedor con ID: " + copia[i].getId()+", peso: " +  copia[i].getPeso() + " y puerto: " + copia[i].getPuertoArribo());
        }
    }
}
