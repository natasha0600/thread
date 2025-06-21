package thread;

public class MinhaThread extends Thread {
    private Contador contador;
    private boolean usarProtecao;

    public MinhaThread(Contador contador, boolean usarProtecao) {
        this.contador = contador;
        this.usarProtecao = usarProtecao;
    }

    // O método 'run' é onde o código da thread é executado.
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) { // Cada thread incrementa 1000 vezes
            if (usarProtecao) {
                contador.incrementarComProtecao();
            } else {
                contador.incrementarSemProtecao();
            }
        }
    }
}