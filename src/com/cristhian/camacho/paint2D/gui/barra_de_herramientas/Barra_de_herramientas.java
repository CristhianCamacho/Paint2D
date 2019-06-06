package com.cristhian.camacho.paint2D.gui.barra_de_herramientas;

import com.cristhian.camacho.paint2D.gui.area_de_dibujo.Area_de_dibujo;
import com.cristhian.camacho.paint2D.props.Props;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Barra_de_herramientas extends JToolBar implements ActionListener,ChangeListener, Props
{
	JButton jb_nuevo;
	JButton jb_abrir;//String ABRIR="Abr";
	JButton jb_guardar;//String GUARDAR="Guard";
	
	JButton jb_figura;String FIGURA="Figura";
	JButton jb_atributos_figura;String ATRIBUTOS_FIGURA="Atrib_Figura";
		
	public JTextField_estado JTF_estado;
	
	static JPopupMenu menu_actual;
	
	public JCheckBox jchb_antialiasing;
	public JCheckBox jchb_pintar_ejes;
	public JCheckBox jchb_escribir_puntos;
	
	JComboBox jcb_escala;
	
	public static Barra_de_herramientas handle;
	
	public Barra_de_herramientas()
	{
		handle=this;
		
		jb_nuevo=new JButton();jb_nuevo.addActionListener(this);
		jb_nuevo.setActionCommand(NUEVO);
		jb_nuevo.setFont(font_barra_herramientas);
		jb_nuevo.setIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/new.gif")) ); 
				
		jb_abrir=new JButton();jb_abrir.addActionListener(this);
		jb_abrir.setActionCommand(ABRIR);
		jb_abrir.setFont(font_barra_herramientas);
//System.out.println(" System.getProperty(\"user.dir\")="+System.getProperty("user.dir"));
		jb_abrir.setIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/open.gif")) ); 
		
		jb_guardar=new JButton();jb_guardar.addActionListener(this);
		jb_guardar.setActionCommand(GUARDAR);
		jb_guardar.setFont(font_barra_herramientas);
		jb_guardar.setIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/save.gif")) ); 
		
		jb_figura=new JButton(FIGURA);jb_figura.addActionListener(this);
		jb_figura.setFont(font_barra_herramientas);
		//jb_figura.setActionCommand(FIGURA);
		jb_figura.setIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/figura.gif")) ); 
		
		jb_atributos_figura=new JButton(ATRIBUTOS_FIGURA);jb_atributos_figura.addActionListener(this);
		jb_atributos_figura.setFont(font_barra_herramientas);
		//jb_atributos_figura.setActionCommand(ATRIBUTOS_FIGURA);
		jb_atributos_figura.setIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/atributos_figura.gif")) ); 
		
				
		JTF_estado=new JTextField_estado();
		
		javax.swing.JPanel jpanel_todos_botones=new javax.swing.JPanel();
			
			javax.swing.JPanel jpanel_abrir_guardar=new javax.swing.JPanel();
			jpanel_abrir_guardar.add(jb_nuevo);
			jpanel_abrir_guardar.add(jb_abrir);
			jpanel_abrir_guardar.add(jb_guardar);
			jpanel_abrir_guardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jpanel_todos_botones.add(jpanel_abrir_guardar);	
			
			javax.swing.JPanel jpanel_figura=new javax.swing.JPanel();
			jpanel_figura.add(jb_figura);
			jpanel_figura.add(jb_atributos_figura);
			jpanel_figura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jpanel_todos_botones.add(jpanel_figura);
		
				jchb_antialiasing=new JCheckBox("Antialiasing",new javax.swing.ImageIcon(getClass().getResource("IMAGENES/antialiasing_deselected.gif")));
			jchb_antialiasing.setDisabledIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/antialiasing_deselected.gif")));
			jchb_antialiasing.setSelectedIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/antialiasing_selected.gif")));
				jchb_antialiasing.setSelected(true);jchb_antialiasing.addChangeListener(this);
				jchb_pintar_ejes=new JCheckBox("Pintar_ejes",new javax.swing.ImageIcon(getClass().getResource("IMAGENES/pintar_ejes_deselected.gif")));
			jchb_pintar_ejes.setDisabledIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/pintar_ejes_deselected.gif")));
			jchb_pintar_ejes.setSelectedIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/pintar_ejes_selected.gif")));
				jchb_pintar_ejes.setSelected(true);jchb_pintar_ejes.addChangeListener(this);
			String[] opciones=new String[101];
			for(int i=1;i<opciones.length;i++)
			{opciones[i]=""+i;} 
			jcb_escala=new JComboBox(opciones);jcb_escala.setSelectedIndex(40);
			jcb_escala.addActionListener(this);
				jchb_escribir_puntos=new JCheckBox("escribir_puntos",new javax.swing.ImageIcon(getClass().getResource("IMAGENES/escribir_puntos_deselected.gif")));
			jchb_escribir_puntos.setDisabledIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/escribir_puntos_deselected.gif")));
			jchb_escribir_puntos.setSelectedIcon( new javax.swing.ImageIcon(getClass().getResource("IMAGENES/escribir_puntos_selected.gif")));
				jchb_escribir_puntos.setSelected(true);jchb_escribir_puntos.addChangeListener(this);
			
			javax.swing.JPanel jpanel_JCheckBox=new javax.swing.JPanel();
			//jpanel_JCheckBox.add(new JLabel("antialiasing"));
			jpanel_JCheckBox.add(jchb_antialiasing);
			//jpanel_JCheckBox.add(new JLabel("Ejes"));
			jpanel_JCheckBox.add(jchb_pintar_ejes);
		//jpanel_JCheckBox.add(new JLabel("Escala"));
		jpanel_JCheckBox.add(jcb_escala);					
			//jpanel_JCheckBox.add(new JLabel("Puntos"));
			jpanel_JCheckBox.add(jchb_escribir_puntos);
			jpanel_JCheckBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
							
		setLayout(new BorderLayout());
		
		add(jpanel_todos_botones,java.awt.BorderLayout.NORTH);
		add(jpanel_JCheckBox,java.awt.BorderLayout.CENTER);	
		add(JTF_estado,java.awt.BorderLayout.SOUTH);						
	}	
	
	
	public void actionPerformed(ActionEvent actionevent)
    {
        String s = actionevent.getActionCommand();
//System.out.println("Barra_de_herramientas:actionPerformed s = "+s);        
        if(s == "comboBoxChanged")
        {
        	if( actionevent.getSource().equals(jcb_escala) )
        	{
        		Area_de_dibujo.handle.escala=(int)( jcb_escala.getSelectedIndex() );
        		Area_de_dibujo.handle.repaint();
        		//Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Barra_de_herramientas:comboBoxChanged:escala", null, ""+(new Integer(Area_de_dibujo.handle.escala)) );
        	}
        }	
        if(s == NUEVO)
            showPopup(actionevent, JPopupMenu_de_Nuevo.handle != null ? ((JPopupMenu) (JPopupMenu_de_Nuevo.handle)) : ((JPopupMenu) (new JPopupMenu_de_Nuevo())));
        else
        if(s == ABRIR)
            showPopup(actionevent, JPopupMenu_de_Abrir.handle != null ? ((JPopupMenu) (JPopupMenu_de_Abrir.handle)) : ((JPopupMenu) (new JPopupMenu_de_Abrir())));
        else
        if(s == GUARDAR)
            showPopup(actionevent, JPopupMenu_de_Guardar.handle!= null ? ((JPopupMenu) (JPopupMenu_de_Guardar.handle)) : ((JPopupMenu) (new JPopupMenu_de_Guardar())));
        else
        if(s == FIGURA)
            showPopup(actionevent, JPopupMenu_de_Seleccionar_Figura.handle!= null ? ((JPopupMenu) (JPopupMenu_de_Seleccionar_Figura.handle)) : ((JPopupMenu) (new JPopupMenu_de_Seleccionar_Figura())));
        else
        if(s == ATRIBUTOS_FIGURA)
            {
            	showPopup(actionevent, JPopupMenu_de_Estado_Figura.handle!= null ? ((JPopupMenu) (JPopupMenu_de_Estado_Figura.handle)) : ((JPopupMenu) (new JPopupMenu_de_Estado_Figura())));
//System.out.println("Barra_de_herramientas:actionPerformed ATRIBUTOS_FIGURA s = "+s);         		
        	}
                 
    }
	
	public void showPopup(ActionEvent actionevent, JPopupMenu jpopupmenu)
    {
        if(jpopupmenu.isVisible())
            return;
        menu_actual = jpopupmenu;
        Component component = (Component)actionevent.getSource();
        Container container = component.getParent();
        if(container.isAncestorOf(jpopupmenu))
        {
            jpopupmenu.setVisible(true);
        } else
        {
            Point point = component.getLocation();
            Dimension dimension = component.getSize();
            container.add(jpopupmenu);
            jpopupmenu.show(container, point.x, point.y + dimension.height);
        }
    }
    
    public void stateChanged(ChangeEvent ce)
	{
//		System.out.println( "Barra_de_herramientas:stateChanged");
		Area_de_dibujo.handle.repaint();
	}
	/*
	public void set_escala(int s)
	{
System.out.println("**********************************************************");		

System.out.println("Barra_de_herramientas:set_escala s="+s);		
		jcb_escala.setSelectedIndex(s);
		Area_de_dibujo.handle.escala=s;//(int)( jcb_escala.getSelectedIndex() );
        Area_de_dibujo.handle.repaint();
	}*/
}