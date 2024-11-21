package test.java.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultaTest {

    private ConsultaTest consulta;
    private model.Medico medico;
    private model.Paciente paciente;

    // Método que será executado antes de cada teste
    @BeforeEach
    public void setUp() {
        // Inicializando os objetos Medico e Paciente com dados fictícios
        medico = new model.Medico("Dr. João", 12345, "Cardiologista", "joao@email.com", "99999-9999");
        paciente = new model.Paciente("Carlos Silva", "123.456.789-00", 30, "Masculino");

        // Inicializando a ConsultaTest com dados fictícios
        consulta = new ConsultaTest("20/11/2024", "10:00", "Hipertensão", "Medicamento A", medico, paciente);
    }

    // Teste do construtor e dos getters
    @Test
    public void testCriarConsulta() {
        assertNotNull(consulta);
        assertEquals("20/11/2024", consulta.getData());
        assertEquals("10:00", consulta.getHora());
        assertEquals("Hipertensão", consulta.getDiagnostico());
        assertEquals("Medicamento A", consulta.getPrescricaomed());
        assertEquals(medico, consulta.getMedico());
        assertEquals(paciente, consulta.getPaciente());
    }

    // Teste do método toString
    @Test
    public void testToString() {
        String resultadoEsperado = "Consulta{" +
                "data='20/11/2024', hora='10:00', diagnostico='Hipertensão', prescricaomed='Medicamento A', " +
                "medico=Medico{crm=12345, nome='Dr. João', especialidade='Cardiologista', email='joao@email.com', " +
                "telefone='99999-9999', prescricoes=[]}, paciente=Paciente{nome='Carlos Silva', cpf='123.456.789-00', idade=30, sexo='Masculino'}}";

        assertEquals(resultadoEsperado, consulta.toString());
    }

    // Teste dos setters e getters
    @Test
    public void testSettersGetters() {
        // Modificando valores usando os setters
        consulta.setData("21/11/2024");
        consulta.setHora("14:00");
        consulta.setDiagnostico("Asma");
        consulta.setPrescricaomed("Medicamento B");

        // Verificando se os valores foram alterados corretamente
        assertEquals("21/11/2024", consulta.getData());
        assertEquals("14:00", consulta.getHora());
        assertEquals("Asma", consulta.getDiagnostico());
        assertEquals("Medicamento B", consulta.getPrescricaomed());
    }

    // Teste dos setters e getters de Médico e Paciente
    @Test
    public void testSetMedicoPaciente() {
        // Modificando médico e paciente
        Medico novoMedico = new Medico("Dr. Pedro", 67890, "Dermatologista", "pedro@email.com", "98888-8888");
        Paciente novoPaciente = new Paciente("Maria Oliveira", "987.654.321-00", 28, "Feminino");

        consulta.setMedico(novoMedico);
        consulta.setPaciente(novoPaciente);

        // Verificando se os valores foram alterados corretamente
        assertEquals(novoMedico, consulta.getMedico());
        assertEquals(novoPaciente, consulta.getPaciente());
    }
}
