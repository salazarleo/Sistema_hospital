package controller;

import model.Consulta;
import model.Paciente;
import model.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaController {
    private String data;
    private String hora;
    private String diagnostico;
    private String prescricaomed;
    private Medico medico;
    private Paciente paciente;
    private List<Consulta> consultas; // Lista para armazenar as consultas agendadas

    // Construtor
    public ConsultaController() {
        this.consultas = new ArrayList<>();
    }

    public void criarAgendamento(List<Medico> medicos, List<Paciente> pacientes) {
        Scanner scanner = new Scanner(System.in);

        // Captura os dados da consulta
        System.out.print("Digite a data da consulta (ex: 12/12/2024): ");
        String data = scanner.nextLine();

        System.out.print("Digite a hora da consulta (ex: 14:00): ");
        String hora = scanner.nextLine();

        System.out.print("Digite o diagnóstico: ");
        String diagnostico = scanner.nextLine();

        System.out.print("Digite a prescrição médica (se houver): ");
        String prescricaomed = scanner.nextLine();

        // Captura o médico da consulta
        System.out.print("Digite o CRM do médico: ");
        int crm = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Medico medico = consultarMedico(crm, medicos); // Passa a lista de médicos para consulta

        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return; // Interrompe o agendamento se o médico não for encontrado
        }

        // Captura o paciente da consulta
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        Paciente paciente = consultarPaciente(cpfPaciente, pacientes); // Passa a lista de pacientes para consulta

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return; // Interrompe o agendamento se o paciente não for encontrado
        }

        // Cria a consulta
        Consulta consulta = new Consulta(data, hora, diagnostico, prescricaomed, medico, paciente);
        consultas.add(consulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    // Método para consultar médico por CRM
    private Medico consultarMedico(int crm, List<Medico> medicos) {
        for (Medico medico : medicos) {
            if (medico.getCrm() == crm) {
                return medico; // Retorna o médico encontrado
            }
        }
        return null; // Retorna null se o médico não for encontrado
    }

    // Método para consultar paciente por CPF
    private Paciente consultarPaciente(String cpf, List<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente; // Retorna o paciente encontrado
            }
        }
        return null; // Retorna null se o paciente não for encontrado
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas agendadas.");
        } else {
            for (Consulta consulta : consultas) {
                System.out.println(consulta);
            }
        }
    }


    // Getters e setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricaomed() {
        return prescricaomed;
    }

    public void setPrescricaomed(String prescricaomed) {
        this.prescricaomed = prescricaomed;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
