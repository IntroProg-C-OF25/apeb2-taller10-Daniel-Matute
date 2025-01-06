
/**
 * Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros aleatorios,
 * desarrollar su procesamiento para calcular y presentar:
 * La suma de las dos matrices (considerar las restricciones matemáticas para ello).
 * La multiplicación de las dos matrices (considerar las reglas matemáticas para ello).
 *
 * @author Daniel Matute
 */
import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Random random = new Random();
        int filas, columnas, columnasB;

        System.out.print("Ingrese el numero de filas de las matrices: ");
        filas = tcl.nextInt();

        System.out.print("Ingrese el numero de columnas de las matrices: ");
        columnas = tcl.nextInt();

        System.out.print("Ingrese el numero de columnas de la segunda matriz (para multiplicación): ");
        columnasB = tcl.nextInt();

        // Generar matrices aleatorias
        int[][] matrizA = new int[filas][columnas];
        int[][] matrizB = new int[columnas][columnasB];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizA[i][j] = random.nextInt(10); // Valores entre 0 y 9
            }
        }
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < columnasB; j++) {
                matrizB[i][j] = random.nextInt(10);
            }
        }

        System.out.println("\nMatriz A:");
        for (int[] fila : matrizA) {
            for (int valor : fila) {
                System.out.printf("%3d ", valor);
            }
            System.out.println();
        }

        System.out.println("\nMatriz B:");
        for (int[] fila : matrizB) {
            for (int valor : fila) {
                System.out.printf("%3d ", valor);
            }
            System.out.println();
        }

        // Suma de matrices
        if (filas == columnas && columnas == columnasB) {
            int[][] suma = new int[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    suma[i][j] = matrizA[i][j] + matrizB[i][j];
                }
            }

            System.out.println("\nSuma de Matrices (A + B):");
            for (int[] fila : suma) {
                for (int valor : fila) {
                    System.out.printf("%3d ", valor);
                }
                System.out.println();
            }
        } else {
            System.out.println("\nNo se puede realizar la suma: las matrices tienen diferentes dimensiones.");
        }

        // Multiplicación de matrices
        if (columnas == matrizB.length) {
            int[][] producto = new int[filas][columnasB];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnasB; j++) {
                    for (int k = 0; k < columnas; k++) {
                        producto[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }

            System.out.println("\nMultiplicación de Matrices (A x B):");
            for (int[] fila : producto) {
                for (int valor : fila) {
                    System.out.printf("%3d ", valor);
                }
                System.out.println();
            }
        } else {
            System.out.println("\nNo se puede realizar la multiplicación: el número de columnas de A no coincide con el número de filas de B.");
        }

        tcl.close();
    }
}
/*run:
Ingrese el numero de filas de las matrices: 3
Ingrese el numero de columnas de las matrices: 3
Ingrese el numero de columnas de la segunda matriz (para multiplicaci�n): 3

Matriz A:
  8   4   1 
  2   4   7 
  8   4   1 

Matriz B:
  3   0   3 
  0   0   0 
  8   8   7 

Suma de Matrices (A + B):
 11   4   4 
  2   4   7 
 16  12   8 

Multiplicaci�n de Matrices (A x B):
 32   8  31 
 62  56  55 
 32   8  31 
BUILD SUCCESSFUL (total time: 4 seconds)
 */
