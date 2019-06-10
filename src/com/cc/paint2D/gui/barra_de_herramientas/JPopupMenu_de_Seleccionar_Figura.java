package com.cc.paint2D.gui.barra_de_herramientas;

import com.cc.paint2D.gui.area_de_dibujo.Area_de_dibujo;
import com.cc.paint2D.gui.area_de_dibujo.Ventana_de_seleccion_de_font;
import com.cc.paint2D.props.Props;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPopupMenu_de_Seleccionar_Figura extends JPopupMenu 
    implements ActionListener, Props
{
	String FIGURAS="figuras";    
    
        
    String PARAMETROS="parametros";
        
    
    public static JPopupMenu_de_Seleccionar_Figura handle;
	
    public JPopupMenu_de_Seleccionar_Figura()
    {
        handle = this;
        JMenu jmenu1= null;
                
       jmenu1 = new JMenu(FIGURAS);
        
        	JMenuItem jmenuitem1 = new JMenuItem(LINEA);
        	jmenuitem1.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/linea.gif"))  );
        	jmenuitem1.addActionListener(this);
                
       jmenu1.add(jmenuitem1);
        
        	JMenuItem jmenuitem2 = new JMenuItem(LINEA_PUNTEADA);
        	jmenuitem2.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/linea_punteada.gif"))  );
        	jmenuitem2.addActionListener(this);
       
       jmenu1.add(jmenuitem2);
       
       		JMenuItem jmenuitem21 = new JMenuItem(ARCO);
       		jmenuitem21.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/arco.gif"))  );
        	jmenuitem21.addActionListener(this);
       
       jmenu1.add(jmenuitem21);
       
       		JMenuItem jmenuitem22 = new JMenuItem(POLIGONO_CERRADO);
       		jmenuitem22.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/poligono_cerrado.gif"))  );
        	jmenuitem22.addActionListener(this);
        	       
       jmenu1.add(jmenuitem22);//Area_de_dibujo:agregar_punto//Figura:dibujar
       
       		JMenuItem jmenuitem23 = new JMenuItem(ARCO_CERRADO);
       		jmenuitem23.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/arco_cerrado.gif"))  );
        	jmenuitem23.addActionListener(this);
        	       
       jmenu1.add(jmenuitem23);
       			
       		JMenuItem jmenuitem_elipse = new JMenuItem(ELIPSE);
       		jmenuitem_elipse.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/elipse.gif"))  );
        	jmenuitem_elipse.addActionListener(this);        	       
       jmenu1.add(jmenuitem_elipse);
       
       		JMenuItem jmenuitem_media_circunferencia = new JMenuItem(MEDIA_CIRCUNFERENCIA);
       		jmenuitem_media_circunferencia.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/media_circunferencia.gif"))  );
        	jmenuitem_media_circunferencia.addActionListener(this);        	       
       jmenu1.add(jmenuitem_media_circunferencia);	
       
       JMenuItem jmenuitem_curva_cubica = new JMenuItem(CURVA_CUBICA);
       		jmenuitem_curva_cubica.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/curva_cubica.gif"))  );
        	jmenuitem_curva_cubica.addActionListener(this);        	       
       jmenu1.add(jmenuitem_curva_cubica);	
       add(jmenu1);
       
       JMenu jmenu2= null;
       jmenu2 = new JMenu(TEXTO);
       		
       		JMenuItem jmenuitem_texto = new JMenuItem(PARAMETROS);
       		jmenuitem_texto.setIcon(  new javax.swing.ImageIcon(getClass().getResource("IMAGENES/texto.gif"))  );
        	jmenuitem_texto.addActionListener(this);
       jmenu2.add(jmenuitem_texto);     
       add(jmenu2);
              
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        JMenuItem jmenuitem = (JMenuItem)actionevent.getSource();
        
        String s = actionevent.getActionCommand();
        
        if( s ==  LINEA )
        {
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(LINEA);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+LINEA);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        	
        	Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, LINEA);
        }
        if( s ==  LINEA_PUNTEADA )
        {
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(LINEA_PUNTEADA);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+LINEA_PUNTEADA);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        
        	Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, LINEA_PUNTEADA);
        }
        
        if( s ==  ARCO )
        {
//System.out.println("1:JPopupMenu_de_Seleccionar_Figura:actionPerformed s="+ARCO);        	
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(ARCO);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+ARCO);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        
        	Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, ARCO);
        }
        
        if( s ==  POLIGONO_CERRADO )
        {
//System.out.println("1:JPopupMenu_de_Seleccionar_Figura:actionPerformed s="+POLIGONO_CERRADO);        	
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(POLIGONO_CERRADO);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+POLIGONO_CERRADO);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        	
        	Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, POLIGONO_CERRADO);
        }
        
        if( s ==  ARCO_CERRADO )
        {
//System.out.println("1:JPopupMenu_de_Seleccionar_Figura:actionPerformed s="+ARCO_CERRADO);        	
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(ARCO_CERRADO);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+ARCO_CERRADO);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        	
        	Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, ARCO_CERRADO);
        }
        
        if( s ==  ELIPSE )
        {
//System.out.println("1:JPopupMenu_de_Seleccionar_Figura:actionPerformed s="+ARCO_CERRADO);        	
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(ELIPSE);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+ELIPSE);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        	
        	Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, ELIPSE);
        }
        
        if( s == MEDIA_CIRCUNFERENCIA )
        {
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(MEDIA_CIRCUNFERENCIA);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+MEDIA_CIRCUNFERENCIA);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, MEDIA_CIRCUNFERENCIA);
        }
        
        if( s == CURVA_CUBICA )
        {
        	Area_de_dibujo.handle.set_FIGURA_ACTUAL(CURVA_CUBICA);
        	Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+CURVA_CUBICA);
        	Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
        
        Area_de_dibujo.handle.firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:dibujamos", null, CURVA_CUBICA);
        }
        
        if( s ==  PARAMETROS )
        {
        	//la ventana se encarga de lanzar el firePropertyChangeListenerPropertyChange
        	new Ventana_de_seleccion_de_font();
        }	
        
        
    }
    
    public void cambiar_Figura(String s)
    {
System.out.println("JPopupMenu_de_Seleccionar_Figura:cambiar_Figura=****"+s+"****");        	
    	
    	Area_de_dibujo.handle.set_FIGURA_ACTUAL(s);
    	
        Barra_de_herramientas.handle.JTF_estado.figura_actual.setText("Dibujamos: "+s);
        Barra_de_herramientas.handle.JTF_estado.estado_actual.setText("Estado : "+COLOCAR_PUNTO);
       
    }
    
}