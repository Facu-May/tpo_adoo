package implementacion;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
    private SistemaClinica sistema;
    private Paciente paciente;
    private Medico medico;

    @Before
    public void setUp() {
    	SistemaClinica sistema = new SistemaClinica();
        Paciente paciente = new Paciente("Juan", "Perez","1621396800", 1159118721, "Calle Falsa 123", "OSDE", true, 5551234);
        Medico medico = new Pediatria("Fabian", "sosa", 445);
        sistema.agregarMedico(medico);
    }
    
    /*@Test
    public void testRegistrarNuevoPaciente() {
    	Paciente paciente = new Paciente("Milito", "Perez","1621396800", 44554, "Calle Falsa 123", "OSDE", true, 5551234);
        System.out.println(paciente.getNombre());
        assertNotNull(paciente);
        assertEquals("Milito", paciente.getNombre()); 
    }*/
    
    @Test
    public void testRegistrarNuevoPaciente() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("1621396800", 44554,"Milito","Perez", "Calle Falsa 123", "OSDE", true, 5551234);
    	Paciente paciente = sistema.getPaciente(44554);
        assertNotNull(paciente);
        assertEquals("Milito", paciente.getNombre()); 
    }
    
    @Test
    public void testRegistrarMedico() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	Medico medico = new Pediatria("Facundo", "PerezH", 1145);
    	sistema.agregarMedico(medico);
        assertEquals("Facundo", medico.getNombre()); 

    }
    
    /*int dniPaciente, int matriculaMedico, String motivo, int complejidad, String estado, double costo, String fch, String tratamiento*/
    @Test
    public void testGenerarCitaMedica() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("1621396800", 44813781,"Jose","Fafa", "Calle Falsa 123", "OSDE", true, 5551234);
    	Medico medico = new Pediatria("Jose", "Holand", 1111);
    	sistema.agregarMedico(medico);
    	Paciente paciente = sistema.getPaciente(44813781);
    	sistema.crearTurnoMedico(44813781, 1111, "Fractura", 2, "Programada", 200, "22/04/2022", "Tratamiento nashe");
    	
    	assertEquals(1, sistema.getTurnoMedico(1).getId());
    }
    
    @Test
    public void testGenerarFactura() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("1621396800", 44813782,"Juan","Fafa", "Calle Falsa 123", "OSDE", true, 5551234);
    	Medico medico = new Pediatria("Jose", "Holand", 1111);
    	sistema.agregarMedico(medico);
    	Paciente paciente = sistema.getPaciente(44813781);
    	sistema.crearTurnoMedico(44813782, 1111, "Fractura", 2, "Programada", 200, "22/04/2022", "Tratamiento nashe");
    	
    	assertEquals(44813782, sistema.getTurnoMedico(1).getFactura().getPaciente().getDni());
    }
    
    @Test
    public void testPagoSistemaExterno() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	assertEquals("Pago Realizado Con Exito",sistema.pagoRealizado());
    }
    
    
    
    
    
    /*@Test
	public void agregarPacienteCodigoDuplicadoDaError() {
		try {
			Paciente paciente1 = new Paciente("22","Juan","gomez",LocalDate.now(),"","","","");
			sistema.agregarPaciente(paciente1);
		} catch(RuntimeException e) {
			assertTrue(e.getMessage().equals("Paciente ya registrado"));
		}
	}*/
    
}
