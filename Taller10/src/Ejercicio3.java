
/**
 * El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar el periodo,
 * la Dirección de la carrera de Computación a solicitado las siguientes estadísticas de la materia 
 * INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios por estudiante, dichos promedios se deben
 * calcular (ponderar, ya que el docente ingresa todo sobre 10pts.) de 3 calificaciones 
 * (ACD que representa el 35% de la nota, APE del 35% y la nota del AA con un peso del 30%). 
 * En resumen, los requerimientos son los siguientes:
 * Registre los nombres de cada estudiante de dicho paralelo.
 * Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
 * Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación: ACD->35%, APE->35%, y el AA->30%.
 * Obtenga el promedio del curso, del paralelo C.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
 * Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
 * Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
 * @author Daniel Matute
 */

import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        int NUM_ESTUDIANTES = 28;
        double PESO_ACD = 0.35,PESO_APE = 0.35,PESO_AA = 0.30,sumaPromedios,promedioCurso,mayorPromedio,menorPromedio;
        String estudianteMayor,estudianteMenor;
        String[] nombres = new String[NUM_ESTUDIANTES];
        double[] notasACD = new double[NUM_ESTUDIANTES];
        double[] notasAPE = new double[NUM_ESTUDIANTES];
        double[] notasAA = new double[NUM_ESTUDIANTES];
        double[] promedios = new double[NUM_ESTUDIANTES];

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            notasACD[i] = random.nextDouble() * 10;
            notasAPE[i] = random.nextDouble() * 10;
            notasAA[i] = random.nextDouble() * 10;

            promedios[i] = (notasACD[i] * PESO_ACD) + (notasAPE[i] * PESO_APE) + (notasAA[i] * PESO_AA);
        }

         sumaPromedios = 0;
        for (double promedio : promedios) {
            sumaPromedios += promedio;
        }
        promedioCurso = sumaPromedios / NUM_ESTUDIANTES;

     
         mayorPromedio = promedios[0];
         menorPromedio = promedios[0];
         estudianteMayor = nombres[0];
         estudianteMenor = nombres[0];

        for (int i = 1; i < NUM_ESTUDIANTES; i++) {
            if (promedios[i] > mayorPromedio) {
                mayorPromedio = promedios[i];
                estudianteMayor = nombres[i];
            }
            if (promedios[i] < menorPromedio) {
                menorPromedio = promedios[i];
                estudianteMenor = nombres[i];
            }
        }

        // Resultados
        System.out.printf("\nPromedio del curso: %.2f\n", promedioCurso);

        System.out.println("\nEstudiantes con promedio por encima del promedio del curso:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            if (promedios[i] > promedioCurso) {
                System.out.printf("%s: %.2f\n", nombres[i], promedios[i]);
            }
        }

        System.out.println("\nEstudiantes con promedio por debajo del promedio del curso:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            if (promedios[i] < promedioCurso) {
                System.out.printf("%s: %.2f\n", nombres[i], promedios[i]);
            }
        }

        System.out.printf("\nEstudiante con el mayor promedio: %s (%.2f)\n", estudianteMayor, mayorPromedio);
        System.out.printf("Estudiante con el menor promedio: %s (%.2f)\n", estudianteMenor, menorPromedio);
    }
}
/*
run:
Ingrese el nombre del estudiante 1: Daniel
Ingrese el nombre del estudiante 2: Pedro
Ingrese el nombre del estudiante 3: Carlos
Ingrese el nombre del estudiante 4: Sofia
Ingrese el nombre del estudiante 5: Karla
Ingrese el nombre del estudiante 6: Julian
Ingrese el nombre del estudiante 7: Jorge
Ingrese el nombre del estudiante 8: Juan
Ingrese el nombre del estudiante 9: Jesus
Ingrese el nombre del estudiante 10: Andres
Ingrese el nombre del estudiante 11: Anthony
Ingrese el nombre del estudiante 12: David
Ingrese el nombre del estudiante 13: Andrea
Ingrese el nombre del estudiante 14: Stefano
Ingrese el nombre del estudiante 15: Cesar
Ingrese el nombre del estudiante 16: Javier
Ingrese el nombre del estudiante 17: Josue
Ingrese el nombre del estudiante 18: Damian
Ingrese el nombre del estudiante 19: Pablo
Ingrese el nombre del estudiante 20: Sebastian
Ingrese el nombre del estudiante 21: William
Ingrese el nombre del estudiante 22: Hans
Ingrese el nombre del estudiante 23: Jhoel
Ingrese el nombre del estudiante 24: Jhordy
Ingrese el nombre del estudiante 25: Ian
Ingrese el nombre del estudiante 26: Camila
Ingrese el nombre del estudiante 27: Federica
Ingrese el nombre del estudiante 28: Ludovico

Promedio del curso: 4,86

Estudiantes con promedio por encima del promedio del curso:
Daniel: 5,36
Sofia: 7,34
Karla: 4,93
Jorge: 6,20
Juan: 5,71
Andres: 8,47
Javier: 7,38
Josue: 6,28
Damian: 5,34
Hans: 6,47
Jhoel: 5,17
Jhordy: 6,12
Camila: 5,00
Federica: 5,84
Ludovico: 6,99

Estudiantes con promedio por debajo del promedio del curso:
Pedro: 4,58
Carlos: 2,92
Julian: 1,94
Jesus: 4,33
Anthony: 2,71
David: 3,14
Andrea: 2,15
Stefano: 2,88
Cesar: 4,85
Pablo: 3,25
Sebastian: 3,98
William: 3,86
Ian: 2,85

Estudiante con el mayor promedio: Andres (8,47)
Estudiante con el menor promedio: Julian (1,94)
BUILD SUCCESSFUL (total time: 4 minutes 5 seconds)

*/