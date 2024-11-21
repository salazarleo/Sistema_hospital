package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PacienteTest {

    private model.Paciente paciente;
    private model.Medico medico;
    private model.PrescricaoMedica prescricao;
    private model.Dispositivo dispositivo;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializa o paciente, médico, prescrição e dispositivo antes de cada teste
        paciente = new model.Paciente("João da Silva", 30, "123.456.789-00");

        // Ajuste no construtor de Medico, incluindo mais parâmetros
        medico = new model.Medico("Dr. João", 30, "12345", "Especialidade", "CRM123");

        // Ajuste no construtor de PrescricaoMedica
        model.Medicamento medicamento = new model.Medicamento("Medicamento X");
        prescricao = new model.PrescricaoMedica(7, "2 vezes ao dia", medicamento, 30);

        // Ajuste no construtor de Dispositivo
        dispositivo = new model.Dispositivo("Dispositivo Y", "Modelo", "Tipo", "Fabricante", "2023-01-01");
    }

    // Testa o construtor e os getters
    @Test
    public void testCriarPaciente() {
        assertNotNull(paciente);
        assertEquals("João da Silva", paciente.getNome());
        assertEquals(30, paciente.getIdade());
        assertEquals("123.456.789-00", paciente.getCpf());
    }

    // Testa o método adicionarPrescricao
    @Test
    public void testAdicionarPrescricao() {
        paciente.adicionarPrescricao(prescricao);
        List<model.PrescricaoMedica> prescricoes = paciente.getPrescricoes();
        assertEquals(1, prescricoes.size());
        assertEquals(prescricao, prescricoes.get(0));
    }

    // Testa o método adicionarDispositivo
    @Test
    public void testAdicionarDispositivo() {
        paciente.adicionarDispositivo(dispositivo);
        List<model.Dispositivo> dispositivos = paciente.getDispositivos();
        assertEquals(1, dispositivos.size());
        assertEquals(dispositivo, dispositivos.get(0));
    }

    // Testa o método setMedico e getMedico
    @Test
    public void testAssociarMedico() {
        paciente.setMedico(medico);
        assertEquals(medico, paciente.getMedico());
    }

    // Testa o método toString
    @Test
    public void testToString() {
        paciente.setMedico(medico);
        paciente.adicionarPrescricao(prescricao);
        paciente.adicionarDispositivo(dispositivo);

        String expected = "Paciente{" +
                "nome='João da Silva'" +
                ", idade=30" +
                ", cpf='123.456.789-00'" +
                ", prescricoes=[" + prescricao + "]" +
                ", dispositivos=[" + dispositivo + "]" +
                ", medico=" + medico + "}";

        assertEquals(expected, paciente.toString());
    }
}
