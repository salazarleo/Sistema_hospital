package test.java.controller;

import model.Consulta;
import model.Medico;
import model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultaControllerTest {

    private ConsultaControllerTest consultaController;
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    @BeforeEach
    public void setUp() {
        // Inicializa o controlador de consultas e as listas de médicos e pacientes
        consultaController = new ConsultaControllerTest();
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();

        // Cria alguns médicos e pacientes fictícios para os testes
        Medico medico1 = new Medico("Dr. João", 12345);
        Medico medico2 = new Medico("Dra. Maria", 67890);
        medicos.add(medico1);
        medicos.add(medico2);

        Paciente paciente1 = new Paciente("Carlos Silva", 30, "11122233344");
        Paciente paciente2 = new Paciente("Ana Costa", 25, "55566677788");
        pacientes.add(paciente1);
        pacientes.add(paciente2);
    }

    @Test
    public void testCriarAgendamentoConsultaValido() {
        // Simula a criação de uma consulta com dados válidos
        consultaController.criarAgendamento(medicos, pacientes);

        // Verifica se a consulta foi agendada
        assertEquals(1, consultaController.consultas.size()); // Deve ter 1 consulta agendada
    }

    @Test
    public void testCriarAgendamentoComMedicoInvalido() {
        // Tenta agendar uma consulta com um CRM inválido
        List<Medico> medicosInvalidos = new ArrayList<>();
        Medico medicoInvalido = new Medico("Dr. Fake", 99999); // CRM inválido
        medicosInvalidos.add(medicoInvalido);

        consultaController.criarAgendamento(medicosInvalidos, pacientes);

        // Verifica se a consulta não foi criada
        assertEquals(0, consultaController.consultas.size()); // Não deve ter consultas agendadas
    }

    @Test
    public void testCriarAgendamentoComPacienteInvalido() {
        // Tenta agendar uma consulta com um CPF inválido
        List<Paciente> pacientesInvalidos = new ArrayList<>();
        Paciente pacienteInvalido = new Paciente("João Fake", 40, "00000000000"); // CPF inválido
        pacientesInvalidos.add(pacienteInvalido);

        consultaController.criarAgendamento(medicos, pacientesInvalidos);

        // Verifica se a consulta não foi criada
        assertEquals(0, consultaController.consultas.size()); // Não deve ter consultas agendadas
    }

    @Test
    public void testListarConsultas() {
        // Adiciona uma consulta à lista de consultas
        consultaController.criarAgendamento(medicos, pacientes);

        // Verifica se as consultas estão sendo listadas corretamente
        assertTrue(consultaController.consultas.size() > 0); // A lista de consultas não deve estar vazia
    }
}
