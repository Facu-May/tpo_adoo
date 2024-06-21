package interfaz;

import implementacion.*;

public interface FacturaBuilder 
{

	String ObtenerDetalleFactura();
    Paciente obtenerPaciente(int dni);

    TurnoMedico obtenerTurnoMedico(Paciente paciente);
    int obtenerTotal(int descuento);

    int obtenerDescuento(Paciente paciente);

    Factura obtenerFactura();

    Factura build(Paciente paciente, TurnoMedico turno, int descuento, double total);
}
