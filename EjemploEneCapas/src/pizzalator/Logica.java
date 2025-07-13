package pizzalator;

/**
 * Clase que contiene la lógica de cálculo y formato para la aplicación Pizzalator.
 * Realiza operaciones matemáticas relacionadas con pizzas y formatea los resultados
 * para su presentación.
 * 
 * <p><b>Conceptos clave que enseña esta clase:</b>
 * <ul>
 *   <li>Métodos estáticos y utilitarios</li>
 *   <li>Cálculos matemáticos con geometría básica</li>
 *   <li>Formateo de cadenas complejas</li>
 *   <li>Organización de código en métodos especializados</li>
 * </ul>
 */
public class Logica {

    /**
     * Genera el encabezado para la tabla de información de pizzas.
     * 
     * @return Cadena formateada con los títulos de las columnas alineados
     * @implNote Ejemplo de salida: "Nombre              Tamaño  Precio    Borde   % Borde  Pulg.²  ₡/Pulg.² Tajadas  ₡/Taj."
     */
    public static String obtenerEncabezadoInfoPizza() {
        return String.format("%-20s %-6s  %-9s %-8s  %-8s %-7s %-8s %-7s %-7s",
                "Nombre", "Tamaño", "Precio", "Borde", "% Borde", "Pulg.\u00B2", "\u20A1/Pulg.\u00B2", "Tajadas",
                "\u20A1/Taj.");
    }

    /**
     * Procesa toda la información de una pizza y la formatea para visualización.
     * 
     * @param nombre Nombre de la pizza (ej: "Hawaiana")
     * @param tamaño Diámetro de la pizza en pulgadas
     * @param anchoBorde Ancho del borde en pulgadas
     * @param precio Precio total en colones
     * @param numeroTajadas Cantidad de tajadas en que se divide
     * @return Cadena formateada con todos los datos calculados
     * @throws IllegalArgumentException Si algún parámetro es inválido (<= 0)
     */
    public static String procesarInfoPizza(String nombre, double tamaño, double anchoBorde, double precio,
            double numeroTajadas) {
        // Validación básica de parámetros
        if (tamaño <= 0 || anchoBorde <= 0 || precio <= 0 || numeroTajadas <= 0) {
            throw new IllegalArgumentException("Todos los valores numéricos deben ser positivos");
        }

        double porcentajeBorde = calcularPorcentajeAreaBorde(tamaño / 2, anchoBorde);
        double area = calcularArea(tamaño / 2);
        double ratioPrecioArea = precio / area;
        double precioPorTajada = precio / numeroTajadas;

        return String.format("%-20s %6.2f\" \u20A1%08.2f %7.2f\" %8.2f%% %7.2f %7.2f %7.2f %7.2f",
                nombre, tamaño, precio, anchoBorde,
                porcentajeBorde * 100, area, ratioPrecioArea, numeroTajadas, precioPorTajada);
    }

    /**
     * Calcula el área de un círculo usando su radio.
     * 
     * @param radio Radio del círculo en pulgadas
     * @return Área en pulgadas cuadradas (in²)
     * @implNote Fórmula: π × r²
     * @example calcularArea(5) → 78.53981633974483
     */
    public static double calcularArea(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    /**
     * Calcula el porcentaje del área total que ocupa el borde de la pizza.
     * 
     * @param radio Radio total de la pizza (desde centro hasta borde exterior)
     * @param anchoBorde Ancho de la sección de borde
     * @return Porcentaje entre 0.0 (0%) y 1.0 (100%)
     * @implNote Calcula (ÁreaBorde/ÁreaTotal)
     */
    public static double calcularPorcentajeAreaBorde(double radio, double anchoBorde) {
        if (anchoBorde >= radio) {
            return 1.0; // Caso extremo: toda la pizza es borde
        }
        double areaTotal = calcularArea(radio);
        double areaBorde = calcularDiferenciasAreas(radio, radio - anchoBorde);
        return areaBorde / areaTotal;
    }

    /**
     * Calcula la diferencia de áreas entre dos círculos concéntricos.
     * 
     * @param radio1 Radio del círculo mayor
     * @param radio2 Radio del círculo menor
     * @return Área del anillo resultante (área mayor - área menor)
     * @implNote Ordena automáticamente los radios para evitar valores negativos
     */
    public static double calcularDiferenciasAreas(double radio1, double radio2) {
        double radioMayor = Math.max(radio1, radio2);
        double radioMenor = Math.min(radio1, radio2);
        return calcularArea(radioMayor) - calcularArea(radioMenor);
    }
}