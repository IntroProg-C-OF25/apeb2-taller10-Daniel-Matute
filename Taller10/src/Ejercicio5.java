
/**
 * Crea un programa que gestione el inventario de una tienda, así como la emisión de facturas.
 * Utiliza una matriz bidimensional para almacenar los productos disponibles en la tienda,
 * con información como nombre, precio y cantidad. El programa debe permitir facturar un producto dado
 * su código, y unidades deseadas. Adicional se debe agregar a la factura al 15% del IVA, y si la compra
 * superar los $100, se debe aplicar un descuento.
 * xNota: Considere la alternativa de inexistencias en Stop, para el caso, muestre la alerta respectiva.
 *
 * @author Daniel Matute
 */
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        // Configuración inicial del inventario
        int max_productos = 100; // Capacidad máxima del inventario
        String[][] inventario = new String[max_productos][3];
        int numProductos = 0, opcion, codigo, indiceProducto, cantidadDeseada, cantidadDisponible;
        double IVA = 0.15, DESCUENTO = 0.10, precioUnitario, subtotal, impuestoIVA, descuento, total;
        String nombre, precio, cantidad;

        while (true) {
            System.out.println("\n   Menu de Gestion de Tienda   ");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Facturar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = tcl.nextInt();
            tcl.nextLine();

            switch (opcion) {
                case 1:
                    // Agregar nuevo producto
                    if (numProductos < max_productos) {
                        System.out.print("Ingrese el nombre del producto: ");
                        nombre = tcl.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        precio = tcl.nextLine();
                        System.out.print("Ingrese la cantidad del producto: ");
                        cantidad = tcl.nextLine();

                        inventario[numProductos][0] = nombre;
                        inventario[numProductos][1] = precio;
                        inventario[numProductos][2] = cantidad;
                        numProductos++;
                        System.out.println("Producto agregado exitosamente.");
                    } else {
                        System.out.println("El inventario está lleno.");
                    }
                    break;

                case 2:
                    // Mostrar inventario
                    System.out.println("\n--- Inventario de Productos ---");
                    if (numProductos == 0) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        for (int i = 0; i < numProductos; i++) {
                            System.out.printf("Codigo: %d | Nombre: %s | Precio: $%s | Cantidad: %s%n" + i + 1, inventario[i][0], inventario[i][1], inventario[i][2]);
                        }
                    }
                    break;

                case 3:
                    // Facturar producto
                    System.out.print("Ingrese el codigo del producto: ");
                    codigo = tcl.nextInt();
                    tcl.nextLine(); // Consumir el salto de línea

                    if (codigo <= 0 || codigo > numProductos) {
                        System.out.println("Codigo de producto no valido.");
                        break;
                    }

                    indiceProducto = codigo - 1;
                    System.out.printf("Producto seleccionado: %s%n", inventario[indiceProducto][0]);
                    System.out.print("Ingrese la cantidad deseada: ");
                    cantidadDeseada = tcl.nextInt();

                    cantidadDisponible = Integer.parseInt(inventario[indiceProducto][2]);

                    if (cantidadDeseada > cantidadDisponible) {
                        System.out.println("Alerta: No hay suficientes existencias para completar la compra.");
                    } else {
                        // Calcular subtotal, IVA, descuento, y total
                        precioUnitario = Double.parseDouble(inventario[indiceProducto][1]);
                        subtotal = precioUnitario * cantidadDeseada;
                        impuestoIVA = subtotal * IVA;
                        descuento = (subtotal > 100) ? subtotal * DESCUENTO : 0;
                        total = subtotal + impuestoIVA - descuento;

                        inventario[indiceProducto][2] = String.valueOf(cantidadDisponible - cantidadDeseada);

                        // Mostrar factura
                        System.out.println("\n--- Factura ---");
                        System.out.printf("Producto: %s%n", inventario[indiceProducto][0]);
                        System.out.printf("Cantidad: %d%n", cantidadDeseada);
                        System.out.printf("Precio unitario: $%.2f%n", precioUnitario);
                        System.out.printf("Subtotal: $%.2f%n", subtotal);
                        System.out.printf("IVA (15%%): $%.2f%n", impuestoIVA);
                        if (descuento > 0) {
                            System.out.printf("Descuento (10%%): -$%.2f%n", descuento);
                        }
                        System.out.printf("Total a pagar: $%.2f%n", total);
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema de gestion de tienda.");
                    tcl.close();
                    return;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        }
    }
}
/*
Menu de Gestion de Tienda   
1. Agregar nuevo producto
2. Mostrar inventario
3. Facturar producto
4. Salir
Seleccione una opci�n: 1
Ingrese el nombre del producto: cocacola
Ingrese el precio del producto: 1
Ingrese la cantidad del producto: 10
Producto agregado exitosamente.

   Menu de Gestion de Tienda   
1. Agregar nuevo producto
2. Mostrar inventario
3. Facturar producto
4. Salir
Seleccione una opci�n: 3
Ingrese el codigo del producto: 1
Producto seleccionado: cocacola
Ingrese la cantidad deseada: 2

--- Factura ---
Producto: cocacola
Cantidad: 2
Precio unitario: $1,00
Subtotal: $2,00
IVA (15%): $0,30
Total a pagar: $2,30

   Menu de Gestion de Tienda   
1. Agregar nuevo producto
2. Mostrar inventario
3. Facturar producto
4. Salir
Seleccione una opci�n: 4
Gracias por usar el sistema de gestion de tienda.
BUILD SUCCESSFUL (total time: 48 seconds)

*/
