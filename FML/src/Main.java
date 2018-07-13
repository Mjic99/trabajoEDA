import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 3, 0},
                {2, 0, 4, 0, 6},
                {8, 7, 20, 9, 0},
                {0, 0, 0, 0, 10},
                {100, 21, 0, 0, 987}
        };
        int[][] simpleMatrix = {
                {1, 0},
                {0, 2}
        };
        int[][] justAnotherTest = {
                {0, 0, 0, 0},
                {5, 8, 0, 0},
                {0, 0, 3, 0},
                {0, 6, 0, 0}
        };
        
        SparseMatrix sparseMatrix = new SparseMatrix(justAnotherTest);
        System.out.println(Arrays.toString(sparseMatrix.sortByCOO()));
        System.out.println(sparseMatrix.sortByEllpack());
        
        System.out.println("GOod stuff");
        Map<String, Integer[]> csr = sparseMatrix.representInCSR();
        System.out.println(Arrays.toString(csr.get("A")));
        System.out.println(Arrays.toString(csr.get("IA")));
        System.out.println(Arrays.toString(csr.get("JA")));
        
        Map<String, Integer[][]> ell = sparseMatrix.representInELL();
        System.out.println("values:");
        for (Integer[] arr : ell.get("values")){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("columns:");
        for (Integer[] arr : ell.get("columns")){
            System.out.println(Arrays.toString(arr));
        }
    }

}
