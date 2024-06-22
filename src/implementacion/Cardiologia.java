package implementacion;

public class Cardiologia extends Medico 
{
	private int precio;

	public Cardiologia(String nombre, String apellido, String edad, int nroMatricula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nroMatricula = nroMatricula;
		this.precio = 1600;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

}
