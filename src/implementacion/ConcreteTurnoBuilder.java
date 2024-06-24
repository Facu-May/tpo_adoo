package implementacion;

import java.util.*;

import interfaz.FacturaBuilder;
import interfaz.TurnoMedicoBuilder;

public class ConcreteTurnoBuilder implements TurnoMedicoBuilder {

	private TurnoMedico turnomedico; // <---- acá es null
	
    private FacturaBuilder facturaBuilder = new ConcreteFacturaBuilder();
	
	public Paciente buscarCliente(int id) 
	{
		if (turnomedico.getId() == id) {
			return turnomedico.getCliente();
		}
		
		return null;
	};
	
	public double obtenerCostoTotal(int id, int descuento) {
			if (turnomedico.getId() == id) {
				return (turnomedico.getCostoTotal() - descuento);
			}
		
		return -1;
	};
	
	public int obtenerComplejidad(int id) {
			if (turnomedico.getId() == id) {
				return turnomedico.getComplejidad();
		}
		return -1;
	};
	
	public String obtenerFecha(int id) {
			if(turnomedico.getId() == id) {
				return turnomedico.getFechaHora();
			}
		
		return null;
	};
	
	public String obtenerEstado(int id) {
			if (turnomedico.getId() == id) {
				return turnomedico.getEstado();
			}
		
		return null;
	};
	
	public String obtenerMotivo(int id) {
			if(turnomedico.getId() == id) {
				return turnomedico.getMotivoConsulta();
			}
		
		return null;
	};
	
	public Medico obtenerMedicoAsignado(int id, int matricula) {
			if(turnomedico.getMedicoAsignado().getNroMatricula() == matricula) {
				return turnomedico.getMedicoAsignado();
			}
		
		return null;
	}

	@Override
	public TurnoMedico build(Paciente paciente, Medico medico, double costo, int complejidad, String fecha,
			String estado, String motivo, String tratamiento) {
		// TODO Auto-generated method stub
		ArrayList<TurnoMedico> turnosPaciente = paciente.getTurnosMedico();
		
		for(TurnoMedico turnoPaciente: turnosPaciente){
            if (turnoPaciente.getFechaHora() != fecha){
               paciente.setListaTurno(turnoPaciente);
            } else{
                System.out.println("No se puede solicitar, se superpone con uno existente");
            }
        }
		this.turnomedico = new TurnoMedico(paciente, medico, costo, complejidad, fecha, estado, motivo, tratamiento); // <---- acá se crea el objeto
		int precio = medico.getPrecio();
		int descuento = paciente.getDescuento();
		buildFactura(paciente, turnomedico, precio, descuento);
		return this.turnomedico; // <---- acá se retorna el objeto
	}

	@Override
	public void buildFactura(Paciente paciente, TurnoMedico turno, int total, int descuento) {
		// TODO Auto-generated method stub
		Factura factura = facturaBuilder.build(paciente, turno, total, descuento);
		turnomedico.setFactura(factura);
	};


}
