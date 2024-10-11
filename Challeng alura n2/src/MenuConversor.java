import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

public class MenuConversor {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("Bienvenido al Conversor de Monedas.");
        System.out.println("1. Convertir de COP a otra moneda");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                convertirMoneda();
                break;
            case 2:
                System.out.println("Gracias por usar el conversor.");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public void convertirMoneda() {
        // Supongamos que obtienes este JSON de una API de tasas de cambio
        String jsonResponse = "{ \"base_code\": \"COP\", \"rates\": { \"USD\": 0.00025, \"EUR\": 0.00023, \"GBP\": 0.00021 } }";

        // Crear una instancia de Gson
        Gson gson = new Gson();

        // Convertir el JSON en un objeto Java
        TasaDeCambio tasaDeCambio = gson.fromJson(jsonResponse, TasaDeCambio.class);

        // Mostrar las tasas de cambio disponibles
        System.out.println("Tasas disponibles: ");
        for (Map.Entry<String, Double> entry : tasaDeCambio.getRates().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Pedir la cantidad en COP
        System.out.print("Ingrese la cantidad de COP a convertir: ");
        double cantidadCop = scanner.nextDouble();

        // Pedir la moneda a la que se desea convertir
        System.out.print("Seleccione la moneda a la cual convertir (USD, EUR, GBP): ");
        String moneda = scanner.next().toUpperCase();

        // Obtener la tasa de conversión correspondiente
        Double tasaConversion = tasaDeCambio.getRates().get(moneda);
        if (tasaConversion != null) {
            double montoConvertido = cantidadCop * tasaConversion;
            System.out.println("Monto convertido: " + montoConvertido + " " + moneda);
        } else {
            System.out.println("Moneda no disponible.");
        }
    }
}
