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

import interfaz.EstrategiaFiltrado;

public class SistemaTest {
    private SistemaClinica sistema;
    private Paciente paciente;
    private Medico medico;

    @Before
    public void setUp() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("22/04/2006", 556543,"Jose","Perez", "Calle Falsa 123", "OSDE", true, 5551234);
        Medico medico = new Pediatria("Fabian", "sosa", 8);
        sistema.agregarMedico(medico);
        sistema.crearTurnoMedico(556543, 8, "Hemo", 1, "Programada", 200, "18/09/2022", "Tratamiento super");
        
    }
    
    @Test
    public void testRegistrarNuevoPaciente() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("15/04/2004", 44554,"Milito","Perez", "Calle Falsa 123", "OSDE", true, 5551234);
    	Paciente paciente = sistema.getPaciente(44554);
        assertNotNull(paciente);
        assertEquals("Milito", paciente.getNombre()); 
    }
    
    @Test
    public void testRegistrarMedico() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	Medico medico = new Pediatria("Facundo", "PerezH", 2);
    	sistema.agregarMedico(medico);
        assertEquals("Facundo", medico.getNombre()); 

    }
    
    @Test
    public void testGenerarCitaMedica() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("1621396800", 44813781,"Jose","Fafa", "Calle Falsa 123", "OSDE", true, 5551234);
    	Medico medico = new Pediatria("lOL", "Holand", 3);
    	sistema.agregarMedico(medico);
    	Paciente paciente = sistema.getPaciente(44813781);
    	sistema.crearTurnoMedico(44813781, 3, "Fractura", 2, "Programada", 200, "22/04/2022", "Tratamiento nashe");
    	
    	assertEquals(1, sistema.getTurnoMedico(1).getId());
    }
    
    @Test
    public void testGenerarFactura() {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("1621396800", 44813782,"Juan","Fafa", "Calle Falsa 123", "OSDE", true, 5551234);
    	Medico medico = new Pediatria("Jorge", "PerezH", 4);
    	sistema.agregarMedico(medico);
    	Paciente paciente = sistema.getPaciente(44813781);
    	sistema.crearTurnoMedico(44813782, 4, "Fractura", 2, "Programada", 200, "22/04/2022", "Tratamiento nashe");
    	
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
    	sistema.crearPaciente("1621396800", 2222222,"Juan","Fafa", "Calle Falsa 123", "OSDE", true, 5551234);
    	//creo medicos
    	Medico medico = new Odontologia("Jose", "Holand", 5);
    	sistema.agregarMedico(medico);
    	Medico medico2 = new Pediatria("Agus", "Grande", 6);
    	sistema.agregarMedico(medico2);
    	
    	//creo paciente	
    	Paciente paciente = sistema.getPaciente(2222222);
    	
    	
    	sistema.crearTurnoMedico(2222222, 5, "Fractura", 2, "Programada", 200, "22/04/2022", "Tratamiento nashe");
    	sistema.crearTurnoMedico(2222222, 6, "Fractura", 2, "Programada", 202, "20/04/2022", "Tratamiento skere");
		
    	
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
    	sistema.crearPaciente("1621396800", 2222222,"Juan","Fafa", "Calle Falsa 123", "OSDE", true, 5551234);
    	//creo medicos
    	Medico medico = new Odontologia("Jose", "Holand", 5);
    	sistema.agregarMedico(medico);
    	Medico medico2 = new Pediatria("Agus", "Grande", 6);
    	sistema.agregarMedico(medico2);
    	
    	//creo paciente
    	Paciente paciente = sistema.getPaciente(2222222);
    	
    	
    	//creo turnos
    	sistema.crearTurnoMedico(2222222, 5, "Fractura", 2, "Programada", 200, "22/04/2022", "Tratamiento nashe");
    	sistema.crearTurnoMedico(2222222, 6, "Fractura", 2, "Programada", 202, "20/04/2022", "Tratamiento skere");

    	
    	//filtro
    	EstrategiaFiltrado estrategiaMedico = new EstrategiaFecha();
    	sistema.setEstrategiaFiltrado(estrategiaMedico);
    	ArrayList<TurnoMedico> turnosMedicos1 = sistema.getTurnosMedicos();
    	ArrayList<TurnoMedico> turnosFiltrados1 = sistema.filtrarBusqueda(turnosMedicos1, "22/04/2022");
    	
    	for (TurnoMedico turnoMedico : turnosFiltrados1) {
			System.out.println(turnoMedico.getFechaHora());
		}
    	
    	assertEquals(1, turnosFiltrados1.size());
    }
    
    @Test
    public void filtrarCitasPorMatriculaMedico() 
    {
    	SistemaClinica sistema = SistemaClinica.getInstance();
    	sistema.crearPaciente("1621396800", 2222222,"Juan","Fafa", "Calle Falsa 123", "OSDE", true, 5551234);
    	//creo medicos
    	Medico medico = new Odontologia("Jose", "Holand", 5);
    	sistema.agregarMedico(medico);
    	Medico medico2 = new Pediatria("Agus", "Grande", 6);
    	sistema.agregarMedico(medico2);
    	
    	//creo paciente
    	Paciente paciente = sistema.getPaciente(2222222);
    	
    	
    	//creo turnos
    	sistema.crearTurnoMedico(2222222, 5, "Fractura", 2, "Programada", 200, "22/04/2022", "Tratamiento nashe");
    	sistema.crearTurnoMedico(2222222, 6, "Fractura", 2, "Programada", 202, "20/04/2022", "Tratamiento skere");

    	
    	//filtro
    	EstrategiaFiltrado estrategiaMedico = new EstrategiaMatriculaMedico();
    	sistema.setEstrategiaFiltrado(estrategiaMedico);
    	ArrayList<TurnoMedico> turnosMedicos2 = sistema.getTurnosMedicos();
    	ArrayList<TurnoMedico> turnosFiltrados2 = sistema.filtrarBusqueda(turnosMedicos2, "5");
    	for (Paciente pacienteSolo : sistema.getPacientes()) {
			System.out.println(pacienteSolo.getDni());
		}
    	
    	assertEquals(1, turnosFiltrados2.size());
    }
   
    

    
}
