package implementacion;

public class Odontologia extends Medico 
{
	private int precio;

	public Odontologia(String nombre, String apellido, String edad, int nroMatricula) 
	{
		super(nombre,apellido,nroMatricula);
		this.precio = 1000;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

	@Override
	public String getEspecialidad() 
	{
		// TODO Auto-generated method stub
		return "Odontologia";
	}
	
	
	
}
