package com.cristhian.camacho.paint2D.props;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;


public class EventoCerrarVentana extends WindowAdapter {

    private EventListenerList listenerList = null;

    String nombre = null;

    public EventoCerrarVentana(String nombre) {
        this.nombre = nombre;
    }

    public void windowClosing(WindowEvent e) {
        firePropertyChangeListenerPropertyChange(this, "close", null, nombre);
        //System.exit(0);//se cuelgan los demas usuarios no se porque
    }

    public synchronized void addPropertyChangeListener(
            PropertyChangeListener listener) {

        if (listenerList == null) {
            listenerList = new EventListenerList();
        }
        listenerList.add(PropertyChangeListener.class, listener);
    }

    public synchronized void removePropertyChangeListener(
            PropertyChangeListener listener) {

        listenerList.remove(PropertyChangeListener.class, listener);
    }

    private void firePropertyChangeListenerPropertyChange(Object param1,
            String param2, Object param3, Object param4) {

        PropertyChangeEvent e = null;
        if (listenerList == null) {
//            System.out.println("la lista esta vacia");
            return;
        }
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == PropertyChangeListener.class) {
                if (e == null)
                    e = new PropertyChangeEvent(param1, param2, param3, param4);
                ((java.beans.PropertyChangeListener) listeners[i + 1])
                        .propertyChange(e);
            }
        }

    }
}