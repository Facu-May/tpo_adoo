package implementacion;

public class Traumatologia extends Medico {

	private int precio;
	public Traumatologia(String nombre, String apellido, String edad, int nroMatricula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nroMatricula = nroMatricula;
		this.precio = 2000;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

}
