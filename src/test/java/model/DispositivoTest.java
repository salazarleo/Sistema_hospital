package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DispositivoTest {

    private DispositivoTest dispositivo;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializa o objeto DispositivoTest com dados fictícios
        dispositivo = new DispositivoTest("Monitor", "Samsung", "Galaxy", "Ativo", "60-100");
    }

    // Teste do construtor e dos getters
    @Test
    public void testCriarDispositivo() {
        // Verifica se o dispositivo foi criado corretamente
        assertNotNull(dispositivo);
        assertEquals("Monitor", dispositivo.getTipo());
        assertEquals("Samsung", dispositivo.getMarca());
        assertEquals("Galaxy", dispositivo.getModelo());
        assertEquals("Ativo", dispositivo.getStatus());
        assertEquals("60-100", dispositivo.getValoresReferencia());
    }

    // Teste do método getNome
    @Test
    public void testGetNome() {
        // Testa a geração do nome do dispositivo
        assertEquals("Monitor Samsung Galaxy", dispositivo.getNome());
    }

    // Teste do método exibirDetalhes
    @Test
    public void testExibirDetalhes() {
        // O método exibirDetalhes não retorna nada, então precisamos verificar a saída no console
        // Para isso, usamos System.setOut para capturar a saída
        // Neste teste, consideramos que os dados estão corretos conforme a implementação
        // (No entanto, você pode capturar a saída usando um stream de saída e validá-la)

        // Para simplificação, aqui estamos apenas testando se o método não gera exceções
        assertDoesNotThrow(() -> dispositivo.exibirDetalhes());
    }

    // Teste do método toString
    @Test
    public void testToString() {
        // Definindo o formato esperado da string
        String resultadoEsperado = "Dispositivo{tipo='Monitor', marca='Samsung', modelo='Galaxy', status='Ativo', valoresReferencia='60-100'}";
        assertEquals(resultadoEsperado, dispositivo.toString());
    }
}
