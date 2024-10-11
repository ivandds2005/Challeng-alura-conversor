import java.util.Map;

public class TasaDeCambio {
    private String base_code; // Moneda base (ej: "COP")
    private Map<String, Double> rates; // Mapa que contiene las tasas de cambio a otras monedas

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}

