package com.cristhian.camacho.paint2D.gui.barra_de_menus;

import com.cristhian.camacho.paint2D.gui.JFrame_Principal;
import com.cristhian.camacho.paint2D.props.Props;
import com.cristhian.camacho.paint2D.io.Abrir;
import com.cristhian.camacho.paint2D.io.Guardar;
import com.cristhian.camacho.paint2D.io.Guardar_como_JPG;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.Color;


public class JMenuBar_barra extends JMenuBar implements ActionListener, Props
{
	JMenuBar_barra handle;
	
	public JMenuBar_barra()
	{
		createMenubar();
		
		handle=this;
	}
	
public void createMenubar()
	{
	//JMenuBar jmenubar=new JMenuBar();
        
        JMenu archivo=new JMenu(ARCHIVO);
              archivo.setFont(font_barra_menus);
              archivo.setMnemonic(KeyEvent.VK_A);	
        	
        	JMenuItem jmi_nuevo=new JMenuItem(NUEVO);
        	jmi_nuevo.setFont(font_barra_menus);
        	jmi_nuevo.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_N,ActionEvent.ALT_MASK));
        	jmi_nuevo.setToolTipText("crear un nuevo archivo");
        	jmi_nuevo.addActionListener(this);
        	archivo.add(jmi_nuevo);
        	
        	JMenuItem jmi_abrir=new JMenuItem(ABRIR);
        	//jmi_abrir.setIcon( new javax.swing.ImageIcon(getClass().getResource("images/open.gif")) ); 
		   	jmi_abrir.setFont(font_barra_menus);
		   	jmi_abrir.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_B,ActionEvent.ALT_MASK));
        	jmi_abrir.setToolTipText("Abre un archivo");
        	jmi_abrir.addActionListener(this);
        	archivo.add(jmi_abrir);
        	
        	JMenu jm_guardar=new JMenu(GUARDAR);
        	//jm_guardar.setIcon( new javax.swing.ImageIcon(getClass().getResource("images/save.gif")) ); 
		   	jm_guardar.setFont(font_barra_menus);
		   	jmi_abrir.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_G,ActionEvent.ALT_MASK));
        	jmi_abrir.setToolTipText("guarda un archivo");
        	jm_guardar.addActionListener(this);
        	archivo.add(jm_guardar);
        	
  				JMenuItem jmi_guardar_como_TXT=new JMenuItem(GUARDAR_COMO_TXT);
        		jmi_guardar_como_TXT.setFont(font_barra_menus);
        		jmi_guardar_como_TXT.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_T,ActionEvent.ALT_MASK));
        		jmi_guardar_como_TXT.setToolTipText("guarda como un archivo de .txt");
        		jmi_guardar_como_TXT.addActionListener(this);      	
        		jm_guardar.add(jmi_guardar_como_TXT);
        		
        		JMenuItem jmi_guardar_como_JPG=new JMenuItem(GUARDAR_COMO_JPG);
        		jmi_guardar_como_JPG.setFont(font_barra_menus);
        		jmi_guardar_como_JPG.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_J,ActionEvent.ALT_MASK));
        		jmi_guardar_como_JPG.setToolTipText("guarda como un archivo de .jpg");
        		jmi_guardar_como_JPG.addActionListener(this);
        		jm_guardar.add(jmi_guardar_como_JPG);
        	
        	archivo.addSeparator();
        	        	
        	JMenuItem jmi_salir=new JMenuItem(SALIR);
        	jmi_salir.setFont(font_barra_menus);
        	jmi_salir.setAccelerator (KeyStroke.getKeyStroke (KeyEvent.VK_S,ActionEvent.ALT_MASK));
        	jmi_salir.setToolTipText("Salir del programa");
        	jmi_salir.addActionListener(this);
        	archivo.add(jmi_salir);
        	
        	
       add(archivo);
 		
 		//setJMenuBar(jmenubar);	
 	//add(jmenubar); 		
	}
	
	public void actionPerformed(ActionEvent actionevent)
    {
    	String s = actionevent.getActionCommand();
    	
    	if(s==NUEVO)
    	{
    		JFrame_Principal.handle.area_de_dibujo.lista_Figura.clear();
        	JFrame_Principal.handle.area_de_dibujo.mSelectedFigura=null;
        	JFrame_Principal.handle.area_de_dibujo.color_de_fondo=Color.white;
        	JFrame_Principal.handle.area_de_dibujo.repaint(); 
    	}
    	if(s==ABRIR)
    	{
    		Abrir abrir = new Abrir();
    	}
    	if(s==GUARDAR_COMO_TXT)
    	{
    		Guardar guardar = new Guardar( JFrame_Principal.handle.area_de_dibujo.guardar_Area_de_dibujo() );
    	}
    	if(s==GUARDAR_COMO_JPG)
    	{
    		Guardar_como_JPG guardar = new Guardar_como_JPG();
    	}    	
    	if(s==SALIR)
    	{
    		//JFrame_Principal.handle.ventana.cerrar();
    		JFrame_Principal.handle.setVisible(false);   		
    		System.exit(0);
    	}
    	
	}
}	