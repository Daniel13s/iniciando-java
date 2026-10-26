import com.example.demo.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    void configurar() {
        pedido = new Pedido("1", "Maria", 100.0);
    }
    @Nested
    @DisplayName("Atualização de valor")
    class AtualizacaoDeValorTest {
        @DisplayName("Deve atualizar o valor novamente")
        @Test
        void deveAtualizarValorNovamente() {
            pedido.atualizarValor(300.0);

            assertEquals(300.0, pedido.getValor());
        }

        @DisplayName("Deve atualizar o valor do pedido.")
        @Test
        void deveAtualizarValorDoPedido() {
            pedido.atualizarValor(200.0);

            assertEquals(200.0, pedido.getValor());
        }

        @DisplayName("Não deve aceitar valores negativos")
        @ParameterizedTest
        @ValueSource(doubles = {-10.0, -50.0, -100.0})
        void naoDeveAceitarValorNegativo(double valor) {
            assertThrows(IllegalArgumentException.class, () -> {
                pedido.atualizarValor(valor);
            });

            assertEquals(100.0, pedido.getValor());
        }
    }
    @Nested
    @DisplayName("Criação de pedido")
    class CriacaoDePedidoTest {
        @DisplayName("Não deve criar um pedido com valor negativo")
        @Test
        void naoDeveCriarPedidoComValorNegativo() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Pedido("1", "Maria", -50.0);
            });
        }

        @DisplayName("Não deve criar um pedido com o nome vazio")
        @Test
        void naoDeveCriarPedidoComNomeVazio() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Pedido("1", "", 100.0);
            });
        }

        @DisplayName("Não deve criar o pedido com o nome contendo apenas espaços")
        @Test
        void naoDeveCriarPedidoComNomeSoDeEspacos() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Pedido("1", "   ", 100.0);
            });
        }

        @DisplayName("Deve negar pedidos inválidos")
        @ParameterizedTest
        @MethodSource("pedidosInvalidos")
        void deveNegarPedidosInvalidos(String name, double valor) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Pedido("1", name, valor);
            });
        }

        static Stream<Arguments> pedidosInvalidos() {
            return Stream.of(
                    Arguments.of("", 100.0),
                    Arguments.of("Maria", -50.0),
                    Arguments.of("    ", 200.0)
            );
        }
    }
}
