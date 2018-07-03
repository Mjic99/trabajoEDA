package misArchivosCola;

public class ArrayCola<E> implements Cola<E>{

    private static final int TAMAÑO = 50;
    private E[] arC;
    private int frentec, finalc;

    public ArrayCola() {
        arC = (E[]) new Object[TAMAÑO];
        frentec = -1;
        finalc = -1;
    }

    public E[] getArC() {
        return arC;
    }
    public int getFrentec() {
        return frentec;
    }
    public int getFinalc() {
        return finalc;
    }
   
    @Override
     public boolean colaVacia(){
        return (frentec==-1 && finalc==-1);
     }
     
    @Override
    public void encolar (E x){            
        if((frentec==0 && finalc ==arC.length-1) || frentec==finalc+1){
            System.out.println("Cola llena ....");
        }else{
            if(colaVacia()){
                frentec=0;
            }
            if(finalc==arC.length-1){ 
                finalc=0;
            }else{
                finalc++;
            }
            arC[finalc]=x;
        }
    }
    
     @Override
    public E desencolar(){        
        E elPrimero = arC[frentec];
        
        if(frentec==finalc){
            frentec=-1;
            finalc=-1;
        }else{
            frentec++;
        }       
        
        return elPrimero;
    }
    
    @Override
    public E frenteC(){
        
        return arC[frentec];
    }
    
    
    
}
