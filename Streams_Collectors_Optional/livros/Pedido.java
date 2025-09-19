import java.util.List;

public class Pedido {
    private Integer codigo;
    private List<Produto> produtos;
    private Cliente cliente;

    public Pedido(Integer codigo, List<Produto> produtos, Cliente cliente) {
        this.codigo = codigo;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String toString() {
        return String.format("[%d] %s %s", codigo, produtos, cliente);
    }
}