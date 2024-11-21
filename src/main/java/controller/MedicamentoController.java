package controller;

import model.Medicamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicamentoController {
    private List<Medicamento> medicamentos = new ArrayList<>();

    public void registrarMedicamento(Scanner scanner) {
        System.out.print("Digite o nome do medicamento: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a dosagem do medicamento: ");
        String dosagem = scanner.nextLine();

        System.out.print("Digite a frequencia do medicamento: ");
        String frequencia = scanner.nextLine();


        System.out.print("Digite a descricao do medicamento: ");
        String descricao = scanner.nextLine();


        System.out.print("Digite a data do medicamento: ");
        String data = scanner.nextLine();


        Medicamento medicamento = new Medicamento(nome);
        medicamentos.add(medicamento);
        System.out.println("Medicamento registrado com sucesso!");
    }

    public void listarMedicamentos() {
        if (medicamentos.isEmpty()) {
            System.out.println("Nenhum medicamento registrado.");
        } else {
            for (Medicamento medicamento : medicamentos) {
                System.out.println(medicamento);
            }
        }
    }
}
