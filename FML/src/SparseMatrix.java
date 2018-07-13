import java.util.HashMap;
import java.util.Map;
import methods.Ellpack;

public class SparseMatrix {

    private int[][] matrix;
    private int squareSize;

    public SparseMatrix(int[][] matrix) {
        this.matrix = matrix;
        int columnCount = matrix.length;
        int rowCount = matrix[0].length;
        if (columnCount != rowCount) throw new IllegalArgumentException("Matrixes differ in size. Row: " + rowCount + " Column: " + columnCount);
        this.squareSize = matrix.length;
    }

    public int[] sortByCOO() {
        int[] coo = new int[squareSize * squareSize * 3];
        int arrayCount = 0;
        int cleanupCount = 0;
        for (int row = 0; row < squareSize; row++) {
            for (int column = 0; column < squareSize; column++) {
                if (matrix[row][column] != 0) {
                    coo[arrayCount++] = row;
                    coo[arrayCount++] = column;
                    coo[arrayCount++] = matrix[row][column];
                } else {
                    cleanupCount++;
                }
            }
        }
        int[] result = new int[((squareSize * squareSize) - cleanupCount) * 3];
        for (int i = 0; i < result.length; i++) {
            result[i] = coo[i];
        }
        return result;
    }

    public String sortByEllpack() {
        Integer[][] columnTemp = new Integer[squareSize][squareSize];
        Integer[][] valueTemp = new Integer[squareSize][squareSize];
        int columnCount = 0;
        for (int row = 0; row < squareSize; row++) {
            for (int column = 0; column < squareSize; column++) {
                if (matrix[row][column] != 0) {
                    columnTemp[row][columnCount] = column;
                    valueTemp[row][columnCount] = matrix[row][column];
                    columnCount++;
                }
            }
            columnCount = 0;
        }
        Ellpack ellpack = new Ellpack(columnTemp, valueTemp);
        return ellpack.toString();
    }

    public Map<String, Integer[]> representInCSR(){
        Integer[] A = new Integer[squareSize*squareSize];
        Integer[] IA = new Integer[squareSize*squareSize+1];
        Integer[] JA = new Integer[squareSize*squareSize];
        int Acount = 0;
        int IAcount = 1;
        int JAcount = 0;
        IA[0] = 0;
        int nonzeroRow;
        for (int i=0; i<squareSize; i++){
            nonzeroRow = 0;
            for (int j=0; j<squareSize; j++){
                if (matrix[i][j]!=0){
                    A[Acount] = matrix[i][j];
                    JA[JAcount] = j;
                    Acount++;
                    JAcount++;
                    nonzeroRow++;
                }
            }
            IA[IAcount] = IA[IAcount-1] + nonzeroRow;
            IAcount++;
        }
        
        Map<String,Integer[]> vectors = new HashMap<>();
        vectors.put("A",A);
        vectors.put("IA",IA);
        vectors.put("JA",JA);
        
        return vectors; 
    }
}
