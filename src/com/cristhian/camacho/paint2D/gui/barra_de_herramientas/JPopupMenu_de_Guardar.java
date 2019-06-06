package com.cristhian.camacho.paint2D.gui.barra_de_herramientas;

import com.cristhian.camacho.paint2D.gui.JFrame_Principal;
import com.cristhian.camacho.paint2D.io.Guardar;
import com.cristhian.camacho.paint2D.io.Guardar_como_JPG;
import com.cristhian.camacho.paint2D.props.Props;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JPopupMenu_de_Guardar extends JPopupMenu 
    implements ActionListener, Props
{
	//String GUARDAR="guardar";    
    
    //String GUARDAR_CHAT="guardar chat";    
    //String GUARDAR_GRAFICO="guardar grafico";
    
    public static JPopupMenu_de_Guardar handle;
	
    public JPopupMenu_de_Guardar()
    {
        handle = this;
        JMenu jmenu = null;
                
       jmenu = new JMenu(GUARDAR);
        
        	JMenuItem jmenuitem1 = new JMenuItem(GUARDAR_COMO_JPG);
        	jmenuitem1.addActionListener(this);
                
       jmenu.add(jmenuitem1);
        
        	JMenuItem jmi_guardar_como_txt = new JMenuItem(GUARDAR_COMO_TXT);
        	jmi_guardar_como_txt.addActionListener(this);
       
       jmenu.add(jmi_guardar_como_txt);
         
       add(jmenu);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        JMenuItem jmenuitem = (JMenuItem)actionevent.getSource();
        
        String s = actionevent.getActionCommand();
        
        if(s==GUARDAR_COMO_JPG)
        {
        	Guardar_como_JPG guardar = new Guardar_como_JPG();
        }
        
        if(s==GUARDAR_COMO_TXT)
        {
        	Guardar guardar = new Guardar( JFrame_Principal.handle.area_de_dibujo.guardar_Area_de_dibujo() );
        }
        
//        System.out.println("JPopupMenu_de_Guardar:actionPerformed: jmenuitem.getActionCommand()"+jmenuitem.getActionCommand() );
    }
    
}