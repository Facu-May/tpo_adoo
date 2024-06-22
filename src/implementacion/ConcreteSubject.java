package implementacion;

import implementacion.ConcreteTurnoBuilder;
import interfaz.Subject;

import java.util.ArrayList;

import interfaz.Observer;

public class ConcreteSubject implements Subject {

	private ArrayList<Observer> observers = new ArrayList<>();
	private TurnoMedico turnoMedico;
	private String estado;
	
	
	public void registerObserver(Observer observer) {
        observers.add(observer);
    }
	
	public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
	
	public void setEstado(String estado) {
		turnoMedico.setEstado(estado);
		notifyObservers();
	}
	
	public void notifyObservers() {
		for(Observer observador : observers) {
			observador.update();
		}
	}
	
	public int getIdTurnoMedico() 
	{
		return turnoMedico.getId();
	}


}