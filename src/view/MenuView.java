package view;

import controller.ConsultaController;
import controller.PacienteController;
import controller.MedicoController;
import model.Medico;
import model.Paciente;
import model.Medicamento;
import model.PrescricaoMedica;

import java.util.List;
import java.util.Scanner;

public class MenuView {

    private final Scanner scanner = new Scanner(System.in);
    private final PacienteController pacienteController = new PacienteController();
    private final MedicoController medicoController = new MedicoController();
    private final ConsultaController consultaController = new ConsultaController();

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n----- MENU PRINCIPAL -----");
            System.out.println("1. Menu Pacientes");
            System.out.println("2. Menu Médicos");
            System.out.println("3. Sair");
            System.out.println("4. Agendar Consulta");
            System.out.print("\nEscolha uma opção: ");

            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> exibirMenuPacientes();
                case 2 -> exibirMenuMedicos();
                case 3 -> System.out.println("\nSaindo... Até logo!");
                case 4 -> agendarConsulta();
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 3);
    }

    private void exibirMenuPacientes() {
        int opcao;

        do {
            System.out.println("\n----- MENU PACIENTES -----");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Consultar Paciente");
            System.out.println("3. Listar Pacientes");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");

            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> pacienteController.registrarPaciente(scanner);
                case 2 -> pacienteController.consultarPaciente(scanner);
                case 3 -> pacienteController.listarPacientes();
                case 4 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }

            if (opcao != 4) {
                System.out.print("\nPressione 'Enter' para voltar ao menu de Pacientes...");
                scanner.nextLine();
            }
        } while (opcao != 4);
    }

    private void agendarConsulta() {
        int opcao;

        List<Medico> medicos = medicoController.listarMedicos();
        List<Paciente> pacientes = pacienteController.listarPacientes();

        do {
            System.out.println("\n----- MENU CONSULTA -----");
            System.out.println("1. Gerar Consulta");
            System.out.println("2. Listar Consultas");
            System.out.println("3. Voltar ao Menu Principal");

            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> consultaController.criarAgendamento(medicos, pacientes);
                case 2 -> consultaController.listarConsultas();
                case 3 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }

            if (opcao != 3) {
                System.out.print("\nPressione 'Enter' para voltar ao menu de Consultas...");
                scanner.nextLine();
            }

        } while (opcao != 3);
    }

    private void exibirMenuMedicos() {
        int opcao;

        do {
            System.out.println("\n----- MENU MÉDICOS -----");
            System.out.println("1. Registrar Médico");
            System.out.println("2. Consultar Médico");
            System.out.println("3. Listar Médicos");
            System.out.println("4. Adicionar Prescrição Médica");
            System.out.println("5. Ver Pacientes Prescritos");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");

            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> registrarMedico(scanner);
                case 2 -> consultarMedico(scanner);
                case 3 -> medicoController.listarMedicos();
                case 4 -> adicionarPrescricao(scanner);
                case 5 -> {
                    System.out.print("Digite o nome do Médico para listar os pacientes prescritos: ");
                    String nome = scanner.nextLine();
                    medicoController.listarPacientesPrescritos(nome);
                }
                case 6 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }

            if (opcao != 6) {
                System.out.print("\nPressione 'Enter' para voltar ao menu de Médicos...");
                scanner.nextLine();
            }
        } while (opcao != 6);
    }

    private void registrarMedico(Scanner scanner) {
        System.out.println("\n----- REGISTRAR MÉDICO -----");

        System.out.print("Digite o nome do médico: ");
        String nome = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Digite o CRM do médico: ");
        int crm = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        System.out.print("Digite a especialidade do médico: ");
        String especialidade = scanner.nextLine();


        System.out.print("Digite o email do médico: ");
        String email = scanner.nextLine();


        System.out.print("Digite o telefone do médico: ");
        String telefone = scanner.nextLine();

        medicoController.registrarMedico(nome, crm, especialidade, email, telefone);
    }

    private void consultarMedico(Scanner scanner) {
        System.out.print("Digite o CRM do médico: ");
        int crm = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        var medico = medicoController.consultarMedico(crm);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
        } else {
            System.out.println("Médico encontrado: " + medico.getNome() + " | Especialidade: " + medico.getEspecialidade());
        }
    }

    private void adicionarPrescricao(Scanner scanner) {
        System.out.print("Digite o CRM do médico: ");
        int crm = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();

        if (pacienteController.buscarPacientePorCpf(cpfPaciente) == null) {
            System.out.println("Paciente não encontrado. Por favor, registre o paciente primeiro.");
            return;
        }

        System.out.print("Digite o nome do medicamento: ");
        String nomeMedicamento = scanner.nextLine();

        System.out.print("Digite a dosagem do medicamento: ");
        String dosagemMedicamento = scanner.nextLine();

        System.out.print("Digite a frequência do medicamento: ");
        String frequencia = scanner.nextLine();

        System.out.print("Digite a descrição do medicamento: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a data do medicamento: ");
        String data = scanner.nextLine();

        Medicamento medicamento = new Medicamento(nomeMedicamento, dosagemMedicamento, frequencia, descricao, data);
        PrescricaoMedica prescricao = new PrescricaoMedica(medicamento.getNome(), medicamento.getDosagem());

        medicoController.adicionarPrescricao(crm, cpfPaciente, prescricao);
    }

    private int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido para a opção.");
            scanner.next(); // descarta a entrada inválida
        }
        return scanner.nextInt();
    }
}