package implementacion;

import interfaz.TurnoMedicoBuilder;

public abstract class Medico extends Persona{
	int nroMatricula;
	
	

	public int getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(int nroMatricula) {
		this.nroMatricula = nroMatricula;
	}

	public void programarCita(Paciente paciente,TurnoMedicoBuilder cita) {
		 
	}
	
	public void ealizarConsulta(TurnoMedicoBuilder turno) {
		
	}
}
