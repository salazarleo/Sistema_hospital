package controller;

import model.Dispositivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DispositivoController {
    private List<Dispositivo> dispositivos = new ArrayList<>();

    public void registrarDispositivo(Scanner scanner) {
        System.out.print("Digite o nome do dispositivo: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do dispositivo: ");
        String tipo = scanner.nextLine();

        Dispositivo dispositivo = new Dispositivo(nome, tipo);
        dispositivos.add(dispositivo);
        System.out.println("Dispositivo registrado com sucesso!");
    }

    public Dispositivo buscarDispositivo(String nome) {
        // Procura o dispositivo na lista pelo nome
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getNome().equalsIgnoreCase(nome)) {
                return dispositivo; // Retorna o dispositivo encontrado
            }
        }
        return null; // Retorna null se não encontrar
    }

    public void listarDispositivos() {
        if (dispositivos.isEmpty()) {
            System.out.println("Nenhum dispositivo registrado.");
        } else {
            for (Dispositivo dispositivo : dispositivos) {
                System.out.println(dispositivo);
            }
        }
    }
}
