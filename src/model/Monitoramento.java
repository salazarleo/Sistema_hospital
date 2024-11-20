package model;

import java.util.Date;

public class Monitoramento {
    private Paciente paciente; // Referência ao paciente monitorado
    private Dispositivo dispositivo; // Referência ao dispositivo conectado
    private String dados; // Dados de monitoramento (exemplo: pressão arterial, batimentos cardíacos)
    private Date data; // Data da monitoração

    // Construtor
    public Monitoramento(Paciente paciente, Dispositivo dispositivo, String dados, Date data) {
        this.paciente = paciente;
        this.dispositivo = dispositivo;
        this.dados = dados;
        this.data = data;
    }

    // Getters
    public Paciente getPaciente() {
        return paciente;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public String getDados() {
        return dados;
    }

    public Date getData() {
        return data;
    }

    // Exibição dos dados de monitoramento
    public void exibirMonitoramento() {
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Dispositivo: " + dispositivo.getTipo() + " - " + dispositivo.getMarca());
        System.out.println("Dados de Monitoramento: " + dados);
        System.out.println("Data da Monitorização: " + data);
    }

    // Gerar alerta baseado nos dados
    public void gerarAlerta() {
        // Aqui, você pode criar regras para alertas (exemplo: pressão arterial acima de um limite)
        if (dados.contains("alta pressão")) {
            System.out.println("ALERTA: Pressão arterial elevada!");
        } else {
            System.out.println("Monitoramento dentro dos parâmetros normais.");
        }
    }

    // Analisar dados de monitoramento (exemplo: verificar se os dados são normais ou não)
    public void analisarMonitoramento() {
        // Implementar lógica de análise (exemplo: batimentos cardíacos fora da faixa normal)
        if (dados.contains("batimento alto")) {
            System.out.println("Análise: Batimentos cardíacos fora da faixa normal.");
        } else {
            System.out.println("Análise: Dados normais.");
        }
    }

    @Override
    public String toString() {
        return "Monitoramento{" +
                "paciente=" + paciente.getNome() +
                ", dispositivo=" + dispositivo.getTipo() +
                ", dados='" + dados + '\'' +
                ", data=" + data +
                '}';
    }
}
