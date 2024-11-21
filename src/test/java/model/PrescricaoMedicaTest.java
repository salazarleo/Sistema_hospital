package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrescricaoMedicaTest {

    private PrescricaoMedicaTest prescricao;
    private model.Medicamento medicamento;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializando o objeto Medicamento
        medicamento = new model.Medicamento("Paracetamol", "500mg"); // Supondo que a classe Medicamento tenha esse construtor
        // Inicializando a prescrição médica
        prescricao = new PrescricaoMedicaTest(12345, "123.456.789-00", medicamento, 10);
    }

    // Teste do construtor e dos getters
    @Test
    public void testCriarPrescricaoMedica() {
        assertNotNull(prescricao);
        assertEquals(12345, prescricao.getCrm());
        assertEquals("123.456.789-00", prescricao.getCpfPaciente());
        assertEquals(medicamento, prescricao.getMedicamento());
        assertEquals(10, prescricao.getDuracao());
    }

    // Teste do método setDosagem e getDosagem
    @Test
    public void testDosagem() {
        prescricao.setDosagem("1 comprimido por dia");
        assertEquals("1 comprimido por dia", prescricao.getDosagem());
    }

    // Teste de alteração do CRM
    @Test
    public void testAlterarCrm() {
        prescricao.setCrm(54321);
        assertEquals(54321, prescricao.getCrm());
    }

    // Teste de alteração do CPF do paciente
    @Test
    public void testAlterarCpfPaciente() {
        prescricao.setCpfPaciente("987.654.321-00");
        assertEquals("987.654.321-00", prescricao.getCpfPaciente());
    }

    // Teste de alteração do medicamento
    @Test
    public void testAlterarMedicamento() {
        Medicamento novoMedicamento = new Medicamento("Ibuprofeno", "400mg");
        prescricao.setMedicamento(novoMedicamento);
        assertEquals(novoMedicamento, prescricao.getMedicamento());
    }

    // Teste de alteração da duração
    @Test
    public void testAlterarDuracao() {
        prescricao.setDuracao(20);
        assertEquals(20, prescricao.getDuracao());
    }
}
