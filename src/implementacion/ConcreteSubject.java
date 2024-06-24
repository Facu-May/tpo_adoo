package implementacion;

import implementacion.ConcreteTurnoBuilder;
import interfaz.Subject;

import java.util.ArrayList;

import interfaz.Observer;

public class ConcreteSubject implements Subject {

	private ArrayList<Observer> observers = new ArrayList<>();
	private String estado = null;
	
	public ConcreteSubject() {
		
	}
	
	
	public void registerObserver(Observer observer) {
        observers.add(observer);
    }
	
	public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
	
	public void setEstado(String estado, Observer observer) {
		this.estado = estado;
		notifyObservers(estado, observer);
	}
	
	public void notifyObservers(String estado, Observer obsever) {
		for(Observer observador : observers) {
			if(observador.equals(obsever)) {
				observador.update(estado);
			}
		}
	}

}