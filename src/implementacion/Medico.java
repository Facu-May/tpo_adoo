package implementacion;


public abstract class Medico extends Persona
{
	protected int nroMatricula;
	

	protected Medico(String nombre, String apellido, int nroMatricula) {
		super(nombre, apellido);
		this.nroMatricula = nroMatricula;
	}

	public int getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(int nroMatricula) {
		this.nroMatricula = nroMatricula;
	}


	public boolean soyElMedico(int nroMatricula)
	{
		return this.nroMatricula == nroMatricula;
	}
	public abstract int getPrecio();
	public abstract String getEspecialidad();
	
    public void programarCita(Paciente paciente, TurnoMedico cita) {
        cita.setMedicoAsignado(this);
        cita.setCliente(paciente);
        cita.setEstado("Programada");
    }
	
    public void realizarConsulta(TurnoMedico turno, String tratamiento) {
        if (turno.getEstado()=="Programada") {
            turno.setEstado("Realizada");
            turno.setTratamiento(tratamiento);
        } else {
            System.out.println("El turno no está programado");
        }
    }
}
