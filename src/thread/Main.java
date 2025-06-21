package thread;

// Main.java
public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("--- Execução sem proteção ---");
        Contador contadorSemProtecao = new Contador(); // Novo contador para o teste sem proteção

        // Criando as duas threads para o cenário sem proteção
        MinhaThread thread1SemProtecao = new MinhaThread(contadorSemProtecao, false);
        MinhaThread thread2SemProtecao = new MinhaThread(contadorSemProtecao, false);

        // Iniciando as threads. Elas começam a executar o método 'run'.
        thread1SemProtecao.start();
        thread2SemProtecao.start();

        // Espera as threads terminarem suas execuções.
        // O 'join()' faz com que a thread principal (main) espere até que a thread 'thread1SemProtecao'
        // e 'thread2SemProtecao' terminem antes de continuar.
        thread1SemProtecao.join();
        thread2SemProtecao.join();

        // Imprime o resultado final. Esperaríamos 2000, mas será menor devido à condição de corrida.
        System.out.println("Valor final do contador sem proteção: " + contadorSemProtecao.getValor());
        System.out.println("-----------------------------\n");


        System.out.println("--- Execução com proteção (Lock) ---");
        Contador contadorComProtecao = new Contador(); // Novo contador para o teste com proteção

        // Criando as duas threads para o cenário com proteção
        MinhaThread thread1ComProtecao = new MinhaThread(contadorComProtecao, true);
        MinhaThread thread2ComProtecao = new MinhaThread(contadorComProtecao, true);

        // Iniciando as threads.
        thread1ComProtecao.start();
        thread2ComProtecao.start();

        // Espera as threads terminarem suas execuções.
        thread1ComProtecao.join();
        thread2ComProtecao.join();

        // Imprime o resultado final. Desta vez, será 2000 (o valor esperado).
        System.out.println("Valor final do contador com proteção: " + contadorComProtecao.getValor());
        System.out.println("------------------------------------\n");
    }
}