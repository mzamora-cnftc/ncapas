package pizzalator;

public class Datos {
    private static StringBuilder datos = new StringBuilder();

    public static void limpiarDatos() {
        if (datos.length() > 0) {
            datos.delete(0, datos.length() - 1);
        }

    }

    public static void guardarDatos(String dato) {
        if (datos.length() > 0) {
            datos.append("\n");
        }
        datos.append(dato);
    }

    public static String obtenerHistorial() {
        return datos.toString();
    }
}