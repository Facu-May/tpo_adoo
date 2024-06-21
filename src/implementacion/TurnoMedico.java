package implementacion;

import java.util.Date;

public class TurnoMedico {
	
	private Paciente cliente;

	private int id;

	private static int incremental = 0;
	
	private Medico medicoAsignado;
	
	private double costoTotal;
	
	private int complejidad;
	
	private Date fechaHora;
	
	private String estado;
	
	private String motivoConsulta;

	private String tratamiento;

	private Factura fact;

	public TurnoMedico(Paciente cliente, Medico medicoAsignado, double costoTotal, int complejidad,
			Date fechaHora, String estado, String motivoConsulta, String tratamiento) {
		super();
		incremental++;
		this.id = incremental;
		this.cliente = cliente;
		this.medicoAsignado = medicoAsignado;
		this.costoTotal = costoTotal;
		this.complejidad = complejidad;
		this.fechaHora = fechaHora;
		this.estado = estado;
		this.motivoConsulta = motivoConsulta;
		this.tratamiento = tratamiento;
	}

	public Paciente getCliente() {
		return cliente;
	}

	public void setCliente(Paciente cliente) {
		this.cliente = cliente;
	}

	public Medico getMedicoAsignado() {
		return medicoAsignado;
	}

	public void setMedicoAsignado(Medico medicoAsignado) {
		this.medicoAsignado = medicoAsignado;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public int getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(int complejidad) {
		this.complejidad = complejidad;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public int getId() {
		return id;
	}

	public String getTratamiento(){
		return tratamiento;
	}
	
	public void setTratamiento(String tratamiento){
		this.tratamiento = tratamiento;
	}

	public void setFactura(Factura fact) {
		this.fact = fact;
	}
	
}
