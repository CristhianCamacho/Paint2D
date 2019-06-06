package com.cristhian.camacho.paint2D.gui.barra_de_herramientas;

import com.cristhian.camacho.paint2D.gui.area_de_dibujo.Area_de_dibujo;
import com.cristhian.camacho.paint2D.props.Props;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPopupMenu_de_Nuevo extends JPopupMenu 
    implements ActionListener, Props
{	      
    public static JPopupMenu_de_Nuevo handle;
	
    public JPopupMenu_de_Nuevo()
    {
        handle = this;
        JMenuItem jmenuitem = null;
                
        jmenuitem = new JMenuItem(NUEVO);
        jmenuitem.addActionListener(this);
                
        add(jmenuitem);
        
        //jmenuitem = new JMenuItem(ABRIR_GRAFICO);
        //jmenuitem.addActionListener(this);
         
        //add(jmenuitem);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        JMenuItem jmenuitem = (JMenuItem)actionevent.getSource();
        String s = actionevent.getActionCommand();
        
        if(s==NUEVO)
        {
        	Area_de_dibujo.handle.lista_Figura.clear();
        	Area_de_dibujo.handle.mSelectedFigura=null;
        	Area_de_dibujo.handle.color_de_fondo=Color.white;
        	Area_de_dibujo.handle.repaint(); 
        }
        
//        System.out.println("JPopupMenu_de_Abrir:actionPerformed: jmenuitem.getActionCommand()"+jmenuitem.getActionCommand() );
    }
    
}