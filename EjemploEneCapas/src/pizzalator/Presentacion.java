package pizzalator;

import utilitarios.Utils;

/**
 * Clase que maneja la interfaz de usuario y la presentación de datos para Pizzalator.
 * Coordina la interacción con el usuario y muestra los resultados de los cálculos.
 * 
 * <p><b>Conceptos clave que enseña esta clase:</b>
 * <ul>
 *   <li>Menús interactivos y flujo de control</li>
 *   <li>Interacción con el usuario (entrada/salida)</li>
 *   <li>Integración entre capas (presentación → lógica → datos)</li>
 *   <li>Validación de datos antes de procesar</li>
 * </ul>
 */
public class Presentacion {

    /**
     * Método principal que inicia la aplicación y maneja el bucle del menú.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
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

    /**
     * Muestra el menú principal con las opciones disponibles.
     * Incluye opciones para registrar pizzas, ver historial y limpiar datos.
     */
    public static void mostrarMenuPrincipal() {
        Utils.limpiarConsola();
        System.out.println("\n** Menú Principal **".toUpperCase());
        System.out.println(String.format("%2d - %-20s", 1, "Registrar pizza"));
        System.out.println(String.format("%2d - %-20s", 2, "Ver historial"));
        System.out.println(String.format("%2d - %-20s", 3, "Limpiar datos"));
        System.out.println(String.format("%2d - %-20s", 0, "Salir"));
        System.out.print("Elija una opción (0-3): ");
    }

    /**
     * Registra una nueva pizza capturando todos los datos necesarios.
     * Muestra un resumen de los datos antes de confirmar el registro.
     * 
     * <p>Flujo de operación:
     * <ol>
     *   <li>Captura todos los datos de la pizza</li>
     *   <li>Muestra resumen para confirmación</li>
     *   <li>Si se confirma, procesa los datos y los guarda</li>
     *   <li>Muestra los resultados calculados</li>
     * </ol>
     */
    public static void registrarPizza() {
        String nombre = null, resultado = null;
        double tamaño = 0, anchoBorde = 0, precio = 0; 
        int numeroTajadas = 0;
        boolean pregunta = false;
        
        Utils.limpiarConsola();
        System.out.println("\n** Registro de Pizza **".toUpperCase());
        nombre = Utils.leerString("Digite el nombre la pizza: ");
        tamaño = Utils.leerDoble("Digite el tamaño en pulgadas de diametro: ");
        anchoBorde = Utils.leerDoble("Digite el ancho del borde en pulgadas: ");
        precio = Utils.leerDoble("Digite el precio: ");
        numeroTajadas = Utils.leerEntero("Digite la cantidad de tajadas: ");
        
        // Mostrar resumen para confirmación
        Utils.limpiarConsola();
        System.out.printf("%-20s : %-25s\n", "Nombre de la Pizza", nombre);
        System.out.printf("%-20s : %25.2f\n","Diametro (pulgadas)", tamaño);
        System.out.printf("%-20s : %25.2f\n","Borde (pulgadas)", anchoBorde);
        System.out.printf("%-20s : %25.2f\n","Precio (colones)", precio);
        System.out.printf("%-20s : %25d\n","Tajadas (unidades)", numeroTajadas);

        pregunta = Utils.leerBoolean("Son correctos los datos");
        if (pregunta) {
            resultado = Logica.procesarInfoPizza(nombre, tamaño, anchoBorde, precio, numeroTajadas);
            System.out.println("\n** Resultados registrados**".toUpperCase());
            System.out.println(Logica.obtenerEncabezadoInfoPizza());
            System.out.println(resultado);
            Datos.guardarDatos(resultado);
        } else {
            System.out.println("No se registrarán los datos");
        }

        Utils.pausar();
    }

    /**
     * Muestra todo el historial de pizzas registradas en formato de tabla.
     * Utiliza el formato de encabezado definido en la clase Logica.
     */
    public static void mostrarHistorial() {
        Utils.limpiarConsola();
        System.out.println("\n** Ver historial **".toUpperCase());
        System.out.println(Logica.obtenerEncabezadoInfoPizza());
        System.out.println(Datos.obtenerHistorial());
        Utils.pausar();
    }

    /**
     * Elimina todos los datos del historial previa confirmación del usuario.
     * 
     * @implNote Solicita confirmación antes de borrar los datos
     */
    public static void eliminarHistorial() {
        Utils.limpiarConsola();
        boolean condicion;
        condicion = Utils.leerBoolean("Desea eliminar los datos registrados");
        if (condicion) {
            Datos.limpiarDatos();
            System.out.println("Datos eliminados");
        } else {
            System.out.println("No se han eliminado los datos");
        }
        Utils.pausar();
    }
}

// Para generar el javadoc
//javadoc -d docs -sourcepath src -subpackages pizzalator