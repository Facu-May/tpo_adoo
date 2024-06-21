package implementacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaz.FacturaBuilder;
import interfaz.TurnoMedicoBuilder;

public class SistemaClinica 
{
    List<Paciente> pacientes;
    List<Medico> medicos;
    List<TurnoMedico> turnos;
    //implementación singleton
    private static SistemaClinica instance;
    private FacturaBuilder facturaBuilder;
    private TurnoMedicoBuilder turnoMedicoBuilder;

    private SistemaClinica() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        turnos = new ArrayList<>();
        this.facturaBuilder = new ConcreteFacturaBuilder();
        this.turnoMedicoBuilder = new ConcreteTurnoBuilder();
    }

    public static SistemaClinica getInstance() {
        if (instance == null) {
            instance = new SistemaClinica();
        }
        return instance;
    }

    public void crearTurnoMedico(int dniPaciente, int matriculaMedico, String motivo, int complejidad, String estado, double costo, String fecha)
    {
        Paciente paciente = getPaciente(dniPaciente);
        Medico medico = getMedico(matriculaMedico);
        // falta la parte de TurnoMedico 
    }

    private Medico getMedico(int matriculaMedico) 
    {
        // TODO Auto-generated method stub
        for(Medico medico: medicos)
        {
            if(medico.soyElMedico(matriculaMedico))
            {
                return medico;
            }
        }
        return null;
    }

    private Paciente getPaciente(int dni)
    {
        for (Paciente paciente : pacientes)
        {
            if (paciente.soyElPaciente(dni))
            {
                return paciente;
            }
        }
        return null;
    }


    // falta lo de TurnoMedico
    public void crearFactura(TurnoMedico turno, int dniPaciente, int descuento, double costoTotal)
    {
        Paciente paciente = getPaciente(dniPaciente);
        facturaBuilder.build(paciente, turno, descuento, costoTotal);
        // falta la parte de agregar la factura al TurnoMedico
    }

    public void crearPaciente(String fchNac,int dni, String nombre, String apellido, String direccion, String obraSocial, boolean jubilado, int telefono)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato
        try {
            Date fecha = formato.parse(fchNac);
            Paciente paciente = new Paciente(fecha, telefono, direccion, obraSocial, jubilado, dni);
            pacientes.add(paciente);
        } catch (ParseException e) {
            System.err.println("Error al analizar la fecha: " + e.getMessage());
            return;
        }
    }

    
}
