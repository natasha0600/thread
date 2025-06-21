package excecoes; 

public class TratamentoDivisaoPorZero {

    /**
     * Realiza uma divisão e captura a exceção ArithmeticException em caso de divisão por zero.
     * Exibe uma mensagem se o divisor for zero.
     * @param numerador O número a ser dividido.
     * @param divisor O número pelo qual dividir.
     */
    public static void realizarDivisao(int numerador, int divisor) {
        try {
            int resultado = numerador / divisor;
            System.out.println("Resultado da divisão: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: não é possível dividir por zero!"); 
        }
    }
}