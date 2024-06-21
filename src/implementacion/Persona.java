package implementacion;

import java.util.ArrayList;


public abstract class Persona {
    String nombre;
    String apellido;
    int edad;
    ArrayList<TurnoMedico> listaTurnos = new ArrayList<TurnoMedico>();



    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}