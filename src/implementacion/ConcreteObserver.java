package implementacion;

import interfaz.Observer;

public class ConcreteObserver implements Observer {
	private TurnoMedico turnoMedico;

	public ConcreteObserver(TurnoMedico turnoMedico) {
		this.turnoMedico = turnoMedico;
    }
	
    @Override
    public void update(String estado) 
    {
        System.out.println("El medico " + turnoMedico.getMedicoAsignado().getNombre() + " ha notificado a " + turnoMedico.getCliente().getNombre() + 
        		", area Marketing y area Contable");
        turnoMedico.setEstado(estado);
        			
    }
}
