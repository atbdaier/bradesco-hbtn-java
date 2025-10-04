
import java.util.LinkedList;

public class Fila {
    private final int limiteMaximo;
    private LinkedList<Integer> fila;

    public Fila(int capacidade) {
        limiteMaximo = capacidade;
        fila = new LinkedList<>();
    }

    public synchronized void adicionar(int valor) {
        if(fila.size() == limiteMaximo) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        fila.add(valor);
        notifyAll();
    }

    public synchronized int remover() throws InterruptedException {
        while (fila.isEmpty()) {
            wait();
        }
        int r =  fila.removeFirst();
        notifyAll();
        return r;
    }
}
