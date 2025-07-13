package pizzalator;

import utilitarios.Utils;

public class Presentacion {

    public static void main(String[] args) {
        int opcionPrincipal;
        do {
            mostrarMenuPrincipal();
            opcionPrincipal = Utils.leerEntero("Digite su opción: ");

            switch (opcionPrincipal) {
                case 1:
                    registrarPizza();
                    break;
                case 2:
                    mostrarHistorial();
                    break;
                case 3:
                    eliminarHistorial();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcionPrincipal != 0);

    }

    // Muestra el menú principal
    public static void mostrarMenuPrincipal() {
        Utils.limpiarConsola();
        System.out.println("\n** Menú Principal **".toUpperCase());
        System.out.println(String.format("%2d - %-20s", 1, "Registrar pizza"));
        System.out.println(String.format("%2d - %-20s", 2, "Ver historial"));
        System.out.println(String.format("%2d - %-20s", 3, "Limpiar datos"));
        System.out.println(String.format("%2d - %-20s", 0, "Salir"));
        System.out.print("Elija una opción (1-3): ");
    }

    public static void registrarPizza() {

        String nombre;
        double tamaño, anchoBorde, precio; 
        int numeroTajadas;
        Utils.limpiarConsola();
        System.out.println("\n** Menú Principal **".toUpperCase());
        nombre = Utils.leerString("Digite el nombre la pizza: ");
        tamaño = Utils.leerDoble("Digite el tamaño en pulgadas de diametro: ");
        anchoBorde = Utils.leerDoble("Digite el ancho del borde en pulgadas: ");
        precio = Utils.leerDoble("Digite el precio: ");
        numeroTajadas = Utils.leerEntero("Digite la cantidad de tajadas: ");
        String resultado = Logica.procesarInfoPizza(nombre, tamaño, anchoBorde, precio, numeroTajadas);
        Utils.limpiarConsola();
        System.out.println("\n** Resultados **".toUpperCase());
        System.out.println(resultado);
        Datos.guardarDatos(resultado);
        Utils.pausar();
    }

    public static void mostrarHistorial() {
        Utils.limpiarConsola();
        System.out.println("\n** Ver historial **".toUpperCase());
        System.out.println(Datos.obtenerHistorial());
        Utils.pausar();
    }

    public static void eliminarHistorial() {
        Utils.limpiarConsola();
        boolean condicion;
        condicion = Utils.leerBoolean("Desea eliminar los datos registrados");
        if (condicion) {
            Datos.limpiarDatos();
            System.out.println("Datos elminados");
        } else {
            System.out.println("No se han elimnado los datos");
        }
        Utils.pausar();
    }

}