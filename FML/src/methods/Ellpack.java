package methods;

public class Ellpack {

    private Integer[][] columnMatrix;
    private Integer[][] valueMatrix;

    public Ellpack(Integer[][] columnMatrix, Integer[][] valueMatrix) {
        int columnRowCount = columnMatrix[0].length;
        int valueRowCount = valueMatrix[0].length;
        if (columnRowCount != valueRowCount) throw new IllegalArgumentException("Column and value matrix differ in row size. Column: " + columnRowCount + " Value: " + valueRowCount);
        this.columnMatrix = columnMatrix;
        this.valueMatrix = valueMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Column index: \n");
        for (int row = 0; row < columnMatrix[0].length; row++) {
            for (int column = 0; column < columnMatrix.length; column++) {
                stringBuilder.append(columnMatrix[row][column] != null ? columnMatrix[row][column] : "*");
                stringBuilder.append("\t\t");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Value index: \n");
        for (int row = 0; row < valueMatrix[0].length; row++) {
            for (int column = 0; column < valueMatrix.length; column++) {
                stringBuilder.append(valueMatrix[row][column] != null ? valueMatrix[row][column] : "*");
                stringBuilder.append("\t\t");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
