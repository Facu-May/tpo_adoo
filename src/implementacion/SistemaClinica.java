package implementacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaz.EstrategiaFiltrado;
import interfaz.FacturaBuilder;
import interfaz.TurnoMedicoBuilder;

public class SistemaClinica 
{
    List<Paciente> pacientes;
    List<Medico> medicos;
    List<TurnoMedico> turnos;
    //implementación singleton
    private static SistemaClinica instance;
    private TurnoMedicoBuilder turnoMedicoBuilder;
    private EstrategiaFiltrado estrategiaFiltrado;

    private SistemaClinica() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        turnos = new ArrayList<>();
        this.turnoMedicoBuilder = new ConcreteTurnoBuilder();
    }

    public static SistemaClinica getInstance() {
        if (instance == null) {
            instance = new SistemaClinica();
        }
        return instance;
    }

    public void crearTurnoMedico(int dniPaciente, int matriculaMedico, String motivo, int complejidad, String estado, double costo, String fch, String tratamiento)
    {
        Paciente paciente = getPaciente(dniPaciente);
        Medico medico = getMedico(matriculaMedico);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato
        try 
        {
            Date fecha = formato.parse(fch);
            TurnoMedico turno = turnoMedicoBuilder.build(paciente, medico, costo, complejidad, fecha, estado, motivo, tratamiento);
            /* Faltaría la parte dentro de ConcreteTurnoBuilder de crear la factura */
            turnos.add(turno);
        } catch (ParseException e) {
            System.err.println("Error al analizar la fecha: " + e.getMessage());
            return;
        }
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


   

    public void crearPaciente(String fchNac,int dni, String nombre, String apellido, String direccion, String obraSocial, boolean jubilado, int telefono)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato
        try {
            Date fecha = formato.parse(fchNac);
            Paciente paciente = new Paciente(nombre,apellido,fecha, telefono, direccion, obraSocial, jubilado, dni);
            pacientes.add(paciente);
        } catch (ParseException e) {
            System.err.println("Error al analizar la fecha: " + e.getMessage());
            return;
        }
    }

    public EstrategiaFiltrado getEstrategiaFiltrado() {
        return estrategiaFiltrado;
    }


}
