package interfaz;

import java.util.*;

import implementacion.Factura;
import implementacion.Medico;
import implementacion.Paciente;
import implementacion.TurnoMedico;

public interface TurnoMedicoBuilder {
	
	
	
	Paciente buscarCliente(int dni);
	
	double obtenerCostoTotal(int dni, int descuento);
	
	int obtenerComplejidad(int dni);
	
	String obtenerFecha(int dni);
	
	String obtenerEstado(int dni);
	
	String obtenerMotivo(int dni);
	
	Medico obtenerMedicoAsignado(int dni, int matricula);

	TurnoMedico build(Paciente paciente, Medico medico, double costo, int complejidad, String fecha, String estado, String motivo, String tratamiento);

	void buildFactura(Paciente paciente, TurnoMedico turno, int total, int descuento);
	
	
	

	
	
}
