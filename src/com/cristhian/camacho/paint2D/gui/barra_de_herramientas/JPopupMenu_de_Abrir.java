package com.cristhian.camacho.paint2D.gui.barra_de_herramientas;

import com.cristhian.camacho.paint2D.io.Abrir;
import com.cristhian.camacho.paint2D.props.Props;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class JPopupMenu_de_Abrir extends JPopupMenu 
    implements ActionListener, Props
{
	    
    //String ABRIR_CHAT="abrir chat";
    //String ABRIR_GRAFICO="abrir grafico";
    
    public static JPopupMenu_de_Abrir handle;
	
    public JPopupMenu_de_Abrir()
    {
        handle = this;
        JMenuItem jmenuitem = null;
                
        jmenuitem = new JMenuItem(ABRIR);
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
        
        if(s==ABRIR)
        {
        	Abrir abrir = new Abrir();
        }
        
//        System.out.println("JPopupMenu_de_Abrir:actionPerformed: jmenuitem.getActionCommand()"+jmenuitem.getActionCommand() );
    }
    
}