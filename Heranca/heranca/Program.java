package Heranca.heranca;

public class Program {

    public static void main(String[] args) {
        Animal meuAnimal = new Animal();
        Cachorro meuCachorro = new Cachorro();
        Object obj = meuCachorro;
        Animal umOutroAnimal = meuCachorro;

        System.out.println("meuAnimal eh um " + meuAnimal.getClass().getSimpleName());
        System.out.println("meuCachorro eh um " + meuCachorro.getClass().getSimpleName());
        System.out.println("obj eh um " + obj.getClass().getSimpleName());
        System.out.println("umOutroAnimal eh um " + umOutroAnimal.getClass().getSimpleName());
    }
}