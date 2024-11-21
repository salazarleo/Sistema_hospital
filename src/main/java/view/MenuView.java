package view;

import controller.DispositivoController;
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
    private final controller.ConsultaController consultaController = new controller.ConsultaController();
    private final DispositivoController dispositivoController = new DispositivoController(pacienteController.getPacientes());

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n----- MENU PRINCIPAL -----");
            System.out.println("1. Menu Pacientes");
            System.out.println("2. Menu Médicos");
            System.out.println("3. Menu Consultas");
            System.out.println("4. Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> exibirMenuPacientes();
                case 2 -> exibirMenuMedicos();
                case 3 -> agendarConsulta();
                case 4 -> System.out.println("\nSaindo... Até logo!");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 4);
    }

    private void exibirMenuPacientes() {
        int opcao;

        do {
            System.out.println("\n----- MENU PACIENTES -----");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Consultar Paciente");
            System.out.println("3. Listar Pacientes");
            System.out.println("4. Menu Dispositivos");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("\nEscolha uma opção: ");

            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> pacienteController.registrarPaciente(scanner);
                case 2 -> pacienteController.consultarPaciente(scanner);
                case 3 -> pacienteController.listarPacientes();
                case 4 -> exibirMenuDispositivos();
                case 5 -> System.out.println("\nVoltando ao Menu Principal...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }

            if (opcao != 5) {
                System.out.print("\nPressione 'Enter' para voltar ao menu de Pacientes...");
                scanner.nextLine();
            }
        } while (opcao != 5);
    }

    private void exibirMenuDispositivos() {
        int opcao;

        do {
            System.out.println("\n----- MENU DISPOSITIVOS -----");
            System.out.println("1. Cadastrar Dispositivo");
            System.out.println("2. Visualizar Dispositivos");
            System.out.println("3. Remover Dispositivo");
            System.out.println("4. Vincular Dispositivo a Paciente");
            System.out.println("5. Voltar ao Menu Pacientes");
            System.out.print("\nEscolha uma opção: ");

            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> cadastrarDispositivo();
                case 2 -> dispositivoController.visualizarDispositivos();
                case 3 -> removerDispositivo();
                case 4 -> vincularDispositivo();
                case 5 -> System.out.println("\nVoltando ao Menu Pacientes...");
                default -> System.out.println("\nOpção inválida. Por favor, tente novamente.");
            }

            if (opcao != 5) {
                System.out.print("\nPressione 'Enter' para voltar ao menu de Dispositivos...");
                scanner.nextLine();
            }
        } while (opcao != 5);
    }

    private void cadastrarDispositivo() {
        System.out.println("\n----- CADASTRAR DISPOSITIVO -----");

        System.out.print("Digite o tipo do dispositivo (ex: termômetro): ");
        String tipo = scanner.next();

        System.out.print("Digite a marca do dispositivo: ");
        String marca = scanner.next();

        System.out.print("Digite o modelo do dispositivo: ");
        String modelo = scanner.next();

        System.out.print("Digite o status (ativo/inativo): ");
        String status = scanner.next();

        System.out.print("Digite os valores de referência: ");
        String valoresReferencia = scanner.next();

        dispositivoController.cadastrarDispositivo(tipo, marca, modelo, status, valoresReferencia);
    }

    private void removerDispositivo() {
        System.out.print("Digite o ID do dispositivo a ser removido: ");
        int id = scanner.nextInt();
        dispositivoController.removerDispositivo(id);
    }

    private void vincularDispositivo() {
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.next();

        System.out.print("Digite o ID do dispositivo: ");
        int idDispositivo = scanner.nextInt();

        dispositivoController.vincularDispositivo(cpfPaciente, idDispositivo);
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
        String dosagem = scanner.nextLine();

        System.out.print("Digite a duração do tratamento (em dias): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

// Criando o objeto Medicamento com o nome e a dosagem
        Medicamento medicamento = new Medicamento(nomeMedicamento);


        System.out.println("\nPrescrição médica registrada com sucesso!");
    }

    private int lerOpcao() {
        int opcao = -1;
        try {
            opcao = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpar o buffer
        }
        return opcao;
    }
}
