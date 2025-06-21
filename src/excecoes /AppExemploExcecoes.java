package excecoes; 
import java.util.Scanner; 

/**
 * Classe principal que demonstra o tratamento de exceções em Java,
 * incluindo divisão por zero e uma exceção personalizada de idade.
 */
public class AppExemploExcecoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Exemplo 1: Tratamento de Divisão por Zero ---
        System.out.println("--- Teste de Divisão ---");
        System.out.print("Digite o numerador: ");
        int numerador = scanner.nextInt();

        System.out.print("Digite o divisor: ");
        int divisor = scanner.nextInt();

        // Chama o método de divisão de outra classe no mesmo pacote
        TratamentoDivisaoPorZero.realizarDivisao(numerador, divisor);
        System.out.println(); 

        // --- Exemplo 2: Exceção Personalizada IdadeInvalidaException ---
        System.out.println("--- Teste de Idade ---");
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        try {
            // Chama o método que pode disparar a exceção personalizada
            verificarIdade(idade);
            System.out.println("Idade válida. Você tem " + idade + " anos.");
        } catch (IdadeInvalidaException e) {
            // Captura e exibe a mensagem da exceção personalizada
            System.out.println("Erro de idade: " + e.getMessage());
        } finally {
            // Garante que o Scanner seja fechado
            scanner.close();
            System.out.println("Aplicação finalizada.");
        }
    }

    /**
     * Verifica se a idade fornecida está dentro dos limites válidos (18 a 100 anos).
     * Se a idade for inválida, uma IdadeInvalidaException é disparada.
     * @param idade A idade a ser verificada.
     * @throws IdadeInvalidaException Se a idade for menor que 18 ou maior que 100.
     */
    public static void verificarIdade(int idade) throws IdadeInvalidaException {
        if (idade < 18 || idade > 100) {
            throw new IdadeInvalidaException("A idade deve estar entre 18 e 100 anos.");
        }
        // Se a idade estiver dentro dos limites, nenhuma exceção é disparada.
    }
}
