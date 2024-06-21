package implementacion;

import java.util.*;

public class Paciente {

	Date fechaDeNacimietno;
	
	int telefono;
	
	String direccion;
	
	String obraSocial;
	
	int dni; /*Nunca agregamos DNI*/
	
	ArrayList<TurnoMedico> listaTurnos = new ArrayList<TurnoMedico>();
	
	boolean jubilado;

	public Paciente(Date fechaDeNacimietno, int telefono, String direccion, String obraSocial, boolean jubilado, int dni) {
		super();
		this.fechaDeNacimietno = fechaDeNacimietno;
		this.telefono = telefono;
		this.direccion = direccion;
		this.obraSocial = obraSocial;
		this.jubilado = jubilado;
		this.dni = dni;
	}

	public ArrayList<TurnoMedico> getListaTurnos() {
		return listaTurnos;
	}

	public void setListaTurnos(TurnoMedico turnos) {
		listaTurnos.add(turnos);
	}
	
	public void solicitarCita(int dni, int matricula, Date fechaTurno, int complejidad) {
		
	}
	
	
	public int getDni() {
		return dni;
	}

	public void verHistorialMedico() {
		for (TurnoMedico turno: listaTurnos) {
			//Agregar despues para ver el historial de los turnos	
		}
	}


	public boolean soyElPaciente(int dni)
	{
		return this.dni == dni;
	}

	
	
	
	
}

