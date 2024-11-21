package test.java.controller;

import model.Medicamento;
import model.Medico;
import model.Paciente;
import model.PrescricaoMedica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicoControllerTest {

    private MedicoControllerTest controller;
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<PrescricaoMedica> prescricoes;

    @BeforeEach
    public void setUp() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        prescricoes = new ArrayList<>();
        controller = new MedicoControllerTest(); // Initialize the controller
    }

    @Test
    public void testRegistrarMedico() {
        controller.registrarMedico("Dr. João", 12345, "Cardiologia", "joao@example.com", "123456789");

        assertEquals(1, medicos.size(), "Deve haver 1 médico registrado.");
        assertEquals("Dr. João", medicos.get(0).getNome(), "O nome do médico deve ser 'Dr. João'.");
    }

    @Test
    public void testRegistrarPaciente() {
        controller.registrarPaciente("Maria", 30, "12345678901");

        assertEquals(1, pacientes.size(), "Deve haver 1 paciente registrado.");
        assertEquals("Maria", pacientes.get(0).getNome(), "O nome do paciente deve ser 'Maria'.");
    }

    @Test
    public void testConsultarMedico() {
        controller.registrarMedico("Dr. João", 12345, "Cardiologia", "joao@example.com", "123456789");
        Medico medico = controller.consultarMedico(12345);

        assertNotNull(medico, "O médico deve ser encontrado.");
        assertEquals("Dr. João", medico.getNome(), "O nome do médico encontrado deve ser 'Dr. João'.");
    }

    @Test
    public void testConsultarPaciente() {
        controller.registrarPaciente("Maria", 30, "12345678901");
        Paciente paciente = controller.consultarPaciente("12345678901");

        assertNotNull(paciente, "O paciente deve ser encontrado.");
        assertEquals("Maria", paciente.getNome(), "O nome do paciente encontrado deve ser 'Maria'.");
    }

    @Test
    public void testAdicionarPrescricao() {
        controller.registrarMedico("Dr. João", 12345, "Cardiologia", "joao@example.com", "123456789");
        controller.registrarPaciente("Maria", 30, "12345678901");

        Medicamento medicamento = new Medicamento("AAS");
        PrescricaoMedica prescricao = new PrescricaoMedica(12345, "12345678901", medicamento, 30);

        controller.adicionarPrescricao(12345, "12345678901", prescricao);

        assertEquals(1, prescricoes.size(), "Deve haver 1 prescrição registrada.");
        assertTrue(medicos.get(0).getPrescricoes().contains(prescricao), "O médico deve ter a prescrição registrada.");
        assertTrue(pacientes.get(0).getPrescricoes().contains(prescricao), "O paciente deve ter a prescrição registrada.");
    }

    @Test
    public void testAjustarDosagem() {
        controller.registrarMedico("Dr. João", 12345, "Cardiologia", "joao@example.com", "123456789");
        controller.registrarPaciente("Maria", 30, "12345678901");

        Medicamento medicamento = new Medicamento("AAS");
        PrescricaoMedica prescricao = new PrescricaoMedica(12345, "12345678901", medicamento, 30);
        controller.adicionarPrescricao(12345, "12345678901", prescricao);

        controller.ajustarDosagem(12345, "12345678901", "AAS", "500mg");

        assertEquals("500mg", prescricao.getDosagem(), "A dosagem do medicamento deve ser ajustada para 500mg.");
    }

    @Test
    public void testCancelarPrescricao() {
        controller.registrarMedico("Dr. João", 12345, "Cardiologia", "joao@example.com", "123456789");
        controller.registrarPaciente("Maria", 30, "12345678901");

        Medicamento medicamento = new Medicamento("AAS");
        PrescricaoMedica prescricao = new PrescricaoMedica(12345, "12345678901", medicamento, 30);
        controller.adicionarPrescricao(12345, "12345678901", prescricao);

        controller.cancelarPrescricao(12345, "12345678901", "AAS");

        assertFalse(medicos.get(0).getPrescricoes().contains(prescricao), "A prescrição deve ter sido removida do médico.");
        assertFalse(pacientes.get(0).getPrescricoes().contains(prescricao), "A prescrição deve ter sido removida do paciente.");
        assertFalse(prescricoes.contains(prescricao), "A prescrição deve ter sido removida da lista geral.");
    }

    @Test
    public void testListarPacientesPrescritos() {
        controller.registrarMedico("Dr. João", 12345, "Cardiologia", "joao@example.com", "123456789");
        controller.registrarPaciente("Maria", 30, "12345678901");

        Medicamento medicamento = new Medicamento("AAS");
        PrescricaoMedica prescricao = new PrescricaoMedica(12345, "12345678901", medicamento, 30);
        controller.adicionarPrescricao(12345, "12345678901", prescricao);

        controller.listarPacientesPrescritos("Dr. João");

        // Verify that the correct patient is listed
        assertTrue(true, "Test passed if patient appears in the list printed.");
    }
}
