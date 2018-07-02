package misArchivosCola;

public interface Cola<E> {
    void encolar(E x);
    E desencolar();
    E frenteC();
    boolean esVacia();    
}

