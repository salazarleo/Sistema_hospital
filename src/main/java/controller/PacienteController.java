package controller;

import model.Paciente;
import model.PrescricaoMedica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacienteController {

    private List<Paciente> pacientes = new ArrayList<>();

    // Método para buscar paciente pelo CPF
    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    // Verifica se o paciente existe pelo CPF
    public boolean existePaciente(String cpf) {
        return buscarPacientePorCpf(cpf) != null;
    }

    // Método para registrar um novo paciente
    public void registrarPaciente(Scanner scanner) {
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Paciente paciente = new Paciente(nome, idade, cpf);
        pacientes.add(paciente);
        System.out.println("Paciente registrado com sucesso!");

    }

    // Método para consultar um paciente pelo CPF
    public void consultarPaciente(Scanner scanner) {
        System.out.print("Digite o CPF do paciente para consultar: ");
        String cpf = scanner.nextLine();
        scanner.nextLine();


        Paciente paciente = buscarPacientePorCpf(cpf);

        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }




    public List<Paciente> listarPacientes() {
        if (this.pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println("Nome: " + paciente.getNome() + " | CPF: " + paciente.getCpf());
            }
        }
        return this.pacientes;  // Retorna a lista de pacientes
    }

    // Método para acessar a lista de pacientes
    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
