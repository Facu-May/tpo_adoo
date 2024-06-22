package implementacion;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import implementacion.*;
import interfaz.*;

public class SistemaTest {
    private SistemaClinica sistema;

    @BeforeEach
    public void setUp() {
        sistema = SistemaClinica.getInstance();
    }

    @Test
    public void testRegistrarNuevoPaciente() {
        sistema.registrarPaciente("22/06/1980", 12345678, "Juan", "Perez", "Calle Falsa 123", "OSDE", true, 5551234);
        Paciente paciente = sistema.getPaciente(12345678);
        assertNotNull(paciente);
        assertEquals("Juan", paciente.getNombre());
    }
    
}
