package domain;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Pedido {

    private final String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarProduto(Produto produto) {
        if (status == StatusPedido.PENDENTE) {
            produtos.add(produto);
        } else {
            throw new IllegalStateException("Não é possível adicionar produtos nesse estado: " + status);
        }
    }

    public void removerProduto(Produto produto) {
        if (status == StatusPedido.PENDENTE) {
            produtos.remove(produto);
        } else {
            throw new IllegalStateException("Não é possível remover produtos nesse estado: " + status);
        }
    }

    public void pagar() {
        if (status == StatusPedido.PENDENTE && !produtos.isEmpty()) {
            status = StatusPedido.PAGO;
        } else {
            throw new IllegalStateException("Pedido não pode ser pago nesse estado ou sem produtos");
        }
    }

    public void cancelar() {
        if (status == StatusPedido.PENDENTE) {
            status = StatusPedido.CANCELADO;
        } else {
            throw new IllegalStateException("Pedido não pode ser cancelado nesse estado: " + status);
        }
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public StatusPedido getStatus() {
        return status;
    }
}