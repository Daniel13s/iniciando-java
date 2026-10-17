package com.example.demo;

import com.example.demo.Pedido;
import com.example.demo.PedidoService;
import org.springframework.web.bind.annotation.*;
import pedidos.demo.src.main.java.com.example.demo.CriarPedidoRequest;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }
    @PostMapping
    public void criar(@RequestBody CriarPedidoRequest request) {
        Pedido pedido = new Pedido(request.codigo(), request.cliente(), request.valor());
        service.criar(pedido);
    }
    @GetMapping("/{codigo}")
    public Pedido buscarPorCodigo(@PathVariable String codigo) {
        return service.buscar(codigo);
    }
    @GetMapping
    public List<Pedido> listar() {
        return service.listar();
    }
    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable String codigo) {
        service.remover(codigo);
    }
    @PatchMapping("/{codigo}")
    public Pedido atualizar(@PathVariable String codigo, @RequestBody AtualizarPedidoRequest request) {
        return service.atualizarPedido(codigo, request.novoValor());
    }
}
