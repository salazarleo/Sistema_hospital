package controller;

import model.Dispositivo;
import model.Monitoramento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MonitoramentoController {
    private List<Monitoramento> monitoramentos = new ArrayList<>();

    public void registrarMonitoramento(Scanner scanner, DispositivoController dispositivoController) {
        System.out.print("Digite o nome do dispositivo: ");
        String nomeDispositivo = scanner.nextLine();
        Dispositivo dispositivo = dispositivoController.buscarDispositivo(nomeDispositivo);

        if (dispositivo != null) {
            System.out.print("Digite os dados do monitoramento: ");
            String dados = scanner.nextLine();
            Monitoramento monitoramento = new Monitoramento(dispositivo, dados, new Date());
            monitoramentos.add(monitoramento);
            System.out.println("Monitoramento registrado com sucesso!");
        } else {
            System.out.println("Dispositivo não encontrado!");
        }
    }

    public void listarMonitoramentos() {
        if (monitoramentos.isEmpty()) {
            System.out.println("Nenhum monitoramento registrado.");
        } else {
            for (Monitoramento monitoramento : monitoramentos) {
                System.out.println(monitoramento);
            }
        }
    }
}
