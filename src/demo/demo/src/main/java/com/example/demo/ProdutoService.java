package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProdutoService {
    private Map<String, Produto> produtos = new HashMap<>();
    public void cadastrar(Produto produto) {
        if(produtos.containsKey(produto.getCodigo())) {
            throw new IllegalArgumentException("Codigo existente.");
        }
        produtos.put(produto.getCodigo(), produto);
    }
    public Produto buscarPorCodigo(String codigo) {
        if(!produtos.containsKey(codigo)) {
            throw new ProdutoNaoEncontradoException("Produto nao encontrado");
        }
        return produtos.get(codigo);
    }
    public List<Produto> listar() {
        return produtos.values().stream().toList();
    }
}
