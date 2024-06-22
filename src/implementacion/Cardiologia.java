package implementacion;

public class Cardiologia extends Medico 
{
	private int precio;

	public Cardiologia(String nombre, String apellido, String edad, int nroMatricula) {
		super(nombre,apellido,nroMatricula);
		this.precio = 1600;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

	@Override
	public String getEspecialidad() {
		// TODO Auto-generated method stub
		return "Cardiologia";
	}

}
