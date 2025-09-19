public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private CategoriaProduto categoria;

    public Produto(int codigo, String nome, CategoriaProduto categoria, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }
    @Override
    public String toString() {
        return String.format(new java.util.Locale("pt", "BR"),"[%d] %s %s R$ %.2f", codigo, nome, categoria, preco);
    }
}
