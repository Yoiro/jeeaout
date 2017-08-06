package be.helha.groupe5.patterns;

import java.util.ArrayList;
import java.util.List;

public abstract class DBObservable {
	
	protected List<DBObserver> observers = new ArrayList<>();
	
	public void ajouterObserver(DBObserver o) {
		observers.add(o);
	}
	
	public void retirerObserver(DBObserver o) {
		observers.remove(o);
	}
	
	public abstract void notifyObservers();
}
