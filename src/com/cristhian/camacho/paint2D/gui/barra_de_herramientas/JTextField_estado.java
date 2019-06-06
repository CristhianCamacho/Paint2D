package com.cristhian.camacho.paint2D.gui.barra_de_herramientas;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class JTextField_estado extends javax.swing.JPanel
{
	public static JTextField_estado handle;
	
	public JTextField figura_actual;
	public JTextField estado_actual;
	
	
	
	public JTextField_estado()
	{
		handle=this;
		//setColumns(10);
		//setLayout(new BorderLayout());
		setLayout(new java.awt.GridLayout(1,2));
		
		figura_actual=new JTextField();
		estado_actual=new JTextField();
		
		figura_actual.setFont( new java.awt.Font( "Arial",java.awt.Font.BOLD, 12) );
		figura_actual.setForeground( java.awt.Color.red );
		figura_actual.setBackground( java.awt.Color.white );
		
		estado_actual.setFont( new java.awt.Font( "Tahoma",java.awt.Font.BOLD, 12) );
		estado_actual.setForeground( java.awt.Color.blue );
		estado_actual.setBackground( java.awt.Color.white );
				
		setBorder( new javax.swing.border.EtchedBorder(10) );	
		
		add(figura_actual);//,BorderLayout.WEST);
		add(estado_actual);//,BorderLayout.EAST);
	
	}	
	
	
}