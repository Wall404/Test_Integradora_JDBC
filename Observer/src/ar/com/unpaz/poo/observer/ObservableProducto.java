package ar.com.unpaz.poo.observer;

import java.util.Observable;

public class ObservableProducto extends Observable {
	   public synchronized void setChanged() {
           super.setChanged();
       }
}
