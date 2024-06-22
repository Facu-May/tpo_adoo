package implementacion;

import java.util.*;

public class Paciente extends Persona{

	private Date fechaDeNacimietno;
	
	private int telefono;
	
	private String direccion;
	
	private String obraSocial;
	
	private int dni; 
	
	private ArrayList<TurnoMedico> listaTurnos;
	
	private boolean jubilado;

	public Paciente(String nombre, String apellido, 
	Date fechaDeNacimietno, int telefono, 
	String direccion, String obraSocial, boolean jubilado, int dni) {
		super(nombre,apellido);
		this.fechaDeNacimietno = fechaDeNacimietno;
		this.telefono = telefono;
		this.direccion = direccion;
		this.obraSocial = obraSocial;
		this.jubilado = jubilado;
		this.dni = dni;
		listaTurnos = new ArrayList<TurnoMedico>();
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
		for (TurnoMedico turno: listaTurnos) 
		{
			//Agregar despues para ver el historial de los turnos	
		}
	}


	public boolean soyElPaciente(int dni)
	{
		return this.dni == dni;
	}

	public void addTurnoMedico(TurnoMedico turno)
	{
		listaTurnos.add(turno);
	}

	public String getNombre()
	{
		return this.apellido + ", " + this.nombre;
	}
	
	public TurnoMedico getTurnoMedico(int id) 
	{ 
		for(TurnoMedico turno : listaTurnos) 
		{
			if(turno.getId() == id) 
			{
				return turno;
			} 
		}
		 return null;
	}
	
	public int getDescuento()
	{
		int descuento = 0;
		if(jubilado)
		{
			descuento = 50;
		}
		if(this.obraSocial.equals("PAMI"))
		{
			descuento = descuento + 20;
		}
		else if(this.obraSocial.equals("OSDE"))
		{
			descuento = descuento + 30;
		}
		else if(this.obraSocial.equals("SWISS MEDICAL"))
		{
			descuento = descuento + 40;
		}
		else if(this.obraSocial.equals("IOSFA"))
		{
			descuento = descuento + 50;
		}
		return descuento;
	}
	
}

