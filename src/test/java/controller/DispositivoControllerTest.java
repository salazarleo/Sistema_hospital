package test.java.controller;

import model.Dispositivo;
import model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DispositivoControllerTest {

    private controller.DispositivoController dispositivoController;
    private List<Paciente> pacientes;
    private List<Dispositivo> dispositivos;

    @BeforeEach
    public void setUp() {
        // Setup initial data before each test
        pacientes = new ArrayList<>();
        dispositivos = new ArrayList<>();

        // Create some mock patients
        pacientes.add(new Paciente("12345678901", "João Silva"));
        pacientes.add(new Paciente("98765432100", "Maria Oliveira"));

        // Initialize the DispositivoController with mock patients
        dispositivoController = new controller.DispositivoController(pacientes);
    }

    @Test
    public void testCadastrarDispositivo() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");

        assertEquals(1, dispositivos.size(), "Deve haver 1 dispositivo cadastrado.");
        assertEquals("Monitor", dispositivos.get(0).getTipo(), "O tipo do dispositivo deve ser 'Monitor'.");
    }

    @Test
    public void testVisualizarDispositivosComDispositivosCadastrados() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");
        dispositivoController.cadastrarDispositivo("Sensor", "HP", "S10", "Inativo", "Valor de Referência");

        // Verificar se a visualização dos dispositivos contém 2 dispositivos
        assertEquals(2, dispositivos.size(), "Deve exibir 2 dispositivos cadastrados.");
    }

    @Test
    public void testVisualizarDispositivosSemDispositivosCadastrados() {
        // Verificar que não há dispositivos cadastrados inicialmente
        dispositivoController.visualizarDispositivos();

        assertTrue(dispositivos.isEmpty(), "A lista de dispositivos deve estar vazia.");
    }

    @Test
    public void testRemoverDispositivoComSucesso() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");
        dispositivoController.removerDispositivo(1);

        assertEquals(0, dispositivos.size(), "A lista de dispositivos deve estar vazia após a remoção.");
    }

    @Test
    public void testRemoverDispositivoComIdInvalido() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");
        dispositivoController.removerDispositivo(2);  // ID inválido, pois só existe o dispositivo de ID 1

        assertEquals(1, dispositivos.size(), "A lista de dispositivos deve conter 1 dispositivo.");
    }

    @Test
    public void testVincularDispositivoAoPaciente() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");
        dispositivoController.vincularDispositivo("12345678901", 1);

        Paciente paciente = pacientes.get(0);
        assertTrue(paciente.getDispositivos().contains(dispositivos.get(0)), "O dispositivo deve estar vinculado ao paciente.");
    }

    @Test
    public void testVincularDispositivoComCpfInvalido() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");
        dispositivoController.vincularDispositivo("11111111111", 1); // CPF inválido

        assertEquals(0, pacientes.get(0).getDispositivos().size(), "O paciente não deve ter dispositivos vinculados.");
    }

    @Test
    public void testBuscarDispositivoPorNome() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");
        Dispositivo dispositivo = dispositivoController.buscarDispositivo("U24");

        assertNotNull(dispositivo, "O dispositivo com nome 'U24' deve ser encontrado.");
        assertEquals("Monitor", dispositivo.getTipo(), "O tipo do dispositivo deve ser 'Monitor'.");
    }

    @Test
    public void testBuscarDispositivoPorNomeNaoEncontrado() {
        dispositivoController.cadastrarDispositivo("Monitor", "Samsung", "U24", "Ativo", "Valor de Referência");
        Dispositivo dispositivo = dispositivoController.buscarDispositivo("Inexistente");

        assertNull(dispositivo, "O dispositivo não deve ser encontrado.");
    }
}
