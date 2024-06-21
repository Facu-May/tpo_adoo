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
	
	public int getIdTurnoMedico() {
		return turnoMedico.getId();
	}


}
    
	
	/*public void programar(int id, Observer person) {
		
	};

	public void cancelar(int id, Observer observer) {
		
	};

	public void realizar(int id, Observer observer) {
		
	};

	public void pendientePago(int id, Observer observer) {
		
	};

	public void notificarCambios(int id, Observer observer) {
		
	};*/
	/*public void notifyObservers(int opcion, int id) {
        for (Observer observer : observers) {
            observer.update();
        }
        if (opcion == 1) {
        	
        }else if(opcion == 2){
        	
        }else if(opcion == 3){
        	
        }else if(opcion == 4){
        	
        }else {
        	
        }
    }*/

