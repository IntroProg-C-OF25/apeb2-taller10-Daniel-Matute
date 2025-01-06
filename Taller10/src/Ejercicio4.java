
/**
 * Crea un programa que gestione el inventario de una tienda. Utiliza una matriz bidimensional para almacenar
 * los productos disponibles en la tienda, con información como nombre, precio y cantidad.
 * El programa debe permitir agregar nuevos productos, actualizar existencias,
 * buscar productos y eliminarlos.
 *
 * @author Daniel Matute
 */
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String[][] inventario = new String[100][3];
        int numProductos = 0;
        int opcion;
        boolean encontrado;

        while (true) {
            System.out.println("\n--- Menú de Gestión de Inventario ---");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            
            if (!tcl.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                tcl.nextLine(); 
                continue;
            }
            opcion = tcl.nextInt();
            tcl.nextLine(); 

            switch (opcion) {
                case 1: // Agregar nuevo producto
                    if (numProductos < inventario.length) {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = tcl.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        String precio = tcl.nextLine();
                        System.out.print("Ingrese la cantidad del producto: ");
                        String cantidad = tcl.nextLine();

                        inventario[numProductos][0] = nombre;
                        inventario[numProductos][1] = precio;
                        inventario[numProductos][2] = cantidad;
                        numProductos++;

                        System.out.println("Producto agregado exitosamente.");
                    } else {
                        System.out.println("El inventario está lleno.");
                    }
                    break;

                case 2: // Actualizar 
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String nombreActualizar = tcl.nextLine();
                    encontrado = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreActualizar)) {
                            System.out.print("Ingrese la nueva cantidad: ");
                            inventario[i][2] = tcl.nextLine();
                            System.out.println("Cantidad actualizada exitosamente.");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3: // Buscar producto
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombreBuscar = tcl.nextLine();
                    encontrado = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreBuscar)) {
                            System.out.printf("Producto encontrado: Nombre: %s | Precio: $%s | Cantidad: %s%n",
                                    inventario[i][0], inventario[i][1], inventario[i][2]);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4: // Eliminar producto
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = tcl.nextLine();
                    encontrado = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreEliminar)) {
                            for (int j = i; j < numProductos - 1; j++) {
                                inventario[j][0] = inventario[j + 1][0];
                                inventario[j][1] = inventario[j + 1][1];
                                inventario[j][2] = inventario[j + 1][2];
                            }
                            numProductos--;
                            System.out.println("Producto eliminado exitosamente.");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5: // Mostrar inventario
                    System.out.println("\n   Inventario de Productos   ");
                    if (numProductos == 0) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        for (int i = 0; i < numProductos; i++) {
                            System.out.printf("Nombre: %s | Precio: $%s | Cantidad: %s%n",
                                    inventario[i][0], inventario[i][1], inventario[i][2]);
                        }
                    }
                    break;

                case 6: // Salir
                    System.out.println("Gracias por usar el sistema de gestión de inventario.");
                    tcl.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
/*
run:

--- Men� de Gesti�n de Inventario ---
1. Agregar nuevo producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Seleccione una opci�n: 1
Ingrese el nombre del producto: cocacola
Ingrese el precio del producto: 1
Ingrese la cantidad del producto: 10
Producto agregado exitosamente.

--- Men� de Gesti�n de Inventario ---
1. Agregar nuevo producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Seleccione una opci�n: 6
Gracias por usar el sistema de gesti�n de inventario.
BUILD SUCCESSFUL (total time: 29 seconds)
*/