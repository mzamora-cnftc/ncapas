public class Logica {
    public static String sumar(double a, double b) {
        return a + " + " + b + " = " + (a + b);
    }
    
    public static String restar(double a, double b) {
        return a + " - " + b + " = " + (a - b);
    }
    
    public static String multiplicar(double a, double b) {
        return a + " * " + b + " = " + (a * b);
    }
    
    public static String dividir(double a, double b) {
        if (b == 0) {
            return "Error: División por cero";
        }
        return a + " / " + b + " = " + (a / b);
    }
}