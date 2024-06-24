package implementacion;
 
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
 
import interfaz.EstrategiaFiltrado;
 
public class EstrategiaFecha implements EstrategiaFiltrado{
	@Override
	public ArrayList<TurnoMedico> filtrarBusqueda(ArrayList<TurnoMedico> turnosMedicos, String fecha) {
		ArrayList<TurnoMedico> turnosFiltrados = new ArrayList<>();
		for (TurnoMedico turno : turnosMedicos) {
            if (turno.getFechaHora().equals(fecha)) {
                turnosFiltrados.add(turno);
            }
        }
        return turnosFiltrados;
	}

 
}