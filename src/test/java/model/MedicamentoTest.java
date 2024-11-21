package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicamentoTest {

    private MedicamentoTest medicamento;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializa o objeto MedicamentoTest
        medicamento = new MedicamentoTest("Paracetamol");
    }

    // Teste do construtor e dos getters
    @Test
    public void testCriarMedicamento() {
        // Verifica se o medicamento foi criado corretamente
        assertNotNull(medicamento);
        assertEquals("Paracetamol", medicamento.getNome());
        assertNull(medicamento.getFrequencia()); // Verifica se o valor padrão é nulo
        assertNull(medicamento.getDescricao());  // Verifica se o valor padrão é nulo
        assertNull(medicamento.getData());      // Verifica se o valor padrão é nulo
    }

    // Teste dos setters e getters
    @Test
    public void testSettersEGetters() {
        // Testa os setters e getters
        medicamento.setFrequencia("A cada 8 horas");
        medicamento.setDescricao("Medicamento para dor");
        medicamento.setData("2024-11-20");

        // Verifica se os valores foram corretamente atribuídos
        assertEquals("A cada 8 horas", medicamento.getFrequencia());
        assertEquals("Medicamento para dor", medicamento.getDescricao());
        assertEquals("2024-11-20", medicamento.getData());
    }

    // Teste do método toString (se você decidir implementar um)
    @Test
    public void testToString() {
        // Definindo os dados do medicamento
        medicamento.setFrequencia("A cada 8 horas");
        medicamento.setDescricao("Medicamento para dor");
        medicamento.setData("2024-11-20");

        // Formato esperado da string (modifique conforme sua implementação)
        String resultadoEsperado = "Medicamento{nome='Paracetamol', frequencia='A cada 8 horas', descricao='Medicamento para dor', data='2024-11-20'}";
        assertEquals(resultadoEsperado, medicamento.toString());
    }
}
