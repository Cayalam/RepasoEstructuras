import java.util.Scanner;
import java.util.Random;
public class MergeSort {
    public static void merge(int Vector[], int izquierda, int medio, int derecha) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;
  
        //Vectores temporales.
        int VectorIzquierdo[] = new int [n1];
        int VectorDerecho[] = new int [n2];
  
        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {
            VectorIzquierdo[i] = Vector[izquierda+i];
        }
        for (int j=0; j < n2; j++) {
            VectorDerecho[j] = Vector[medio + j + 1];
        }
        /* Une los vectorestemporales. */
  
        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;
  
        //Índice inicial del sub-vector Vector[].
        int k = izquierda;
  
        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (VectorIzquierdo[i] <= VectorDerecho[j]) {
                Vector[k] = VectorIzquierdo[i];
                i++;
            } else {
                Vector[k] = VectorDerecho[j];
                j++;
            }
            k++;
        }//Fin del while.
  
        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de VectorIzquierdo[].
        while (i < n1) {
            Vector[k] = VectorIzquierdo[i];
            i++;
            k++;
        }
        //Copiar los elementos restantes de VectorDerecho[].
        while (j < n2) {
            Vector[k] = VectorDerecho[j];
            j++;
            k++;
        }
    }
    public static void sort(int Vector[], int izquierda, int derecha ) {
        if (izquierda < derecha) {
            //Encuentra el punto medio del vector.
            int medio = (izquierda + derecha) / 2;
  
            //Ordena la primera y segunda mitad.
            sort(Vector, izquierda, medio);
            sort(Vector , medio + 1, derecha);
  
            //Une las mitades ordenadas.
            merge(Vector, izquierda, medio, derecha);
        }
    }
    public static void printArray(int Vector[]) {
        for (int value : Vector) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //Obtener el tamaño del array del usuario.
        System.out.println("Ingresa el tamaño del vector:");
        int n = scanner.nextInt();//
        //Crear un array con el tamaño ingresado por el usuario.
        int Vector[] = new int[n];
        //Llenar el array con números aleatorios.
        for (int i = 0; i < n; i++) {
            Vector[i] = random.nextInt(100);
        }
        System.out.println("Vector original:");
        for (int value : Vector) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("Vector ordenado:");
        MergeSort.sort(Vector, 0, n - 1);
        MergeSort.printArray(Vector);
    }
}
