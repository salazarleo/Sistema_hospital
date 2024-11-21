package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MedicoTest {

    private MedicoTest medico;
    private PrescricaoMedicaTest prescricao;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializando o objeto PrescricaoMedicaTest
        prescricao = new PrescricaoMedicaTest(12345, "123.456.789-00", new Medicamento("Paracetamol", "500mg"), 10);
        // Inicializando o objeto MedicoTest
        medico = new MedicoTest("Dr. João", 12345, "Cardiologia", "dr.joao@email.com", "999999999");
    }

    // Teste do construtor e dos getters
    @Test
    public void testCriarMedico() {
        assertNotNull(medico);
        assertEquals("Dr. João", medico.getNome());
        assertEquals(12345, medico.getCrm());
        assertEquals("Cardiologia", medico.getEspecialidade());
        assertEquals("dr.joao@email.com", medico.getEmail());
        assertEquals("999999999", medico.getTelefone());
        assertNotNull(medico.getPrescricoes()); // A lista de prescrições deve ser inicializada
    }

    // Teste do método adicionarPrescricao
    @Test
    public void testAdicionarPrescricao() {
        // Adiciona a prescrição ao médico
        medico.adicionarPrescricao(prescricao);

        // Verifica se a prescrição foi adicionada
        List<PrescricaoMedicaTest> prescricoes = medico.getPrescricoes();
        assertEquals(1, prescricoes.size());
        assertEquals(prescricao, prescricoes.get(0));
    }

    // Teste do método toString
    @Test
    public void testToString() {
        String resultadoEsperado = "Medico{crm=12345, nome='Dr. João', especialidade='Cardiologia', email='dr.joao@email.com', telefone='999999999', prescricoes=[]}";
        assertEquals(resultadoEsperado, medico.toString());
    }
}
