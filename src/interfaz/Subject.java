package interfaz;

public interface Subject {

	void registerObserver(Observer observer);
	
	void removeObserver(Observer observer);
	
	public void notifyObservers(int opcion, int id);
	
	void programar(int id, Observer observer);

	void cancelar(int id, Observer observer);

	void realizar(int id, Observer observer);

	void pendientePago(int id, Observer observer);

	void notificarCambios(int id, Observer observer);
}
