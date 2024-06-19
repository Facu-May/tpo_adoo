package implementacion;

import implementacion.ConcreteTurnoBuilder;
import interfaz.Subject;

import java.util.ArrayList;

import interfaz.Observer;

public class ConcreteSubject implements Subject {

	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void registerObserver(Observer observer) {
        observers.add(observer);
    }
	
	public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
	public void notifyObservers(int opcion, int id) {
        for (Observer observer : observers) {
            observer.update();
        }
        if (opcion == 1) {
        	
        }else if(opcion == 2){
        	
        }else if(opcion == 3){
        	
        }else if(opcion == 4){
        	
        }else {
        	
        }
    }
	
	private Observer obtenerObserver(int id) {
		for (Observer observer : observers) {
			
        }
	}
	
	public void programar(int id, Observer person) {
		
	};

	public void cancelar(int id, Observer observer) {
		
	};

	public void realizar(int id, Observer observer) {
		
	};

	public void pendientePago(int id, Observer observer) {
		
	};

	public void notificarCambios(int id, Observer observer) {
		
	};
}
