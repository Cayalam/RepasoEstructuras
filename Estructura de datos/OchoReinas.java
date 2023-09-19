import java.util.Scanner;
public class OchoReinas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Obtener el tamaño del tablero del usuario.
        
        // Crear un tablero del tamaño especificado.
        int[][] Tablero = new int[8][8];
        // Colocar las reinas en el tablero.
        PosicionReina(Tablero, 0);
        // Imprimir el tablero en la consola.
        ImprimirTablero(Tablero);
    }
    private static void PosicionReina(int[][] Tablero, int fila) {
        // Si hemos llegado a la última fila, entonces hemos encontrado una solución.
        if (fila == Tablero.length) {
            return;
        }
        // Intentar colocar una reina en cada columna de la fila actual.
        for (int columna = 0; columna < Tablero.length; columna++) {
            // Si la reina no está bajo ataque, entonces colócala en el tablero.
            if (!EstaAbajoAtaque(Tablero, fila, columna)) {
                Tablero[fila][columna] = 1;
                // Colocar recursivamente las reinas en las filas restantes.
                PosicionReina(Tablero, fila + 1);
                // Si hemos encontrado una solución, entonces devuelve.
                if (isSolved(Tablero)) {
                    return;
                }
                // Si no hemos encontrado una solución, entonces quita la reina del tablero.
                Tablero[fila][columna] = 0;
            }
        }
    }
    private static boolean EstaAbajoAtaque(int[][] Tablero, int fila, int columna) {
        // Comprobar si hay una reina en la misma fila.
        for (int i = 0; i < Tablero.length; i++) {
            if (Tablero[fila][i] == 1) {
                return true;
            }
        }
        // Comprobar si hay una reina en la misma columna.
        for (int i = 0; i < Tablero.length; i++) {
            if (Tablero[i][columna] == 1) {
                return true;
            }
        }
        // Compro bar si hay una reina en la misma diagonal.
        for (int i = 0; i < Tablero.length; i++) {
            for (int j = 0; j < Tablero.length; j++) {
                if (Tablero[i][j] == 1 && Math.abs(i - fila) == Math.abs(j - columna)) {
                    return true;
                }
            }
        }
        // Si no hay una reina en la misma fila, columna o diagonal, entonces la reina no está bajo ataque.
        return false;
    }
    private static boolean isSolved(int[][] Tablero) {
        // Comprobar si hay una reina en cada fila.
        for (int i = 0; i < Tablero.length; i++) {
            int contador = 0;
            for (int j = 0; j < Tablero.length; j++) {
                if (Tablero[i][j] == 1) {
                    contador++;
                }
            }
            if (contador != 1) {
                return false;
            }
        }
        // Comprobar si hay una reina en cada columna.
        for (int i = 0; i < Tablero.length; i++) {
            int contador = 0;
            for (int j = 0; j < Tablero.length; j++) {
                if (Tablero[j][i] == 1) {
                    contador++;
                }
            }
            if (contador != 1) {
                return false;
            }
        }
        // Comprobar si hay una reina en cada diagonal.
        for (int i = 0; i < Tablero.length; i++) {
            for (int j = 0; j < Tablero.length; j++) {
                if (Tablero[i][j] == 1 && Math.abs(i - j) == 1) {
                    return false;
                }
            }
        }
        // Si hay una reina en cada fila, columna y diagonal, entonces el tablero está resuelto.
        return true;
    }
    private static void ImprimirTablero(int[][] Tablero) {
        for (int i = 0; i < Tablero.length; i++) {
            for (int j =  0; j < Tablero.length; j++) {
                System.out.print(Tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}