package interfaz;
 
import java.util.ArrayList;
import java.util.List;
 
import implementacion.TurnoMedico;
 
public interface EstrategiaFiltrado 
{
	ArrayList<TurnoMedico> filtrarBusqueda(ArrayList<TurnoMedico> turnosMedicos, String filtrado);
}