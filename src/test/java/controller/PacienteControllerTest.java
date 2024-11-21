package test.java.controller;

import model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteControllerTest {

    private controller.PacienteController controller;

    @BeforeEach
    public void setUp() {
        controller = new controller.PacienteController(); // Inicializa o controlador antes de cada teste
    }

    @Test
    public void testRegistrarPaciente() {
        // Cria um paciente com dados fictícios
        controller.registrarPaciente("12345678901", "João Silva", 30);

        // Verifica se o paciente foi registrado corretamente
        Paciente paciente = controller.buscarPacientePorCpf("12345678901");
        assertNotNull(paciente);
        assertEquals("João Silva", paciente.getNome());
        assertEquals(30, paciente.getIdade());
        assertEquals("12345678901", paciente.getCpf());
    }

    @Test
    public void testBuscarPacientePorCpfExistente() {
        // Registra um paciente primeiro
        controller.registrarPaciente("12345678901", "João Silva", 30);

        // Verifica se o paciente pode ser encontrado pelo CPF
        Paciente paciente = controller.buscarPacientePorCpf("12345678901");
        assertNotNull(paciente);
        assertEquals("João Silva", paciente.getNome());
    }

    @Test
    public void testBuscarPacientePorCpfInexistente() {
        // Tenta buscar um paciente que não foi registrado
        Paciente paciente = controller.buscarPacientePorCpf("00000000000");
        assertNull(paciente); // Deve retornar null se o paciente não for encontrado
    }

    @Test
    public void testExistePacienteComCpfExistente() {
        // Registra o paciente
        controller.registrarPaciente("12345678901", "João Silva", 30);

        // Verifica se o paciente existe
        assertTrue(controller.existePaciente("12345678901"));
    }

    @Test
    public void testExistePacienteComCpfInexistente() {
        // Verifica se o paciente com o CPF fornecido não existe
        assertFalse(controller.existePaciente("00000000000"));
    }

    @Test
    public void testListarPacientes() {
        // Registra alguns pacientes
        controller.registrarPaciente("12345678901", "João Silva", 30);
        controller.registrarPaciente("98765432100", "Maria Oliveira", 25);

        // Lista os pacientes e verifica se a lista não está vazia
        List<Paciente> pacientes = controller.listarPacientes();
        assertEquals(2, pacientes.size()); // Deveriam ser 2 pacientes
    }
}
