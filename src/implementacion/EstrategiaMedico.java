package implementacion;
 
import java.util.ArrayList;
import java.util.List;
 
import interfaz.EstrategiaFiltrado;
 
public class EstrategiaMedico implements EstrategiaFiltrado {
	private List<TurnoMedico> turnos;
	@Override
	
	public List<TurnoMedico> filtrarBusqueda(TurnoMedico turnoMedico) {
		List<TurnoMedico> turnosFiltrados = new ArrayList<>();
		for (TurnoMedico turno : turnos) {
            if (turno.getMedicoAsignado().getEspecialidad().equals(turnoMedico.getMedicoAsignado().getEspecialidad()))
            {
                turnosFiltrados.add(turno);
            }
        }
        return turnosFiltrados;
	}
 
}