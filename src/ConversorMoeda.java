// Interface que define o contrato para conversões financeiras
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

// Classe que implementa a interface ConversaoFinanceira
public class ConversorMoeda implements ConversaoFinanceira {
    private double taxaDeCambio; // Taxa de câmbio atual

    // Construtor para definir a taxa de câmbio
    public ConversorMoeda(double taxaDeCambio) {
        this.taxaDeCambio = taxaDeCambio;
    }

    // Implementação do método para converter dólar para real
    @Override
    public double converterDolarParaReal(double valorEmDolar) {
        return valorEmDolar * taxaDeCambio;
    }

    // Método para obter a taxa de câmbio atual da API
    public static double obterTaxaDeCambioAtual() {
        String urlString = "https://api.exchangerate-api.com/v4/latest/USD"; // API pública de exemplo
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();

                JSONObject jsonObject = new JSONObject(inline.toString());
                return jsonObject.getJSONObject("rates").getDouble("BRL");
            } else {
                System.out.println("Erro ao obter a taxa de câmbio. Usando valor padrão.");
                return 5.25; // Valor padrão em caso de erro
            }
        } catch (IOException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            return 5.25; // Valor padrão em caso de erro
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Obtém a taxa de câmbio atual
        double taxaAtual = obterTaxaDeCambioAtual();
        System.out.println("Taxa de câmbio atual (1 dólar para real): " + taxaAtual);

        ConversorMoeda conversor = new ConversorMoeda(taxaAtual);

        // Solicita ao usuário o valor em dólares
        System.out.print("Informe o valor em dólares a ser convertido: ");
        double valorEmDolar = scanner.nextDouble();

        double valorEmReais = conversor.converterDolarParaReal(valorEmDolar);

        System.out.println("Valor em dólares: $" + valorEmDolar);
        System.out.println("Valor convertido em reais: R$" + valorEmReais);

        scanner.close();
    }
}
