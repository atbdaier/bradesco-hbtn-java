public class ProgramForma {
    public static void main(String[] args) {
        FormaGeometrica formaGeometrica = new FormaGeometrica();

        try {
            System.out.printf("Area: %d", formaGeometrica.area());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
