package implementacion;

import java.util.ArrayList;

public abstract class Persona 
{
	protected String nombre;
	protected String apellido;
	private ArrayList<TurnoMedico> listaTurnos;

	protected Persona(String nombre, String apellido) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.listaTurnos = new ArrayList<TurnoMedico>();
	}
	
	public ArrayList<TurnoMedico> getTurnosMedico(){
		return listaTurnos;
	}
	
	public void setListaTurno(TurnoMedico turnoMedico) {
		listaTurnos.add(turnoMedico);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}


	
	

}
