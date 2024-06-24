package implementacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaz.EstrategiaFiltrado;
import interfaz.PagoExterno;
import interfaz.TurnoMedicoBuilder;

public class SistemaClinica implements PagoExterno
{
    ArrayList<Paciente> pacientes;
    ArrayList<Medico> medicos;
    ArrayList<TurnoMedico> turnos;
    //implementación singleton
    private static SistemaClinica instance;
    private TurnoMedicoBuilder turnoMedicoBuilder;
    private EstrategiaFiltrado estrategiaFiltrado;
	

    public SistemaClinica() {
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
    
    
    public void agregarMedico(Medico medico)
    {
        medicos.add(medico);
        System.out.println("se agrego el medico: " + medico.getNroMatricula());
    }

    public TurnoMedico crearTurnoMedico(int dniPaciente, int matriculaMedico, String motivo, int complejidad, String estado, double costo, String fch, String tratamiento)
    {
        Paciente paciente = getPaciente(dniPaciente);
        Medico medico = getMedico(matriculaMedico);
        /*SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato
        try 
        {
            Date fecha = formato.parse(fch);*/
            TurnoMedico turno = turnoMedicoBuilder.build(paciente, medico, costo, complejidad, fch, estado, motivo, tratamiento);
            /* Faltaría la parte dentro de ConcreteTurnoBuilder de crear la factura */
            turnos.add(turno);
            System.out.println("se creo el turno: " + turno.getId());
            return turno;
        /*} catch (ParseException e) {
            System.err.println("Error al analizar la fecha: " + e.getMessage());
            return null;
        }*/
    }
    public TurnoMedico getTurnoMedico(int id) {
    	for(TurnoMedico turno : turnos) {
    		if(turno.getId() == id) {
    			return turno;
    		}
    	}
    	return null;
    }
    
    public ArrayList<TurnoMedico> getTurnosMedicos(){
    	return this.turnos;
    }
    
    public ArrayList<Paciente> getPacientes(){
    	return this.pacientes;
    }

    public Medico getMedico(int matriculaMedico) 
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

    Paciente getPaciente(int dni)
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
        /*SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato
        try {
            Date fecha = formato.parse(fchNac);*/
            Paciente paciente = new Paciente(nombre, apellido, fchNac,telefono,direccion, obraSocial, jubilado, dni);
            pacientes.add(paciente);
            System.out.println("Se ingreso el paciente" + paciente.getDni());
        /*} catch (ParseException e) {
            System.err.println("Error al analizar la fecha: " + e.getMessage());
            return;
        }*/
    }

	@Override
	public String pagoRealizado() {
		return "Pago Realizado Con Exito";
		
	}

	@Override
	public String pagoRechazado() {
		return "Pago Rechazado";
		
	}

	@Override
	public String pagoEspera() {
		return "Pago en espera";
	}
	

    public EstrategiaFiltrado getEstrategiaFiltrado() {
        return this.estrategiaFiltrado;
    }
    
    public void setEstrategiaFiltrado(EstrategiaFiltrado estrategiaFiltrado) {
    	this.estrategiaFiltrado = estrategiaFiltrado;
    }
    
    public ArrayList<TurnoMedico> filtrarBusqueda(ArrayList<TurnoMedico> turnos, String dato){
    	return estrategiaFiltrado.filtrarBusqueda(turnos, dato);
    }


}
