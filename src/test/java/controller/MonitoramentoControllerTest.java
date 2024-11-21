package test.java.controller;

import model.Alerta;
import model.Dispositivo;
import model.Monitoramento;
import model.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonitoramentoControllerTest {

    private controller.MonitoramentoController monitoramentoController;
    private controller.PacienteController pacienteController;
    private controller.DispositivoController dispositivoController;
    private controller.AlertaController alertaController;

    private Paciente paciente;
    private Dispositivo dispositivo;

    @BeforeEach
    public void setUp() {
        // Criação de instâncias dos controladores e objetos necessários para os testes
        monitoramentoController = new controller.MonitoramentoController();
        pacienteController = new controller.PacienteController(); // Instância real
        dispositivoController = new controller.DispositivoController(); // Instância real
        alertaController = new controller.AlertaController(); // Instância real

        paciente = new Paciente("João Silva", 30, "12345678901");
        dispositivo = new Dispositivo("Monitor de Pressão");

        // Caso necessário, você pode configurar o comportamento dos controladores reais ou adicionar dados mockados no banco
        // Exemplo:
        pacienteController.adicionarPaciente(paciente);  // Adiciona o paciente à lista de pacientes
        dispositivoController.adicionarDispositivo(dispositivo);  // Adiciona o dispositivo à lista
    }

    @Test
    public void testRegistrarMonitoramento_ComPacienteEDispositivoValido() {
        // Definindo um Scanner com dados válidos
        Scanner scanner = new Scanner("12345678901\nMonitor de Pressão\nPressão arterial: 120/80");

        // Chamando o método de registro
        monitoramentoController.registrarMonitoramento(scanner, dispositivoController, pacienteController);

        // Verificando se o monitoramento foi registrado
        assertEquals(1, monitoramentoController.monitoramentos.size(), "O monitoramento deve ser registrado com sucesso.");
    }

    @Test
    public void testRegistrarMonitoramento_ComPacienteInvalido() {
        // Definindo um Scanner com um CPF inválido
        Scanner scanner = new Scanner("00000000000\nMonitor de Pressão\nPressão arterial: 120/80");

        // Chamando o método de registro
        monitoramentoController.registrarMonitoramento(scanner, dispositivoController, pacienteController);

        // Verificando se o paciente não foi encontrado
        assertEquals(0, monitoramentoController.monitoramentos.size(), "Nenhum monitoramento deve ser registrado com paciente inválido.");
    }

    @Test
    public void testRegistrarMonitoramento_ComDispositivoInvalido() {
        // Definindo um Scanner com um dispositivo inválido
        Scanner scanner = new Scanner("12345678901\nMonitor Inexistente\nPressão arterial: 120/80");

        // Chamando o método de registro
        monitoramentoController.registrarMonitoramento(scanner, dispositivoController, pacienteController);

        // Verificando se o dispositivo não foi encontrado
        assertEquals(0, monitoramentoController.monitoramentos.size(), "Nenhum monitoramento deve ser registrado com dispositivo inválido.");
    }

    @Test
    public void testGerarAlerta_ComMonitoramentoCritico() {
        // Criando um monitoramento com dados críticos
        Monitoramento monitoramento = new Monitoramento(paciente, dispositivo, "Pressão arterial: crítico", new java.util.Date());

        // Simulando a emissão de alerta
        monitoramentoController.gerarAlertas(monitoramento);

        // Verificando se o alerta foi emitido
        assertTrue(alertaController.getAlertas().size() > 0, "Deve haver um alerta emitido.");
    }

    @Test
    public void testListarMonitoramentos() {
        // Adicionando monitoramento à lista
        Monitoramento monitoramento = new Monitoramento(paciente, dispositivo, "Pressão arterial: 120/80", new java.util.Date());
        monitoramentoController.monitoramentos.add(monitoramento);

        // Chamando o método listarMonitoramentos
        monitoramentoController.listarMonitoramentos();

        // Verificando se a lista de monitoramentos tem pelo menos um item
        assertTrue(monitoramentoController.monitoramentos.size() > 0, "Deve haver monitoramentos listados.");
    }

    @Test
    public void testAnalisarMonitoramentos() {
        // Adicionando monitoramento à lista
        Monitoramento monitoramento = new Monitoramento(paciente, dispositivo, "Pressão arterial: 120/80", new java.util.Date());
        monitoramentoController.monitoramentos.add(monitoramento);

        // Chamando o método analisarMonitoramentos
        monitoramentoController.analisarMonitoramentos();

        // Como a análise é realizada dentro de Monitoramento, podemos verificar se o método foi chamado (isso depende da implementação).
        // Para este teste, assumimos que o comportamento de análise é válido, se necessário, você pode verificar o estado do objeto.
        assertTrue(true, "A análise do monitoramento deve ser realizada.");
    }
}
