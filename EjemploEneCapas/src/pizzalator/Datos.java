package pizzalator;

public class Datos {
    private static String[] historial = new String[100];  // Arreglo fijo
    private static int contador = 0;  // Lleva la cuenta de operaciones guardadas
    
    // Guarda una operación en el arreglo
    public static void guardarOperacion(String operacion) {
        if (contador < historial.length) {
            historial[contador] = operacion;
            contador++;
        } else {
            System.out.println("Historial lleno. No se guardó la operación.");
        }
    }
    
    // Devuelve el historial como un solo String
    public static String obtenerHistorial() {
        String resultado = "\n--- Historial de Operaciones ---\n";
        for (int i = 0; i < contador; i++) {
            resultado += historial[i] + "\n";
        }
        return resultado + "-----------------------------";
    }
}