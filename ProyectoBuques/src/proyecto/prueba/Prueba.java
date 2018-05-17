package proyecto.prueba;

import proyecto.buque.Buque;
import proyecto.contenedor.Contenedor;


public class Prueba {
    
    public static void main(String[] args) {
        Contenedor a = new Contenedor("2016",1,2);
        Contenedor xd = new Contenedor("2000",2,4);
        Contenedor xjjx = new Contenedor("89",7,1);
        Contenedor aaa = new Contenedor("201",9,66);
        Buque b = new Buque();
        b.addContenedor(a);
        b.addContenedor(xd);
        b.addContenedor(xjjx);
        b.addContenedor(aaa);
        System.out.println(b.getNumeroContenedores());
        System.out.println(b.getPesoTotal());
        b.getInfoContenedores();
    }
}
