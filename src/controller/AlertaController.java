package controller;

import model.Alerta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlertaController {
    private List<Alerta> alertas = new ArrayList<>();

    public void registrarAlerta(Scanner scanner) {
        System.out.print("Digite o tipo do alerta: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite a mensagem do alerta: ");
        String mensagem = scanner.nextLine();

        Alerta alerta = new Alerta(tipo, mensagem);
        alertas.add(alerta);
        System.out.println("Alerta registrado com sucesso!");
    }

    public void listarAlertas() {
        if (alertas.isEmpty()) {
            System.out.println("Nenhum alerta registrado.");
        } else {
            for (Alerta alerta : alertas) {
                System.out.println(alerta);
            }
        }
    }
}
