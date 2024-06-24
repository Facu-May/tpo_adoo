package implementacion;


import interfaz.*;
import java.util.ArrayList;
import java.util.List;
 
import interfaz.EstrategiaFiltrado;
 
public class EstrategiaMatriculaMedico implements EstrategiaFiltrado {
 
	@Override
	public ArrayList<TurnoMedico> filtrarBusqueda(ArrayList<TurnoMedico> turnosMedicos, String matricula) {
		ArrayList<TurnoMedico> turnosFiltrados = new ArrayList<>();
		int matriculaRecibida = Integer.parseInt(matricula);
		for (TurnoMedico turno : turnosMedicos) {
            if (turno.getMedicoAsignado().getNroMatricula() == matriculaRecibida){
                turnosFiltrados.add(turno);
            }
        }
        return turnosFiltrados;
	}
 
 
    
 
}