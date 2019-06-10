package com.cc.paint2D.props;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ManejoUsuario implements PropertyChangeListener {

    public void propertyChange(PropertyChangeEvent pe) {


        String args[] = { "" };

        go(args, pe.getNewValue().toString());
    }

    public void go(String[] ar, String s) {
    	
    	System.out.println("ManejoUsuario:go s="+s);
    }
}