import java.util.Scanner;

public class Presentacion {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcionPrincipal;
        do {
            mostrarMenuPrincipal();
            opcionPrincipal = scanner.nextInt();
            
            switch (opcionPrincipal) {
                case 1:
                    manejarOperaciones();
                    break;
                case 2:
                    System.out.println(Datos.obtenerHistorial());
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcionPrincipal != 3);
        
        scanner.close();
    }
    
    // Muestra el menú principal
    public static void mostrarMenuPrincipal() {
        System.out.println("\n** Menú Principal **");
        System.out.println("1. Realizar operación");
        System.out.println("2. Ver historial");
        System.out.println("3. Salir");
        System.out.print("Elija una opción (1-3): ");
    }
    
    // Maneja el submenú de operaciones
    public static void manejarOperaciones() {
        double[] numeros = leerNumeros();
        System.out.println("\n** Operaciones Disponibles **");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print("Elija una opción (1-4): ");
        
        int opcion = scanner.nextInt();
        String resultado = "";
        
        switch (opcion) {
            case 1:
                resultado = Logica.sumar(numeros[0], numeros[1]);
                break;
            case 2:
                resultado = Logica.restar(numeros[0], numeros[1]);
                break;
            case 3:
                resultado = Logica.multiplicar(numeros[0], numeros[1]);
                break;
            case 4:
                resultado = Logica.dividir(numeros[0], numeros[1]);
                break;
            default:
                resultado = "Opción inválida";
        }
        
        System.out.println("Resultado: " + resultado);
        Datos.guardarOperacion(resultado);  // Guarda en el arreglo
    }
    
    // Lee los dos números (reutilizado del ejemplo anterior)
    public static double[] leerNumeros() {
        double[] numeros = new double[2];
        System.out.print("Ingrese el primer número: ");
        numeros[0] = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        numeros[1] = scanner.nextDouble();
        return numeros;
    }
}