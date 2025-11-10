import java.util.Arrays;

class DiagonalTraversal {
    private static int idx = 0;

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // [1,2,3]
        // [4,5,6]
        // [7,8,9]
        // output: 124357689

        // Go right until not possible
        int[] res = new int[matrix.length * matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            computeDiagonal(0, col, matrix, res);
        }

        // Go down until not possible
        for (int row = 1; row < matrix.length; row++) {
            computeDiagonal(row, matrix[0].length - 1, matrix, res);
        }
        System.out.println(Arrays.toString(res));
    }

    public static boolean outOfBounds(int row, int col, int[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length;
    }

    public static void computeDiagonal(int row, int col, int[][] matrix, int[] res) {
        while (!outOfBounds(row, col, matrix)) {
            res[idx] = matrix[row][col];
            idx++;
            row++;
            col--;
        }
    }
}
