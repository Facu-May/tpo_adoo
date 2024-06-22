package implementacion;

public class Pediatria extends Medico 
{
	private int precio;
	public Pediatria(String nombre, String apellido, String edad, int nroMatricula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nroMatricula = nroMatricula;
		this.precio = 1500;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPrecio'");
	}

}
