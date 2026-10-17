package Produto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Carrinho {
    private final Map<String, Produto> carrinho = new HashMap<String, Produto>();

    public void adicionarProduto(Produto produto) {
        if(carrinho.containsKey(produto.getCodigo())){
            throw new IllegalArgumentException("Produto ja existente");
        }
        carrinho.put(produto.getCodigo(), produto);
    }
    public Produto buscarProduto(String codigo) {
        return Optional.ofNullable(carrinho.get(codigo)).orElseThrow(() -> new IllegalArgumentException("Item nao encontrado"));
    }
    public void removerProduto(String codigo) {
        Optional.ofNullable(carrinho.remove(codigo)).orElseThrow(() -> new IllegalArgumentException("Item nao encontrado"));
    }
}
