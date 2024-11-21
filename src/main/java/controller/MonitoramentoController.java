package controller;

import model.Monitoramento;
import model.Dispositivo;
import model.Paciente;
import model.Alerta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MonitoramentoController {
    private List<Monitoramento> monitoramentos = new ArrayList<>();
    private AlertaController alertaController = new AlertaController();

    public void registrarMonitoramento(Scanner scanner, DispositivoController dispositivoController, PacienteController pacienteController) {
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = pacienteController.buscarPacientePorCpf(cpfPaciente);

        if (paciente != null) {
            System.out.print("Digite o nome do dispositivo conectado: ");
            String nomeDispositivo = scanner.nextLine();
            Dispositivo dispositivo = dispositivoController.buscarDispositivo(nomeDispositivo);

            if (dispositivo != null) {
                System.out.print("Digite os dados do monitoramento (ex: pressão arterial, batimentos cardíacos, etc.): ");
                String dados = scanner.nextLine();
                Monitoramento monitoramento = new Monitoramento(paciente, dispositivo, dados, new Date());
                monitoramentos.add(monitoramento);
                System.out.println("Monitoramento registrado com sucesso!");

                // Gerar alertas automaticamente
                gerarAlertas(monitoramento);
            } else {
                System.out.println("Dispositivo não encontrado.");
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private void gerarAlertas(Monitoramento monitoramento) {
        String dadosMonitoramento = monitoramento.getDados();
        Paciente paciente = monitoramento.getPaciente();

        if (dadosMonitoramento.contains("alto") || dadosMonitoramento.contains("crítico")) {
            Alerta alerta = new Alerta("Emergência", "Monitoramento crítico detectado!", paciente, paciente.getMedico());
            alertaController.emitirAlerta(alerta);
        } else if (dadosMonitoramento.contains("anormal") || dadosMonitoramento.contains("fora da faixa")) {
            Alerta alerta = new Alerta("Anormalidade", "Monitoramento fora da faixa normal.", paciente, paciente.getMedico());
            alertaController.emitirAlerta(alerta);
        }
    }

    public void listarMonitoramentos() {
        if (monitoramentos.isEmpty()) {
            System.out.println("Nenhum monitoramento registrado.");
        } else {
            for (Monitoramento monitoramento : monitoramentos) {
                monitoramento.exibirMonitoramento();
                System.out.println("---------------------------");
            }
        }
    }

    public void analisarMonitoramentos() {
        for (Monitoramento monitoramento : monitoramentos) {
            monitoramento.analisarMonitoramento();
        }
    }
}
