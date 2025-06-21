package thread;

public class Contador {

    public volatile int valor = 0;

    private final Object lock = new Object();

    public void incrementarSemProtecao() {
        valor++; // Esta operação (ler, incrementar, escrever) não é atômica!
    }

    public void incrementarComProtecao() {
        synchronized (lock) {
            valor++;
        }
    }

    public int getValor() {
        return valor;
    }
}