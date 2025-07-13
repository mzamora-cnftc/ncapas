package pizzalator;

public class Logica {

    public static String procesarInfoPizza(String nombre, double tamaño, double anchoBorde, double precio,
            double numeroTajadas) {
        String salida = null;
        double porcentajeBorde = 0, precioRelleno = 0, precioBorde, precioTajadaRelleno = 0, precioTajadaBorde = 0;
        porcentajeBorde = calcularPorcentajeAreaBorde(tamaño / 2, anchoBorde);
        salida = String.format("%-20s %-6s %-8s", "Nombre", "Tamaño", "Precio");
        salida = String.format("%-20s %5.2f\" \u20A1%8.2f", nombre, tamaño, precio);
        return salida;
    }

    /**
     * Calcula el área de un círculo
     * 
     * @param radio Radio del círculo
     * @return Área del círculo
     */
    public static double calcularArea(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    /**
     * Esta función calcula el porcetaje (de 0.0 a 1.0) del área del borde respecto
     * a la pizza
     * 
     * @param radio      Radio de la pizza
     * @param anchoBorde Ancho del borde
     * @return Porcentaje de 0.0 a 1.0 (1.0 es 100%) del borde de la pizza
     */
    public static double calcularPorcentajeAreaBorde(double radio, double anchoBorde) {
        double areaTotal, areaBorde, porcentaje;

        areaTotal = calcularArea(radio);
        areaBorde = calcularDiferenciasAreas(radio, radio - anchoBorde);
        porcentaje = areaBorde / areaTotal;

        return porcentaje;
    }

    /**
     * Calcula la diferencia del área de dos círculos. La función determina el
     * círculo mayor y menor.
     * 
     * @param radio1 Radio del primer círculo
     * @param radio2 Radio del segundo círculo
     * @return La diferencia del área.
     */
    public static double calcularDiferenciasAreas(double radio1, double radio2) {
        double area1, area2, diferencia;

        area1 = calcularArea(Math.max(radio1, radio2));
        area2 = calcularArea(Math.min(radio1, radio2));
        diferencia = area1 - area2;

        return diferencia;
    }

}