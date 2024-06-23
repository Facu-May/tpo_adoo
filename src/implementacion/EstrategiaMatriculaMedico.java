package implementacion;


import interfaz.*;
import java.util.ArrayList;
import java.util.List;
 
import interfaz.EstrategiaFiltrado;
 
public class EstrategiaMatriculaMedico implements EstrategiaFiltrado {
	private List<TurnoMedico> turnos;
 
	@Override
	public List<TurnoMedico> filtrarBusqueda(TurnoMedico turnoMedico) {
		List<TurnoMedico> turnosFiltrados = new ArrayList<>();
		for (TurnoMedico turno : turnos) {
            if (turno.getMedicoAsignado().getNroMatricula() == turnoMedico.getMedicoAsignado().getNroMatricula()){
                turnosFiltrados.add(turno);
            }
        }
        return turnosFiltrados;
	}
 
 
    
 
}