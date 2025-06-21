package thread;

// Main.java
public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("--- Execução sem proteção ---");
        Contador contadorSemProtecao = new Contador();

        MinhaThread thread1SemProtecao = new MinhaThread(contadorSemProtecao, false);
        MinhaThread thread2SemProtecao = new MinhaThread(contadorSemProtecao, false);

        thread1SemProtecao.start();
        thread2SemProtecao.start();

        thread1SemProtecao.join();
        thread2SemProtecao.join();

        System.out.println("Valor final do contador sem proteção: " + contadorSemProtecao.getValor());
        System.out.println("-----------------------------\n");


        System.out.println("--- Execução com proteção (Lock) ---");
        Contador contadorComProtecao = new Contador(); // Novo contador para o teste com proteção

        MinhaThread thread1ComProtecao = new MinhaThread(contadorComProtecao, true);
        MinhaThread thread2ComProtecao = new MinhaThread(contadorComProtecao, true);

        thread1ComProtecao.start();
        thread2ComProtecao.start();

        thread1ComProtecao.join();
        thread2ComProtecao.join();

        System.out.println("Valor final do contador com proteção: " + contadorComProtecao.getValor());
        System.out.println("------------------------------------\n");
    }
}