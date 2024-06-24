package implementacion;
import static org.junit.Assert.assertEquals;
import interfaz.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.Mockito;

import interfaz.EstrategiaFiltrado;

public class SistemaTest {
    private SistemaClinica sistema;
    private Paciente paciente;
    private Medico medico;

    @BeforeAll
    public static void setUp() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	
    	//Crear Pacientes
    	sistema.crearPaciente("22/04/2006", 556543,"Jose","Perez", "Calle Falsa 123", "OSDE", true, 5551234);
    	sistema.crearPaciente("15/04/2004", 44554,"Milito","Perez", "Calle Falsa 123", "OSDE", true, 5551234);
    	sistema.crearPaciente("27/04/2006", 44813781,"Jose","yuyu", "Calle Falsa 123", "OSDE", true, 5551234);
    	sistema.crearPaciente("22/01/2006", 44813782,"Juan","lol", "Calle Falsa 123", "OSDE", true, 5551234);
    	sistema.crearPaciente("22/08/2006", 2222222,"Wilmar","Barrios", "Calle Falsa 123", "OSDE", true, 5551234);
    	sistema.crearPaciente("22/09/2006", 445642,"Juan","skere", "Calle Falsa 123", "OSDE", true, 5551234);
    	
    	//Crear y agregar Medicos
        Medico medico = new Pediatria("Fabian", "sosa", 8);
        sistema.agregarMedico(medico);
    	medico = new Pediatria("Facundo", "PerezH", 2);
    	sistema.agregarMedico(medico);
    	medico = new Pediatria("lOL", "Holand", 3);
    	sistema.agregarMedico(medico);
    	medico = new Pediatria("Jorge", "PerezH", 4);
    	sistema.agregarMedico(medico);
    	medico = new Odontologia("Jose", "Holand", 5);
    	sistema.agregarMedico(medico);
    	medico = new Pediatria("Agus", "Grande", 6);
    	sistema.agregarMedico(medico);

    	
        //Crear Turnos
        sistema.crearTurnoMedico(556543, 8, "Hemo", 1, "Programada", 200, "18/09/2022", "Tratamiento super");
    	sistema.crearTurnoMedico(44813781, 3, "Fractura", 2, "Programada", 200, "01/04/2022", "Tratamiento nashe");
    	sistema.crearTurnoMedico(44813782, 4, "Fractura", 2, "Programada", 200, "21/04/2022", "Tratamiento nashe");
    	sistema.crearTurnoMedico(445642, 5, "Fractura", 2, "Programada", 200, "27/04/2022", "Tratamiento nashe");
    	sistema.crearTurnoMedico(2222222, 6, "Fractura", 2, "Programada", 202, "20/04/2022", "Tratamiento skere");
    	sistema.crearTurnoMedico(44554, 2, "Fractura", 2, "Programada", 202, "22/04/2022", "Tratamiento skere");

        
    }
    
    @Test
    public void testRegistrarNuevoPaciente() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	Paciente paciente = sistema.getPaciente(44554);
        assertNotNull(paciente);
        assertEquals("Milito", paciente.getNombre()); 
    }
    
    @Test
    public void testRegistrarMedico() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	Medico medico = sistema.getMedico(8);

        assertEquals("Fabian", medico.getNombre()); 

    }
    
    @Test
    public void testGenerarCitaMedica() {
    	SistemaClinica sistema = SistemaClinica.getInstance();

    	Paciente paciente = sistema.getPaciente(44813781);    	
    	assertEquals(1, sistema.getTurnoMedico(1).getId());
    }
    
    @Test
    public void testGenerarFactura() {
    	SistemaClinica sistema = SistemaClinica.getInstance();

    	Paciente paciente = sistema.getPaciente(44813781);
    	assertEquals(1, sistema.getTurnoMedico(1).getFactura().getId());
    }
    
    @Test
    public void testPagoSistemaExterno() {
    	SistemaClinica sistema = SistemaClinica.getInstance();

    	assertEquals("Pago Realizado Con Exito",sistema.pagoRealizado());
    }
    
    @Test
    public void filtrarCitasPorEspecialidad() 
    {
    	SistemaClinica sistema = SistemaClinica.getInstance();

    	Paciente paciente = sistema.getPaciente(2222222);
    
    	//filtro
    	EstrategiaFiltrado estrategiaMedico = new EstrategiaMedico();
    	sistema.setEstrategiaFiltrado(estrategiaMedico);
    	ArrayList<TurnoMedico> turnosMedicos = sistema.getTurnosMedicos();
    	ArrayList<TurnoMedico> turnosFiltrados = sistema.filtrarBusqueda(turnosMedicos, "Odontologia");
    
    	
    	assertEquals(1, turnosFiltrados.size());
    }
    
    @Test
    public void filtrarCitasPorFecha() 
    {
    	SistemaClinica sistema = SistemaClinica.getInstance();

    	Paciente paciente = sistema.getPaciente(2222222);

    	//filtro
    	EstrategiaFiltrado estrategiaMedico = new EstrategiaFecha();
    	sistema.setEstrategiaFiltrado(estrategiaMedico);
    	ArrayList<TurnoMedico> turnosMedicos1 = sistema.getTurnosMedicos();
    	ArrayList<TurnoMedico> turnosFiltrados1 = sistema.filtrarBusqueda(turnosMedicos1, "22/04/2022");
    	
    	assertEquals(1, turnosFiltrados1.size());
    }
    
    @Test
    public void filtrarCitasPorMatriculaMedico() 
    {
    	SistemaClinica sistema = SistemaClinica.getInstance();

    	Paciente paciente = sistema.getPaciente(2222222);

    	//filtro
    	EstrategiaFiltrado estrategiaMedico = new EstrategiaMatriculaMedico();
    	sistema.setEstrategiaFiltrado(estrategiaMedico);
    	
    	ArrayList<TurnoMedico> turnosMedicos2 = sistema.getTurnosMedicos();
    	ArrayList<TurnoMedico> turnosFiltrados2 = sistema.filtrarBusqueda(turnosMedicos2, "5");

    	
    	assertEquals(1, turnosFiltrados2.size());
    }
    
    @Test
    public void TestObserver() {
    	SistemaClinica sistema = SistemaClinica.getInstance();

    	TurnoMedico turno = sistema.getTurnoMedico(4);
    	
    	Subject sujetoConcreto = new ConcreteSubject();
    	Observer observer = new ConcreteObserver(turno);
    	
    	sujetoConcreto.registerObserver(observer);
    	
    	sujetoConcreto.notifyObservers("Cancelada", observer);
    	
    	assertEquals("Cancelada", turno.getEstado());
    	
    }
    
    @Test
    public void TurnosSuperpuestos() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	    	
		try {
	    	sistema.crearTurnoMedico(44813781, 3, "Fractura", 2, "Programada", 200, "01/04/2022", "Tratamiento nashe");
		} catch(RuntimeException e) {
			assertTrue(e.getMessage().equals("No se puede solicitar, se superpone con uno existente"));
		}
    	
    }
    
    @Test
    public void testGenerarFacturaConMock() {
        SistemaClinica sistemaMock = Mockito.mock(SistemaClinica.class);
        TurnoMedico turnoMock = Mockito.mock(TurnoMedico.class);
        Factura facturaMock = Mockito.mock(Factura.class);

        // Configuramos el mock para devolver una factura mock
        when(turnoMock.getFactura()).thenReturn(facturaMock);
        when(facturaMock.getId()).thenReturn(1);

        // Configuramos el sistema para devolver el turno mock
        when(sistemaMock.getTurnoMedico(1)).thenReturn(turnoMock);

        // Probamos la generación de la factura
        assertEquals(1, sistemaMock.getTurnoMedico(1).getFactura().getId());

        // Verificamos que los métodos del mock fueron llamados
        verify(turnoMock).getFactura();
        verify(facturaMock).getId();
    }

    
    
}
