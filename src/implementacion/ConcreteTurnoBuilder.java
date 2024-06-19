package implementacion;

import java.util.*;

import interfaz.TurnoMedicoBuilder;

public class ConcreteTurnoBuilder implements TurnoMedicoBuilder {

	private ArrayList<TurnoMedico> turnoMedico = new ArrayList<TurnoMedico>();
	
	public Paciente buscarCliente(int id) {
		for(TurnoMedico turnomedico : turnoMedico){
			if (turnomedico.getId() == id) {
				return turnomedico.getCliente();
			}
		}
		return null;
	};
	
	public double obtenerCostoTotal(int id, int descuento) {
		for(TurnoMedico turnomedico : turnoMedico){
			if (turnomedico.getId() == id) {
				return (turnomedico.getCostoTotal() - descuento);
			}
		}
		return -1;
	};
	
	public int obtenerComplejidad(int id) {
		for (TurnoMedico turnomedico : turnoMedico) {
			if (turnomedico.getId() == id) {
				return turnomedico.getComplejidad();
			}	
		}
		return -1;
	};
	
	public Date obtenerFecha(int id) {
		for (TurnoMedico turnomedico : turnoMedico) {
			if(turnomedico.getId() == id) {
				return turnomedico.getFechaHora();
			}
		}
		return null;
	};
	
	public String obtenerEstado(int id) {
		for (TurnoMedico turnomedico : turnoMedico) {
			if (turnomedico.getId() == id) {
				return turnomedico.getEstado();
			}
		}
		return null;
	};
	
	public String obtenerMotivo(int id) {
		for (TurnoMedico turnomedico : turnoMedico) {
			if(turnomedico.getId() == id) {
				return turnomedico.getMotivoConsulta();
			}
		}
		return null;
	};
	
	public Medico obtenerMedicoAsignado(int id, int matricula) {
		for (TurnoMedico turnomedico : turnoMedico) {
			if(turnomedico.getMedicoAsignado().getNroMatricula() == matricula) {
				return turnomedico.getMedicoAsignado();
			}
		}
		return null;
	};
}
