
/**
 * Crea un juego de tres en raya utilizando una matriz bidimensional de 3x3.
 * Permita a dos jugadores marcar sus movimientos alternativamente.
 * El juego debe verificar si alguno de los jugadores ha ganado o si hay un empate.
 * @author Daniel Matute
 */


import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        char[][] tablero = new char[3][3];
        boolean juegoActivo = true, victoria , empate;
        char jugadorActual = 'X';
        int filas, columna;

        // Inicializar el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }

        // Ciclo principal del juego
        while (juegoActivo) {
            // Mostrar tablero
            System.out.println("\nTablero:");
            for (char[] fila : tablero) {
                for (char celda : fila) {
                    System.out.print(celda + " ");
                }
                System.out.println();
            }

            // Solicitar movimiento del jugador
            System.out.printf("Turno del jugador '%c'. Ingrese la fila y columna (1-3):%n", jugadorActual);
            

            while (true) {
                System.out.print("Fila: ");
                filas = tcl.nextInt() - 1;
                System.out.print("Columna: ");
                columna = tcl.nextInt() - 1;

                if (filas >= 0 && filas < 3 && columna >= 0 && columna < 3 && tablero[filas][columna] == '-') {
                    break;
                } else {
                    System.out.println("Movimiento no válido. Intente de nuevo.");
                }
            }

            // Registrar movimiento
            tablero[filas][columna] = jugadorActual;

            // Verificar victoria
            victoria = false;
            for (int i = 0; i < 3; i++) {
                if ((tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) ||
                    (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)) {
                    victoria = true;
                    break;
                }
            }
            if (!victoria && 
                ((tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
                 (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual))) {
                victoria = true;
            }

            if (victoria) {
                System.out.println("\nTablero final:");
                for (char[] filaFinal : tablero) {
                    for (char celda : filaFinal) {
                        System.out.print(celda + " ");
                    }
                    System.out.println();
                }
                System.out.printf("¡El jugador '%c' ha ganado!%n", jugadorActual);
                juegoActivo = false;
                break;
            }

            // Verificar empate
            empate = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == '-') {
                        empate = false;
                        break;
                    }
                }
                if (!empate) break;
            }

            if (empate) {
                System.out.println("\nTablero final:");
                for (char[] filaFinal : tablero) {
                    for (char celda : filaFinal) {
                        System.out.print(celda + " ");
                    }
                    System.out.println();
                }
                System.out.println("¡El juego ha terminado en empate!");
                juegoActivo = false;
                break;
            }

            // Cambiar turno
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }

        tcl.close();
    }
}
/*
run:

Tablero:
- - - 
- - - 
- - - 
Turno del jugador 'X'. Ingrese la fila y columna (1-3):
Fila: 1
Columna: 2

Tablero:
- X - 
- - - 
- - - 
Turno del jugador 'O'. Ingrese la fila y columna (1-3):
Fila: 2
Columna: 2

Tablero:
- X - 
- O - 
- - - 
Turno del jugador 'X'. Ingrese la fila y columna (1-3):
Fila: 1
Columna: 1

Tablero:
X X - 
- O - 
- - - 
Turno del jugador 'O'. Ingrese la fila y columna (1-3):
Fila: 1
Columna: 3

Tablero:
X X O 
- O - 
- - - 
Turno del jugador 'X'. Ingrese la fila y columna (1-3):
Fila: 2
Columna: 1

Tablero:
X X O 
X O - 
- - - 
Turno del jugador 'O'. Ingrese la fila y columna (1-3):
Fila: 3
Columna: 1

Tablero final:
X X O 
X O - 
O - - 
�El jugador 'O' ha ganado!
BUILD SUCCESSFUL (total time: 33 seconds)

*/