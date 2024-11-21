# Sistema de Monitoramento de Pacientes e Dispositivos

Este projeto é um sistema de monitoramento que gerencia pacientes, dispositivos médicos, consultas e alertas em um ambiente hospitalar. Ele inclui diversas funcionalidades para registro de dados, análise de informações, geração de alertas e agendamento de consultas.

## 🛠️ Funcionalidades

- Registro e gerenciamento de pacientes.
- Cadastro e configuração de dispositivos médicos.
- Monitoramento de sinais vitais e geração de alertas.
- Agendamento de consultas entre médicos e pacientes.
- Análise de monitoramentos e emissão de prescrições.

---

## 📁 Estrutura do Projeto

O projeto está dividido em diversas classes e controladores que gerenciam funcionalidades específicas. A seguir, a explicação das principais classes:

### **Classes do Modelo**

- **`Paciente`**  
  Representa os pacientes do sistema, contendo informações como nome, CPF e idade.

- **`Dispositivo`**  
  Modela os dispositivos médicos, incluindo nome, marca, modelo e status.

- **`Monitoramento`**  
  Gerencia os dados monitorados de pacientes, como sinais vitais coletados de dispositivos.

- **`Medicamento`**  
  Representa os medicamentos prescritos, armazenando informações como nome, dosagem e duração.

- **`Medico`**  
  Armazena informações sobre os médicos, como nome, CRM, especialidade e contato.

- **`Consulta`**  
  Modela as consultas entre médicos e pacientes, armazenando detalhes do agendamento.

---

### **Controladores**

- **`PacienteController`**  
  Responsável pelo gerenciamento de pacientes, incluindo registro, busca e listagem.

- **`DispositivoController`**  
  Gerencia dispositivos médicos, possibilitando cadastro, busca e análise de status.

- **`AlertaController`**  
  Emite alertas baseados em condições críticas de monitoramento.

- **`ConsultaController`**  
  Permite agendar consultas e listar os agendamentos realizados.

---

### **Interface de Usuário**

- **`MenuView`**  
  Controla a interação do sistema com o usuário, permitindo navegar entre as funcionalidades por meio de um menu principal.

---

## 🧪 Testes Unitários

O projeto conta com testes unitários para garantir a qualidade do código e o funcionamento correto de suas funcionalidades. A seguir, um resumo dos principais testes:

- **Testes de Monitoramento**  
  - Testa o registro de monitoramento para pacientes e dispositivos válidos e inválidos.  
  - Verifica a geração de alertas para monitoramentos críticos.  

- **Testes do MenuView**  
  - Testa a navegação no menu e as ações disparadas, como registrar pacientes, cadastrar dispositivos e agendar consultas.  

- **Testes de Funcionalidades Específicas**  
  - Verifica o agendamento de consultas entre médicos e pacientes.  
  - Testa a adição de prescrições médicas ao sistema.  

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu_usuario/seu_projeto.git
2. **Compile o projeto**: 
Use uma IDE como IntelliJ IDEA ou Eclipse para compilar as classes.
3. **Execute os testes**:
Rode os testes unitários utilizando o JUnit para garantir que tudo está funcionando corretamente.
