public class Produtor extends Thread {
    private Fila fila;
    private int id;

    public Produtor(Fila fila, int id) {
        this.fila = fila;
        this.id = id;
    }

    @Override
    public void run() {
        while(true){
            int numeroAleatorio = generateRandom();
            fila.adicionar(numeroAleatorio);
            System.out.println("Produtor " + id + " produziu: " + numeroAleatorio );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private int generateRandom() {
        return (int)(Math.random() * 100);
    }

}