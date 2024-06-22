package implementacion;
 
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
 
import interfaz.EstrategiaFiltrado;
 
public class EstrategiaFecha implements EstrategiaFiltrado{
	private List<TurnoMedico> turnos;
	@Override
	public List<TurnoMedico> filtrarBusqueda(TurnoMedico turnoMedico) {
		List<TurnoMedico> turnosFiltrados = new ArrayList<>();
		for (TurnoMedico turno : turnos) {
            if (turno.getFechaHora().equals(turnoMedico.getFechaHora())) {
                turnosFiltrados.add(turno);
            }
        }
        return turnosFiltrados;
	}

 
}