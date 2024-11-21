package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MonitoramentoTest {

    private model.Paciente paciente;
    private model.Dispositivo dispositivo;
    private MonitoramentoTest monitoramento;
    private Date data;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializa os objetos necessários para os testes
        paciente = new model.Paciente("João Silva");  // Supondo que a classe Paciente tenha esse construtor
        dispositivo = new model.Dispositivo("Monitor de Pressão", "MarcaX");  // Supondo que a classe Dispositivo tenha esse construtor
        data = new Date();  // A data atual para o teste

        // Inicializa a instância de MonitoramentoTest
        monitoramento = new MonitoramentoTest(paciente, dispositivo, "Pressão arterial normal", data);
    }

    // Teste do construtor e dos getters
    @Test
    public void testCriarMonitoramento() {
        assertNotNull(monitoramento);
        assertEquals(paciente, monitoramento.getPaciente());
        assertEquals(dispositivo, monitoramento.getDispositivo());
        assertEquals("Pressão arterial normal", monitoramento.getDados());
        assertEquals(data, monitoramento.getData());
    }

    // Teste do método exibirMonitoramento
    @Test
    public void testExibirMonitoramento() {
        // Redirecionando a saída para um OutputStream para capturar as mensagens
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        monitoramento.exibirMonitoramento();

        String output = outputStream.toString();
        assertTrue(output.contains("Paciente: João Silva"));
        assertTrue(output.contains("Dispositivo: Monitor de Pressão - MarcaX"));
        assertTrue(output.contains("Dados de Monitoramento: Pressão arterial normal"));
    }

    // Teste do método gerarAlerta com dados "alta pressão"
    @Test
    public void testGerarAlertaComPressaoAlta() {
        monitoramento = new MonitoramentoTest(paciente, dispositivo, "alta pressão", data);

        // Redirecionando a saída para capturar o alerta
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        monitoramento.gerarAlerta();

        String output = outputStream.toString();
        assertTrue(output.contains("ALERTA: Pressão arterial elevada!"));
    }

    // Teste do método gerarAlerta com dados normais
    @Test
    public void testGerarAlertaComDadosNormais() {
        monitoramento = new MonitoramentoTest(paciente, dispositivo, "Pressão arterial normal", data);

        // Redirecionando a saída para capturar a resposta
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        monitoramento.gerarAlerta();

        String output = outputStream.toString();
        assertTrue(output.contains("Monitoramento dentro dos parâmetros normais."));
    }

    // Teste do método analisarMonitoramento com batimento alto
    @Test
    public void testAnalisarMonitoramentoComBatimentoAlto() {
        monitoramento = new MonitoramentoTest(paciente, dispositivo, "batimento alto", data);

        // Redirecionando a saída para capturar a análise
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        monitoramento.analisarMonitoramento();

        String output = outputStream.toString();
        assertTrue(output.contains("Análise: Batimentos cardíacos fora da faixa normal."));
    }

    // Teste do método analisarMonitoramento com dados normais
    @Test
    public void testAnalisarMonitoramentoComDadosNormais() {
        monitoramento = new MonitoramentoTest(paciente, dispositivo, "Pressão arterial normal", data);

        // Redirecionando a saída para capturar a análise
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        monitoramento.analisarMonitoramento();

        String output = outputStream.toString();
        assertTrue(output.contains("Análise: Dados normais."));
    }

    // Teste do método toString
    @Test
    public void testToString() {
        String expected = "Monitoramento{" +
                "paciente=João Silva" +
                ", dispositivo=Monitor de Pressão" +
                ", dados='Pressão arterial normal'" +
                ", data=" + data +
                '}';
        assertEquals(expected, monitoramento.toString());
    }
}
