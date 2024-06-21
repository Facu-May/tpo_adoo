package implementacion;

import java.util.ArrayList;
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
    }
}
