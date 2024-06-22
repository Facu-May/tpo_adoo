package implementacion;

public class Traumatologia extends Medico {

	private int precio;
	public Traumatologia(String nombre, String apellido, int nroMatricula) {
		super(nombre,apellido,nroMatricula);
		this.precio = 2000;
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
		return "Traumatologia";
	}

}
