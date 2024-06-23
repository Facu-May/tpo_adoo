package implementacion;

import java.util.*;

public class Paciente extends Persona{

	private String fechaDeNacimietno;
	
	private int telefono;
	
	private String direccion;
	
	private String obraSocial;
	
	private int dni; 
	
	private boolean jubilado;

	public Paciente(String nombre, String apellido, 
	String fechaDeNacimietno, int telefono, 
	String direccion, String obraSocial, boolean jubilado, int dni) {
		super(nombre,apellido);
		this.fechaDeNacimietno = fechaDeNacimietno;
		this.telefono = telefono;
		this.direccion = direccion;
		this.obraSocial = obraSocial;
		this.jubilado = jubilado;
		this.dni = dni;
	}

	
	public void solicitarCita(int dni, int matricula, Date fechaTurno, int complejidad) {
		
	}
	
	
	public int getDni() {
		return dni;
	}

	public void verHistorialMedico() {
        for (TurnoMedico turno: this.getTurnosMedico()) {
            System.out.println(turno);
        }
    }


	public boolean soyElPaciente(int dni)
	{
		return this.dni == dni;
	}

	public void addTurnoMedico(TurnoMedico turno)
	{
		this.setListaTurno(turno);
	}

	
	public TurnoMedico getTurnoMedico(int id) 
	{ 
		for(TurnoMedico turno : this.getTurnosMedico()) 
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


	@Override
	public String toString() {
		return "Paciente [nombre =" + nombre + "fechaDeNacimietno=" + fechaDeNacimietno + ", telefono=" + telefono + ", direccion="
				+ direccion + ", obraSocial=" + obraSocial + ", dni=" + dni + ", jubilado=" + jubilado + "]";
	}
	

	
}

