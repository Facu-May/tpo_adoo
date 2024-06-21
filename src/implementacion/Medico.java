package implementacion;


public abstract class Medico extends Persona{
	int nroMatricula;
	
	

	public int getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(int nroMatricula) {
		this.nroMatricula = nroMatricula;
	}

    public void programarCita(int id) {
		TurnoMedico cita = buscarTurnoMedico(id);
		if (cita == null) {
			System.out.println("No existe la cita");
			return;
		}
		else
		{
        	cita.setMedicoAsignado(this);
        	cita.setEstado("Programada");
		}
    }
	
    public void realizarConsulta(int id, String tratamiento) {
		TurnoMedico turno = buscarTurnoMedico(id);
		if (turno == null) {
            System.out.println("El turno no existe");
		}
		else
		{
			if (turno.getEstado()=="Programada") {
				turno.setEstado("Realizada");
				turno.setTratamiento(tratamiento);
			} else {
				System.out.println("El turno no está programado");
			}
		}
    }

	public TurnoMedico buscarTurnoMedico(int id){
		for (TurnoMedico turnoMedico : listaTurnos) {
			if (turnoMedico.id == id) {
				return turnoMedico;
			}
		}
		return null;
	}
}
