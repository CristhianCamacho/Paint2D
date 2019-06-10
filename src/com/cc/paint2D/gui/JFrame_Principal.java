package com.cc.paint2D.gui;

import com.cc.paint2D.gui.area_de_dibujo.Area_de_dibujo;
import com.cc.paint2D.gui.barra_de_herramientas.Barra_de_herramientas;
import com.cc.paint2D.gui.barra_de_menus.JMenuBar_barra;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JFrame_Principal extends javax.swing.JFrame
{
    public static JFrame_Principal handle;

    public static Area_de_dibujo area_de_dibujo;
    public static Barra_de_herramientas barra_de_herramientas;

    public JFrame_Principal(String s)
    {
        super.setTitle(s);
        handle=this;
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al intentar cargar L&F");
        }

        setJMenuBar(new JMenuBar_barra());


        try{
            System.out.println("JFrame_principal System.getProperty(\"user.dir\")="+System.getProperty("user.dir"));
            Image imagen_interna=Toolkit.getDefaultToolkit().getImage(new URL("file:/"+System.getProperty("user.dir")+"/GUI_/barra_de_herramientas/IMAGENES/icono_chat.gif") );

            setIconImage(imagen_interna);

        }catch(Exception e){
            //System.out.println("Error:"+e);´
        }

        setLayout(new java.awt.GridLayout(1,2));

        javax.swing.JPanel jpanel = new javax.swing.JPanel();
        jpanel.setLayout(new java.awt.BorderLayout());

        jpanel.add(barra_de_herramientas = new Barra_de_herramientas(),java.awt.BorderLayout.NORTH);
        jpanel.add(area_de_dibujo = new Area_de_dibujo(),java.awt.BorderLayout.CENTER);

        //javax.swing.JSplitPane jplitpane=new javax.swing.JSplitPane();
        //jplitpane.setLeftComponent(jpanel);
        //getContentPane().add(jplitpane);

        getContentPane().add(jpanel);
    }

}