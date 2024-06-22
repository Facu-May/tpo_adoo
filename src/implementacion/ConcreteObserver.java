package implementacion;

import interfaz.Observer;

public class ConcreteObserver implements Observer {
	private Paciente paciente;
	private ConcreteSubject sujeto;
	//private TurnoMedico turnoMedico;
	

	public ConcreteObserver() {
      
    }
	
    @Override
    public void update() 
    {
    	int id = sujeto.getIdTurnoMedico();
    	TurnoMedico turnoMedico = paciente.getTurnoMedico(id);
        System.out.println("El medico " + turnoMedico.getMedicoAsignado().getNombre() + "ha notificado a " + paciente.getNombre() + "");
    }
}
