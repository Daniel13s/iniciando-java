import com.example.demo.Pedido;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    void configurar() {
        pedido = new Pedido("1", "Maria", 100.0);
    }
    @Test
    void deveAtualizarValorDoPedido() {
        pedido.atualizarValor(200.0);

        assertEquals(200.0, pedido.getValor());
    }
    @Test
    void naoDeveAceitarValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            pedido.atualizarValor(-50.0);
        });
    }
    @Test
    void naoDeveCriarPedidoComValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pedido("1", "Maria", -50.0);
        });
    }
    @Test
    void naoDeveCriarPedidoComNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pedido("1", "", 100.0);
        });
    }
    @Test
    void naoDeveCriarPedidoComNomeSoDeEspacos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pedido("1", "   ", 100.0);
        });
    }
    @Test
    void deveAtualizarValorNovamente() {
        pedido.atualizarValor(300.0);

        assertEquals(300.0, pedido.getValor());
    }
}
