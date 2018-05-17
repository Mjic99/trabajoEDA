package proyecto.prueba;

import proyecto.buque.Buque;
import proyecto.contenedor.Contenedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Prueba {

    public static ArrayList<Contenedor> generateTestContainers(int quantity) {
        ArrayList<Contenedor> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            result.add(new Contenedor(new Random().nextInt(200-1)+1, new Random().nextInt(2000-100)+100, new Random().nextInt(4)+1));
        }
        return result;
    }

    public static void main(String[] args) {
        Buque buque = new Buque();
        for (Contenedor contenedor : generateTestContainers(50)) {
            buque.addContenedor(contenedor);
        }
        buque.addContenedor(new Contenedor(1,1,1));
        System.out.println("Número de contenedores: " + buque.getNumeroContenedores());
        System.out.println("Peso total: " + buque.getPesoTotal());
        System.out.println("Contendor más pesado: " + buque.getContenedorPesado());

        for (int i = 0; i < buque.getContenedoresPorPuerto().length; i++) {
            System.out.print("Puerto " + (i + 1) + ": " + buque.getContenedoresPorPuerto()[i] + " contenedores\t");
        }
        System.out.println(Arrays.toString(buque.getContenedoresPorPuerto()));
        buque.getInfoContenedores();
    }
}
