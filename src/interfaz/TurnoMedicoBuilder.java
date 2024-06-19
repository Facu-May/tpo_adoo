package interfaz;

import java.util.*;

import implementacion.Medico;
import implementacion.Paciente;

public interface TurnoMedicoBuilder {
	
	
	
	Paciente buscarCliente(int dni);
	
	double obtenerCostoTotal(int dni, int descuento);
	
	int obtenerComplejidad(int dni);
	
	Date obtenerFecha(int dni);
	
	String obtenerEstado(int dni);
	
	String obtenerMotivo(int dni);
	
	Medico obtenerMedicoAsignado(int dni, int matricula);
	
	
	

	
	
}
