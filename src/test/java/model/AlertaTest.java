package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AlertaTest {

    private AlertaTest alerta;
    private model.Medico medico;
    private model.Paciente paciente;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializando os objetos Medico e Paciente com dados fictícios
        medico = new model.Medico("Dr. João", 12345, "Cardiologista", "joao@email.com", "99999-9999");
        paciente = new model.Paciente("Carlos Silva", "123.456.789-00", 30, "Masculino");

        // Inicializando o AlertaTest com dados fictícios
        alerta = new AlertaTest("Emergência", "Atenção, paciente com risco de parada cardíaca.", paciente, medico);
    }

    // Teste do construtor e dos getters
    @Test
    public void testCriarAlerta() {
        assertNotNull(alerta);
        assertEquals("Emergência", alerta.getTipo());
        assertEquals("Atenção, paciente com risco de parada cardíaca.", alerta.getMensagem());
        assertEquals(paciente, alerta.getPaciente());
        assertEquals(medico, alerta.getMedico());
        assertNotNull(alerta.getDataGeracao());  // Verificando se a data de geração não é nula
    }

    // Teste do método toString
    @Test
    public void testToString() {
        String resultadoEsperado = "Alerta{" +
                "tipo='Emergência', mensagem='Atenção, paciente com risco de parada cardíaca.', paciente=Paciente{nome='Carlos Silva', cpf='123.456.789-00', idade=30, sexo='Masculino'}, medico=Medico{crm=12345, nome='Dr. João', especialidade='Cardiologista', email='joao@email.com', telefone='99999-9999', prescricoes=[]}, dataGeracao=" + alerta.getDataGeracao() + "}";

        assertTrue(alerta.toString().contains("Emergência"));
        assertTrue(alerta.toString().contains("Atenção, paciente com risco de parada cardíaca."));
    }

    // Teste dos setters e getters
    @Test
    public void testSettersGetters() {
        // Modificando valores usando os setters
        alerta.setTipo("Anormalidade");
        alerta.setMensagem("Paciente com níveis elevados de pressão arterial.");

        // Verificando se os valores foram alterados corretamente
        assertEquals("Anormalidade", alerta.getTipo());
        assertEquals("Paciente com níveis elevados de pressão arterial.", alerta.getMensagem());
    }

    // Teste de set e get do Médico e Paciente
    @Test
    public void testSetMedicoPaciente() {
        // Modificando médico e paciente
        Medico novoMedico = new Medico("Dr. Pedro", 67890, "Dermatologista", "pedro@email.com", "98888-8888");
        Paciente novoPaciente = new Paciente("Maria Oliveira", "987.654.321-00", 28, "Feminino");

        alerta.setMedico(novoMedico);
        alerta.setPaciente(novoPaciente);

        // Verificando se os valores foram alterados corretamente
        assertEquals(novoMedico, alerta.getMedico());
        assertEquals(novoPaciente, alerta.getPaciente());
    }
}
