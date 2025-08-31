import produtos.Produto;
public class ItemPedido {
    private int quantidade;
    private produtos.Produto produto;

    public ItemPedido(Produto produto, int quantidade) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double obterPrecoLiquido() {
        return quantidade * produto.obterPrecoLiquido();
    }
}
