import java.util.Arrays;

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
        SparseMatrix sparseMatrix = new SparseMatrix(matrix);
        System.out.println(Arrays.toString(sparseMatrix.sortByCOO()));
    }

}
