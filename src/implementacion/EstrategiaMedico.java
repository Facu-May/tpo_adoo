package implementacion;
 
import java.util.ArrayList;
import java.util.List;
 
import interfaz.EstrategiaFiltrado;
 
public class EstrategiaMedico implements EstrategiaFiltrado {
	
	@Override
	public ArrayList<TurnoMedico> filtrarBusqueda(ArrayList<TurnoMedico> turnosMedicos, String especialidad) {
		ArrayList<TurnoMedico> turnosFiltrados = new ArrayList<TurnoMedico>();

		for (TurnoMedico turno : turnosMedicos) {
			
            if (turno.getMedicoAsignado().getEspecialidad().equals(especialidad))
            {
                turnosFiltrados.add(turno);
            }
        }
        return turnosFiltrados;
	}
 
}