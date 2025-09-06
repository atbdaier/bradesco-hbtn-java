public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo","Fabio","Gustavo", "Hingrid","Isabela",
                "Joao","Leise","Maria","Norberto","Otavio","Paulo", "Quirino","Renata","Sabata","Tais","Umberto",
                "Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o metodo de buscaBinaria
    public void buscaBinaria(String nome){

        boolean encontrado = false;
        int low = 0;
        int high = nomes.length - 1;

        System.out.println("Procurando o nome: \"" + nome + "\"");
        while (low <= high) {
            int middle = (low + high) / 2;
            System.out.println("Passando pelo indice: " + middle);
            int comp = nomes[middle].compareTo(nome);

            if (comp == 0) {
                System.out.println("Nome " + nome + " encontrado na posição " + middle);
                return;
            } else if (comp < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        if(!encontrado) {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
}