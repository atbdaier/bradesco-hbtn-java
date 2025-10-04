public class SistemaFilas {
    public static void main(String[] args) throws InterruptedException {
        Fila fila = new Fila(10);

        Produtor p1 = new Produtor(fila, 1);
        Produtor p2 = new Produtor(fila, 2);
        Consumidor c1 = new Consumidor(fila, 1);
        Consumidor c2 = new Consumidor(fila, 2);

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        Thread.sleep(20000);
        System.exit(0);
    }
}