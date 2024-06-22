package interfaz;
 
import java.util.List;
 
import implementacion.TurnoMedico;
 
public interface EstrategiaFiltrado 
{
	List<TurnoMedico> filtrarBusqueda(TurnoMedico turno);
}