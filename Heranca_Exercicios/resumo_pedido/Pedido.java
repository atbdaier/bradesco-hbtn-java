public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.obterPrecoLiquido();
        }
        return total * (1 - percentualDesconto / 100);
    }

    public void apresentarResumoPedido(){
        System.out.println("------- RESUMO PEDIDO -------");
        double totalPrecoProdutos = 0.0;
        for (ItemPedido item : itens) {
            double totalItem = item.getProduto().obterPrecoLiquido() * item.getQuantidade();
            System.out.printf("Tipo %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    item.getProduto().getClass().getSimpleName(),
                    item.getProduto().getTitulo(),
                    item.getProduto().obterPrecoLiquido(),
                    item.getQuantidade(),
                    totalItem);
            totalPrecoProdutos += totalItem;
        }
        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f\n", totalPrecoProdutos*(percentualDesconto / 100));
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalPrecoProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", calcularTotal());
        System.out.println("----------------------------");
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }
}
