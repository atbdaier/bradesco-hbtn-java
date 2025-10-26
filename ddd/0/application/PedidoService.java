package application;


import domain.Cliente;
import domain.Pedido;
import domain.Produto;
import infrastructure.PedidoRepository;

import java.util.UUID;


public class PedidoService {


    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido(Cliente cliente) {
        String pedidoId = UUID.randomUUID().toString(); // gera um ID único
        Pedido pedido = new Pedido(pedidoId, cliente);
        pedidoRepository.salvar(pedido);
        return pedido;
    }

    public void adicionarProduto(String pedidoId, Produto produto) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }
        pedido.adicionarProduto(produto);
        pedidoRepository.salvar(pedido);
    }

    public void pagarPedido(String pedidoId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }
        pedido.pagar();
        pedidoRepository.salvar(pedido);
    }

    public void cancelarPedido(String pedidoId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }
        pedido.cancelar();
        pedidoRepository.salvar(pedido);
    }
}