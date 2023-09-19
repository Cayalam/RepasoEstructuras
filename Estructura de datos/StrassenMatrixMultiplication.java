public class StrassenMatrixMultiplication {
    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;

        // Caso base: si las matrices son 1x1, multiplicar directamente
        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        } else {
            // Dividir las matrices en submatrices
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            // Llenar las submatrices
            splitMatrix(A, A11, 0, 0);
            splitMatrix(A, A12, 0, n / 2);
            splitMatrix(A, A21, n / 2, 0);
            splitMatrix(A, A22, n / 2, n / 2);
            splitMatrix(B, B11, 0, 0);
            splitMatrix(B, B12, 0, n / 2);
            splitMatrix(B, B21, n / 2, 0);
            splitMatrix(B, B22, n / 2, n / 2);

            // Calcular productos intermedios
            int[][] M1 = multiply(add(A11, A22), add(B11, B22));
            int[][] M2 = multiply(add(A21, A22), B11);
            int[][] M3 = multiply(A11, subtract(B12, B22));
            int[][] M4 = multiply(A22, subtract(B21, B11));
            int[][] M5 = multiply(add(A11, A12), B22);
            int[][] M6 = multiply(subtract(A21, A11), add(B11, B12));
            int[][] M7 = multiply(subtract(A12, A22), add(B21, B22));

            // Calcular las submatrices resultantes
            int[][] C11 = subtract(add(add(M1, M4), M7), M5);
            int[][] C12 = add(M3, M5);
            int[][] C21 = add(M2, M4);
            int[][] C22 = subtract(add(add(M1, M3), M6), M2);

            // Combinar las submatrices para obtener la matriz de resultado
            int[][] C = new int[n][n];
            joinMatrices(C, C11, 0, 0);
            joinMatrices(C, C12, 0, n / 2);
            joinMatrices(C, C21, n / 2, 0);
            joinMatrices(C, C22, n / 2, n / 2);

            return C;
        }
    }

    public static void splitMatrix(int[][] original, int[][] submatrix, int rowOffset, int colOffset) {
        for (int i = 0; i < submatrix.length; i++) {
            for (int j = 0; j < submatrix.length; j++) {
                submatrix[i][j] = original[i + rowOffset][j + colOffset];
            }
        }
    }

    public static void joinMatrices(int[][] result, int[][] submatrix, int rowOffset, int colOffset) {
        for (int i = 0; i < submatrix.length; i++) {
            for (int j = 0; j < submatrix.length; j++) {
                result[i + rowOffset][j + colOffset] = submatrix[i][j];
            }
        }
    }

    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};

        int[][] C = multiply(A, B);

        System.out.println("Matriz A:");
        printMatrix(A);

        System.out.println("Matriz B:");
        printMatrix(B);

        System.out.println("Resultado de la multiplicación (Matriz C):");
        printMatrix(C);
    }
}

