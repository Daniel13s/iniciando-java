package Produto;

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        Produto caixa = new Produto("adasdf", "Caixa", 20.00, "top");
        Produto caixa2 = new Produto("gfghfdvb", "Caixa", 20.00, "top");
        Produto caixa3 = new Produto("adasdasd", "Caixa", 20.00, "top");

        carrinho.adicionarProduto(caixa);
        carrinho.adicionarProduto(caixa2);
        carrinho.adicionarProduto(caixa3);

        carrinho.removerProduto("alsdjkaskjf");

    }
}
