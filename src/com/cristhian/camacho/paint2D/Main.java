package com.cristhian.camacho.paint2D;


import com.cristhian.camacho.paint2D.gui.JFrame_Principal;
import com.cristhian.camacho.paint2D.props.EventoCerrarVentana;

import java.awt.*;

public class Main {

    public static Ventana_de_espera_PaintJ ventana_de_espera_PaintJ;
    public static Dimension screensize;

    public static void main(String[] ar)
    {
        screensize = Toolkit.getDefaultToolkit().getScreenSize();

        ventana_de_espera_PaintJ=new Ventana_de_espera_PaintJ(screensize,new Dimension( 100+(int)(Math.random()*700) ,100+(int)(Math.random()*500) ) );
        final JFrame_Principal jfp=new JFrame_Principal("CRIS");
        ventana_de_espera_PaintJ.setVisible(false);

        jfp.addWindowListener(new EventoCerrarVentana("CRIS"));

        jfp.setBounds(10, 10,  800, 450);
        jfp.setVisible(true);
    }

}