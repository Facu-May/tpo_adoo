package implementacion;

import interfaz.Observer;

public class ConcreteObserver implements Observer {

	private String name;
	
	private int nro_paciente;
	
	private TurnoMedico turnomedico; 
	

	public ConcreteObserver(String name, int nro_paciente,TurnoMedico turnomedico ) {
        this.name = name;
        this.nro_paciente = nro_paciente;
        this.turnomedico = turnomedico;
    }
	

    @Override
    public void update(int opcion, int id) {
    	/*Acomodar segun que desea notificar con la opcion y estoy pensando que 
    	 * cada observer va a ser un paciente que se le notifique y se le asocie el turno medico */
    	
        System.out.println("El doctor " + turnomedico.getMedicoAsignado().getNombre() + " le notifica que lo espera el dia " + turnomedico.getFechaHora());
    }
}
