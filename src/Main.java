import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolInventario inventario = new ArbolInventario();
        int opcion = -1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (opcion != 0) {
                System.out.println("\n==================================");
                System.out.println("    SISTEMA DE INVENTARIO TREE-STOCK");
                System.out.println("==================================");
                System.out.println("1. Registrar Producto");
                System.out.println("2. Mostrar Inventario (Inorden)");
                System.out.println("3. Buscar Producto");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Entrada no válida. Ingrese un número.");
                    scanner.nextLine();
                    continue;
                }

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese ID del producto: ");
                        if (scanner.hasNextInt()) {
                            int id = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Ingrese Nombre del producto: ");
                            String nombre = scanner.nextLine();
                            inventario.insertar(id, nombre);
                        } else {
                            System.out.println("El ID debe ser un número entero.");
                            scanner.nextLine();
                        }
                    }
                    case 2 -> {
                        System.out.println("\n--- INVENTARIO ORDENADO POR ID ---");
                        inventario.recorridoInorden();
                    }
                    case 3 -> {
                        System.out.print("Ingrese el ID a buscar: ");
                        if (scanner.hasNextInt()) {
                            int idBuscar = scanner.nextInt();
                            scanner.nextLine();
                            
                            Producto encontrado = inventario.buscar(idBuscar);
                            if (encontrado != null) {
                                System.out.println("\n[!] Producto Encontrado: ID: " 
                                    + encontrado.id + " - Nombre: " + encontrado.nombre);
                            } else {
                                System.out.println("\n[X] El producto con ID " + idBuscar + " No se ha encontrado.");
                            }
                        } else {
                            System.out.println("El ID a buscar debe ser un número entero.");
                            scanner.nextLine();
                        }
                    }
                    case 0 -> System.out.println("Saliendo de Tree-Stock...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }
}