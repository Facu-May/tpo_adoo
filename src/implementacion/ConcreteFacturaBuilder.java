package implementacion;

import interfaz.FacturaBuilder;

public class ConcreteFacturaBuilder implements FacturaBuilder 
{
	
	private Factura factura;


    public String ObtenerDetalleFactura(){
    	return factura.toString();
    };
    public Paciente obtenerPaciente(int dni){
        return factura.getPaciente();
    };

    public TurnoMedico obtenerTurnoMedico(Paciente paciente){
        if (factura.getPaciente() == paciente){
            return factura.getTurnoMedico();
        }
        return null;
    };
    public int obtenerTotal(int descuento){
        return factura.getTotal();
    };

    public int obtenerDescuento(Paciente paciente){
        return factura.getDescuento();
    };

    public Factura obtenerFactura(){
        return this.factura;
    }
    @Override
    public Factura build(Paciente paciente, TurnoMedico turno, int total, int descuento) {
        // TODO Auto-generated method stub
        this.factura = new Factura(paciente, turno, total, descuento);
        return this.factura;
    }

}
