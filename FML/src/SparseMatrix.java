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


}
