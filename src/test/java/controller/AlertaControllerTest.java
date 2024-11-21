package test.java.controller;

import model.Alerta;
import model.Paciente;
import model.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlertaControllerTest {

    private controller.AlertaController alertaController;
    private Alerta alerta;
    private Medico medico;
    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        // Inicializando objetos necessários para os testes
        medico = new Medico("Dr. João", 12345, "Cardiologista", "joao@email.com", "99999-9999");
        paciente = new Paciente("Carlos Silva", "123.456.789-00", 30, "Masculino");
        alertaController = new controller.AlertaController();

        // Criando um alerta
        alerta = new Alerta("Emergência", "Atenção, paciente com risco de parada cardíaca.", paciente, medico);
    }

    @Test
    public void testEmitirAlerta() {
        // Emite o alerta
        alertaController.emitirAlerta(alerta);

        // Verifica se o alerta foi adicionado à lista de alertas
        List<Alerta> alertas = alertaController.visualizarAlertas();
        assertEquals(1, alertas.size());
        assertEquals(alerta, alertas.get(0));  // Verifica se o alerta correto foi adicionado
    }

    @Test
    public void testVisualizarAlertas() {
        // Emite um alerta
        alertaController.emitirAlerta(alerta);

        // Visualiza os alertas
        List<Alerta> alertas = alertaController.visualizarAlertas();
        assertFalse(alertas.isEmpty());  // Verifica se a lista não está vazia
        assertEquals(1, alertas.size());  // Verifica se só existe um alerta
        assertEquals("Emergência", alertas.get(0).getTipo());  // Verifica o tipo do alerta
        assertEquals("Atenção, paciente com risco de parada cardíaca.", alertas.get(0).getMensagem());  // Verifica a mensagem do alerta
    }

    @Test
    public void testVisualizarAlertasVazios() {
        // Verifica o comportamento quando não há alertas
        alertaController = new AlertaController();  // Cria um novo controlador vazio
        List<Alerta> alertas = alertaController.visualizarAlertas();
        assertTrue(alertas.isEmpty());  // Verifica se a lista de alertas está vazia
    }
}
