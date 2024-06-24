package interfaz;

public interface Subject {

	void registerObserver(Observer observer);
	
	void removeObserver(Observer observer);
	
	public void notifyObservers(String estado, Observer observer);

}