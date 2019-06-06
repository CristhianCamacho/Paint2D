package com.cristhian.camacho.paint2D.gui.barra_de_herramientas;

import com.cristhian.camacho.paint2D.gui.JFrame_Principal;
import com.cristhian.camacho.paint2D.gui.area_de_dibujo.Area_de_dibujo;
import com.cristhian.camacho.paint2D.props.Props;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPopupMenu_de_Estado_Figura extends JPopupMenu
    implements ActionListener, Props
{
	String COLOR="color";
					
	String ESTADO="estado";         
    
            
    public static JPopupMenu_de_Estado_Figura handle;
	
    public JPopupMenu_de_Estado_Figura()
    {
        handle = this;
        JMenu jmenu1= null;
                
       jmenu1 = new JMenu(COLOR);
        
        	JMenuItem jmenuitem0 = new JMenuItem(COLOR_DE_FONDO);
        	jmenuitem0.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/color_de_fondo.gif"))  );
        	jmenuitem0.addActionListener(this);
                
       jmenu1.add(jmenuitem0);
        	
        	JMenuItem jmenuitem1 = new JMenuItem(COLOR_DE_RELLENO);
        	jmenuitem1.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/color_de_relleno.gif"))  );
        	jmenuitem1.addActionListener(this);
                
       jmenu1.add(jmenuitem1);
        
        	JMenuItem jmenuitem2 = new JMenuItem(COLOR_DE_PUNTO_NORMAL);
        	jmenuitem2.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/color_de_punto_normal.gif"))  );
        	jmenuitem2.addActionListener(this);
       
       jmenu1.add(jmenuitem2);
       
       		JMenuItem jmenuitem21 = new JMenuItem(COLOR_DE_PUNTO_SELECCIONADO);
       		jmenuitem21.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/color_de_punto_seleccionado.gif"))  );
        	jmenuitem21.addActionListener(this);
       
       jmenu1.add(jmenuitem21);
       add(jmenu1);
       		
       		JMenuItem jmenuitem22 = new JMenuItem(TRANSPARENCIA);
       		//jmenuitem22.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/transparencia.gif"))  );
        	jmenuitem22.addActionListener(this);
       
       jmenu1.add(jmenuitem22);
       add(jmenu1);
       
       JMenu jmenu2= null;
       jmenu2 = new JMenu(ESTADO);
       		
       		JMenuItem jmenuitem4 = new JMenuItem(COLOCAR_PUNTO);
       		jmenuitem4.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/colocar_punto.gif"))  );
        	jmenuitem4.addActionListener(this);
       jmenu2.add(jmenuitem4);
       
       		JMenuItem jmenuitem5 = new JMenuItem(MOVER_PUNTO);
        	jmenuitem5.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/mover_punto.gif"))  );
        	jmenuitem5.addActionListener(this);
       jmenu2.add(jmenuitem5);              

       		JMenuItem jmenuitem6 = new JMenuItem(BORRAR_PUNTO);
        	jmenuitem6.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/borrar_punto.gif"))  );
        	jmenuitem6.addActionListener(this);
       jmenu2.add(jmenuitem6);
       
       jmenu2.addSeparator();
       		
       		JMenuItem jmenuitem7 = new JMenuItem(BORRAR_FIGURA);
        	jmenuitem7.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/borrar_figura.gif"))  );
        	jmenuitem7.addActionListener(this);
       jmenu2.add(jmenuitem7);
       
       JMenuItem jmenuitem8 = new JMenuItem(MOVER_FIGURA);
        	jmenuitem8.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/mover_figura.gif"))  );
        	jmenuitem8.addActionListener(this);
       jmenu2.add(jmenuitem8);
                    
       add(jmenu2);
              
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        JMenuItem jmenuitem = (JMenuItem)actionevent.getSource();
		String s = actionevent.getActionCommand();
        
		
//System.out.println("JPopupMenu_de_Estado_Figura:actionPerformed s = "+s);
                
        if(s == COLOCAR_PUNTO)
        {
        	Area_de_dibujo.handle.mSelectedFigura.set_estado_PUNTOS(COLOCAR_PUNTO);
        	Area_de_dibujo.handle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        	JTextField_estado.handle.estado_actual.setText("Estado: "+COLOCAR_PUNTO);
        	
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_estado_PUNTOS", null, COLOCAR_PUNTO);
        }
        
        if(s == MOVER_PUNTO)
        {
        	Area_de_dibujo.handle.mSelectedFigura.set_estado_PUNTOS(MOVER_PUNTO);
        	Area_de_dibujo.handle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	JTextField_estado.handle.estado_actual.setText("Estado: "+MOVER_PUNTO);
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_estado_PUNTOS", null, MOVER_PUNTO);
        }
        
        if(s == BORRAR_PUNTO)
        {
        	Area_de_dibujo.handle.mSelectedFigura.set_estado_PUNTOS(BORRAR_PUNTO);
        	Area_de_dibujo.handle.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        	JTextField_estado.handle.estado_actual.setText("Estado: "+BORRAR_PUNTO);
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_estado_PUNTOS", null, BORRAR_PUNTO);
        }
        
        if(s == BORRAR_FIGURA)
        {
        	Area_de_dibujo.handle.mSelectedFigura.set_estado_PUNTOS(BORRAR_FIGURA);
        	JTextField_estado.handle.estado_actual.setText("Estado: "+BORRAR_FIGURA);
        	
        	Area_de_dibujo.handle.lista_Figura.remove( Area_de_dibujo.handle.mSelectedFigura );
        	        	
        	if(Area_de_dibujo.handle.lista_Figura.size()!=0)
        		{
        			Area_de_dibujo.handle.mSelectedFigura=Area_de_dibujo.handle.lista_Figura.getLast();
        	    	Area_de_dibujo.handle.lista_Figura.remove( Area_de_dibujo.handle.lista_Figura.getLast() );
        	    	
        	    	JTextField_estado.handle.estado_actual.setText("Estado: "+Area_de_dibujo.handle.mSelectedFigura.ESTADO);        	    	
        	    }
        	 else
        	 	if(Area_de_dibujo.handle.lista_Figura.size()==0)
        	 	{
        	 		Area_de_dibujo.handle.mSelectedFigura=null;
        	 		JTextField_estado.handle.estado_actual.setText("Estado: NINGUNA figura");
        	 	}       	
        	Area_de_dibujo.handle.repaint();
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_estado_PUNTOS", null, BORRAR_FIGURA);
        }
        
        if(s == MOVER_FIGURA)
        {
        	Area_de_dibujo.handle.mSelectedFigura.set_estado_PUNTOS(MOVER_FIGURA);
        	Area_de_dibujo.handle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        	JTextField_estado.handle.estado_actual.setText("Estado: "+MOVER_FIGURA);
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_estado_PUNTOS", null, MOVER_FIGURA);        
        }
        
        if(s== COLOR_DE_FONDO)
        {
        	Color color=JColorChooser.showDialog(JFrame_Principal.handle, "Color del FONDO", Area_de_dibujo.handle.color_de_fondo);
        	cambiar_color_FONDO(""+color.hashCode());
        	//Area_de_dibujo.handle.color_de_fondo=color;
        	//Area_de_dibujo.handle.repaint();
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_color_FONDO", null, color.hashCode() );
        }
        
        if(s == COLOR_DE_RELLENO)
        {
        	Color color=JColorChooser.showDialog(JFrame_Principal.handle, "Color de la RELLENO", Area_de_dibujo.handle.mSelectedFigura.color_lineas);
        	Area_de_dibujo.handle.mSelectedFigura.color_lineas=color;
        	Area_de_dibujo.handle.repaint();
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_color_RELLENO", null, color.hashCode() );
        }
        
        if(s == COLOR_DE_PUNTO_NORMAL)
        {
        	Color color=JColorChooser.showDialog(JFrame_Principal.handle, "Color de los PUNTOS NORMAL", Area_de_dibujo.handle.mSelectedFigura.color_punto_normal);
        	Area_de_dibujo.handle.mSelectedFigura.color_punto_normal=color;
        	Area_de_dibujo.handle.repaint();
        	
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_color_NORMAL", null, color.hashCode());
        }
        
        if(s == COLOR_DE_PUNTO_SELECCIONADO)
        {
        	Color color=JColorChooser.showDialog(JFrame_Principal.handle, "Color de los PUNTOS SELECCIONADO", Area_de_dibujo.handle.mSelectedFigura.color_punto_seleccionado);
        	Area_de_dibujo.handle.mSelectedFigura.color_punto_seleccionado=color;
        	Area_de_dibujo.handle.repaint();
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_color_SELECCIONADO", null, color.hashCode());
        }
        if(s == TRANSPARENCIA)
        {    
             ///////////////////////////////////////////////////////////////////
             		//para un 
        		 Object[]      message = new Object[4]; 
                 message[0] = "escoja la TRANSPARENCIA"; 
                 message[1] = ":(0) TRANSPARENTE:       :(1) OPACO:"; 
                 
                 String[] combo_opciones=new String[11];                    
                 for(int i=0;i<=10;i++)
                 {
                 	float f=(float)( i / 10f );
//System.out.println("double: "+f);                 	
                 	combo_opciones[i]=""+f;                 	
              	 }
                 JComboBox cb = new JComboBox(combo_opciones);
                 //cb.addItem(); 
                 //cb.addItem();
                  
                 message[2] = cb; 
  
                 //message[3] = "mensaje_3"; 
   		
                 String[] options = { 
 		  	     "ACEPTAR", 
 		    	 //"OptionPaneDemo.component_op2", 
 		     	 //"OptionPaneDemo.component_op3", 
 		         "NO ACEPTAR", 
 		         "CANCELAR" }; 
 		 
            int result = JOptionPane.showOptionDialog( 
 		    										new JPanel(),                             // the parent that the dialog blocks 
 		    										message,                                    // the dialog message array 
 		    										"Escoja la transparencia", // the title of the dialog window 
 		    										JOptionPane.DEFAULT_OPTION,                 // option type 
 		    										JOptionPane.INFORMATION_MESSAGE,            // message type 
 		    										null,                                       // optional icon, use null to use the default icon 
 		    										options,                                    // options string array, will be made into buttons 
 		    										options[0]                                  // option that should be made into a default button 
 													);
 			float transparencia=5f;
 													 
 				switch(result) { 
 		   			case 0: // yes 
 		     			//JOptionPane.showMessageDialog(new JPanel(), "ACEPTO"); 
 		     			transparencia=(float)( cb.getSelectedIndex() / 10f );
 		     			
 		     			cambiar_TRANSPARENCIA(""+transparencia);
 		     			/*if(JFrame_Principal.handle.area_de_dibujo.mSelectedFigura!=null)
 		     			{
 		     				JFrame_Principal.handle.area_de_dibujo.mSelectedFigura.transparencia=transparencia;
 		     			}
 		     			else
 		     			{
 		     				JFrame_Principal.handle.area_de_dibujo.transparencia_de_figura_actual=transparencia;
 		     			}
 		     			
 		     			JFrame_Principal.handle.area_de_dibujo.repaint();
 		     			*/
 		     		break; 
 		   		case 1: // no 
 		     			//JOptionPane.showMessageDialog(new JPanel(), "NO ACEPTO"); 
 		     		break; 
 		   		case 2: // maybe 
 		     			//JOptionPane.showMessageDialog(new JPanel(), "CANCELO"); 
 		     			break; 
 		   		default: 
 		     			break; 
 								}; 
        	        	
        	//System.out.println("transparencia = "+transparencia);
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "JPopupMenu_de_Estado_Figura:set_TRANSPARENCIA", null, transparencia);	
        }	
        //System.out.println("actionPerformed: jmenuitem.getActionCommand()"+jmenuitem.getActionCommand() );
    }
    
    public void cambiar_Estado(String s)
    {
System.out.println("JPopupMenu_de_Estado_Figura:cambiar_Estado s = "+s); 		
 		
 		if( s.equalsIgnoreCase(BORRAR_FIGURA) )
 		{
 		//Area_de_dibujo.handle.lista_Figura.remove( Area_de_dibujo.handle.mSelectedFigura );
       
        	 if(Area_de_dibujo.handle.lista_Figura.size()!=0)
        		{
        			Area_de_dibujo.handle.mSelectedFigura=Area_de_dibujo.handle.lista_Figura.getLast();
        	    	Area_de_dibujo.handle.lista_Figura.remove( Area_de_dibujo.handle.lista_Figura.getLast() );
        	    	
        	    	JTextField_estado.handle.estado_actual.setText("Estado: "+Area_de_dibujo.handle.mSelectedFigura.ESTADO);        	    	
        	    }
        	 else
        	    if(Area_de_dibujo.handle.lista_Figura.size()==0)
        	 	{
        	 		Area_de_dibujo.handle.mSelectedFigura=null;
        	 		JTextField_estado.handle.estado_actual.setText("Estado: NINGUNA figura");
        	 	} 
        
        };
        
 		{
 		Area_de_dibujo.handle.mSelectedFigura.set_estado_PUNTOS(s);
        JTextField_estado.handle.estado_actual.setText("Estado: "+s);        	
    	}
    	
    	if( s.equalsIgnoreCase(COLOCAR_PUNTO) )
    	Area_de_dibujo.handle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    	if( s.equalsIgnoreCase(MOVER_PUNTO) )
    	Area_de_dibujo.handle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	if( s.equalsIgnoreCase(BORRAR_PUNTO) )
    	Area_de_dibujo.handle.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    	
    	
    	
    	Area_de_dibujo.handle.repaint();
	}
	
	public void cambiar_TRANSPARENCIA(String s)
    {
		float transparencia=Float.parseFloat(s);
		
System.out.println("JPopupMenu_de_Estado_Figura:cambiar_TRANSPARENCIA transparencia = "+transparencia ); 		
		
		if(JFrame_Principal.handle.area_de_dibujo.mSelectedFigura!=null)
 		{
 			JFrame_Principal.handle.area_de_dibujo.mSelectedFigura.transparencia=transparencia;
 		}
 		else
 		{
 			JFrame_Principal.handle.area_de_dibujo.transparencia_de_figura_actual=transparencia;
 		}
 		     			
        Area_de_dibujo.handle.repaint();               	
	}
	public void cambiar_color_FONDO(String s)
    {
		Color color=new Color(Integer.parseInt(s));
		
System.out.println("JPopupMenu_de_Estado_Figura:cambiar_color_FONDO color = "+color.toString() ); 		
		
		Area_de_dibujo.handle.color_de_fondo=color;
        Area_de_dibujo.handle.repaint();               	
	}
	
	public void cambiar_color_RELLENO(String s)
    {
		Color color=new Color(Integer.parseInt(s));
		
System.out.println("JPopupMenu_de_Estado_Figura:cambiar_color_RELLENO color = "+color.toString() ); 		
		
		Area_de_dibujo.handle.mSelectedFigura.color_lineas=color;
        Area_de_dibujo.handle.repaint();               	
	}
	
	public void cambiar_color_NORMAL(String s)
    {
		Color color=new Color(Integer.parseInt(s));
		
System.out.println("JPopupMenu_de_Estado_Figura:cambiar_color_NORMAL color = "+color.toString() ); 		
		
		Area_de_dibujo.handle.mSelectedFigura.color_punto_normal=color;
        Area_de_dibujo.handle.repaint();               	
	}
	
	public void cambiar_color_SELECCIONADO(String s)
    {
		Color color=new Color(Integer.parseInt(s));
		
System.out.println("JPopupMenu_de_Estado_Figura:cambiar_color_SELECCIONADO color = "+color.toString() ); 		
		
		Area_de_dibujo.handle.mSelectedFigura.color_punto_seleccionado=color;
        Area_de_dibujo.handle.repaint();               	
	}
}