
/**
 *Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar su procesamiento para presentar los elementos:
 * De la diagonal principal.
 * De la diagonal segundaria.
 * Ubicados bajo la diagonal principal.
 * Ubicados sobre la diagonal principal.
 * Ubicados bajo la diagonal secundaria.
 * Ubicados sobre la diagonal secundaria.
 *
 * @author Daniel Matute
 */
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int tamMatriz = 0;
        System.out.print("Deme el limite de la matriz: ");
        tamMatriz = tcl.nextInt();
        int matriz[][] = new int[tamMatriz][tamMatriz];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("Diagonal Principal Obvia");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }
        System.out.println("\nDiagonal Principal Eficiente");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + "\t");
        }
        System.out.println("\nDiagonal Secundaria Obvia");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if ((i + j) == matriz.length - 1) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }
        System.out.println("\nDiagonal Secundaria Eficiente");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][tamMatriz - 1 - i] + "\t");
        }

        System.out.println("\nDiagonal Ubicados  Bajo La Principal Obvia");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i > j) {
                    System.out.print(matriz[i][j] + "\t");
                }
            }
        }

        System.out.println("\nDiagonal Ubicados  Bajo La Principal Eficiente");
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
        }
        System.out.println("\nDiagonal Ubicados  Sobre La Principal ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t ");
            }
        }
        System.out.println("\n Diagonal Ubicados bajo la diagonal secundaria:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = matriz.length - i; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " \t");
            }
        }
        System.out.println("\n Diagonal Ubicados sobre la diagonal secundaria:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length - 1 - i; j++) {
                System.out.print(matriz[i][j] + " \t ");
            }
        }
    }
}
/*
run:
Deme el limite de la matriz: 3
0	2	5	
3	1	6	
9	7	6	
Diagonal Principal Obvia
0	1	6	
Diagonal Principal Eficiente
0	1	6	
Diagonal Secundaria Obvia
5	1	9	
Diagonal Secundaria Eficiente
5	1	9	
Diagonal Ubicados  Bajo La Principal Obvia
3	9	7	
Diagonal Ubicados  Bajo La Principal Eficiente
3	9	7	
Diagonal Ubicados  Sobre La Principal 
2	 5	 6	 
 Diagonal Ubicados bajo la diagonal secundaria:
6 	7 	6 	
 Diagonal Ubicados sobre la diagonal secundaria:
0 	 2 	 3 	 BUILD SUCCESSFUL (total time: 2 seconds)
 */
