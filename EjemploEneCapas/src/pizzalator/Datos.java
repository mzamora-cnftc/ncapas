package pizzalator;

/**
 * Clase que maneja el almacenamiento y gestión de datos en memoria para la aplicación Pizzalator.
 * Utiliza un {@link StringBuilder} como estructura principal para almacenar el historial de datos.
 * 
 * <p>Esta clase es un ejemplo simplificado para enseñar:
 * <ul>
 *   <li>Uso de variables estáticas</li>
 *   <li>Manejo de cadenas con {@link StringBuilder}</li>
 *   <li>Concepto de encapsulamiento</li>
 * </ul>
 * 
 * <p><b>Nota para estudiantes:</b> En aplicaciones reales, los datos normalmente se guardarían
 * en bases de datos o archivos, no en memoria.
 */
public class Datos {
    private static StringBuilder datos = new StringBuilder();

    /**
     * Limpia todos los datos almacenados en el historial.
     * Si el historial está vacío, no realiza ninguna acción.
     */
    public static void limpiarDatos() {
        if (datos.length() > 0) {
            datos.delete(0, datos.length());
        }
    }

    /**
     * Guarda un nuevo dato en el historial.
     * Si el historial no está vacío, añade un salto de línea antes del nuevo dato.
     * 
     * @param dato El texto que se desea almacenar (no puede ser nulo)
     * @implNote Ejemplo de uso: {@code guardarDatos("Pizza Margherita")}
     */
    public static void guardarDatos(String dato) {
        if (datos.length() > 0) {
            datos.append("\n");
        } 
        datos.append(dato);
    }

    /**
     * Devuelve todo el historial de datos almacenados como una sola cadena.
     * 
     * @return Cadena con todos los datos separados por saltos de línea.
     *         Si no hay datos, retorna una cadena vacía ("").
     */
    public static String obtenerHistorial() {
        return datos.toString();
    }
}