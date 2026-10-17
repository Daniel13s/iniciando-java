package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    @PostMapping
    public void cadastrar(@RequestBody CreateProdutoRequest request) {
        Produto produto = new Produto(request.codigo(), request.nome(), request.preco());
        service.cadastrar(produto);
    }
    @GetMapping("/{codigo}")
    public Produto buscarPorCodigo(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }
    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }
}
