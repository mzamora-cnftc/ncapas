package pizzalator;

public class Logica {

    public static String obtenerEncabezadoInfoPizza() {
        return String.format("%-20s %-6s  %-9s %-8s  %-8s %-7s %-8s %-7s %-7s",
                "Nombre", "Tamaño", "Precio", "Borde", "% Borde", "Pulg.\u00B2", "\u20A1/Pulg.\u00B2", "Tajadas",
                "\u20A1/Taj.");
    }

    public static String procesarInfoPizza(String nombre, double tamaño, double anchoBorde, double precio,
            double numeroTajadas) {
        String salida = null;
        double porcentajeBorde = 0, area = 0, ratio = 0, precioTajada;
        porcentajeBorde = calcularPorcentajeAreaBorde(tamaño / 2, anchoBorde);
        area = calcularArea(tamaño / 2);
        ratio = precio / area;
        precioTajada = precio / numeroTajadas;

        salida = String.format("%-20s %6.2f\" \u20A1%08.2f %7.2f\" %8.2f%% %7.2f %7.2f %7.2f %7.2f",
                nombre, tamaño, precio, anchoBorde,
                porcentajeBorde * 100, area, ratio, numeroTajadas, precioTajada);
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