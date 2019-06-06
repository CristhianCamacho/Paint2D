package com.cristhian.camacho.paint2D;


import com.cristhian.camacho.paint2D.gui.JFrame_Principal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {

    public static Ventana_de_espera_PaintJ ventana_de_espera_PaintJ;
    public static Dimension screensize;

    public static void main(String[] ar)
    {
        screensize = Toolkit.getDefaultToolkit().getScreenSize();

        ventana_de_espera_PaintJ=new Ventana_de_espera_PaintJ(screensize,new Dimension( 100+(int)(Math.random()*700) ,100+(int)(Math.random()*500) ) );
        final JFrame_Principal jfp=new JFrame_Principal("CRIS");
        ventana_de_espera_PaintJ.setVisible(false);

        jfp.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                //jfp.ventana.cerrar();
            }
        });

        jfp.setBounds(10, 10, 800, 450);
        jfp.setVisible(true);
    }

}