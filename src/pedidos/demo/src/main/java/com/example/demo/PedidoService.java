package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pedidos.demo.src.main.java.com.example.demo.PedidoExistenteException;
import pedidos.demo.src.main.java.com.example.demo.PedidoNaoEncontradoException;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    public PedidoService(PedidoRepository repository){
        this.repository = repository;
    }

    public void criar(Pedido pedido) {
        if(repository.existsById(pedido.getCodigo())) {
            throw new PedidoExistenteException("Pedido ja existe.");
        }

        repository.save(pedido);
    }
    public Pedido buscar(String codigo){
        return repository.findById(codigo).orElseThrow(() -> new PedidoNaoEncontradoException("Pedido nao encontrado."));
    }
    public List<Pedido> listar() {
        return repository.findAll();
    }
    public void remover(String codigo){
        if(!repository.existsById(codigo)){
            throw new PedidoNaoEncontradoException("Pedido nao encontrado.");
        }
        repository.deleteById(codigo);
    }
    @Transactional
    public Pedido atualizarPedido(String codigo, double novoValor) {
        Pedido pedido = repository.findById(codigo).orElseThrow(() -> new PedidoNaoEncontradoException("Pedido nao encontradod"));

        pedido.atualizarValor(novoValor);

        return pedido;
    }
}
