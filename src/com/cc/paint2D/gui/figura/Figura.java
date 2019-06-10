package com.cc.paint2D.gui.figura;

import com.cc.paint2D.gui.barra_de_herramientas.Barra_de_herramientas;
import com.cc.paint2D.props.Props;

import java.util.LinkedList;
import java.util.Iterator;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.AlphaComposite;

public class Figura implements Props
{
	public LinkedList<Point2D> lista_Point2D = new LinkedList<Point2D>();
	public static Point2D mSelectedPoint;//si es estatico es solo hay uno
	int i_SelectedPoint=-1;
	
	public String ESTADO=null;
	
	public boolean colocar_punto=false;	
	public static boolean mover_punto=false;	
	public boolean borrar_punto=false;	
	public boolean borrar_figura=false;
	public boolean mover_figura=false;
	
	public Color color_punto_seleccionado=Color.red.darker();
	public Color color_punto_normal=Color.blue;
	public Color color_lineas=Color.red;
	
	public Font font_de_texto=new Font("Arial",Font.PLAIN, 10 );
	public String texto_figura="ninguna";
	public int X0=20;
	public int Y0=20;
		
	public String TIPO_DE_FIGURA="NNN";
	
	public float transparencia=1.0f;
	//Shape shape;
			
	public Figura(String tipo)
	{
System.out.println ( "Figura:Figura: TIPO_DE_FIGURA="+tipo );	
		TIPO_DE_FIGURA=tipo;
	}	
	
	public void mover_punto(double x ,double y)
	{
//System.out.println ( "Figura:mover_punto ( "+x+" , "+y+" )" );			
		
		Point2D punto;				
		punto= new Point2D.Double( x , y );
	
		if(mSelectedPoint != null) 
		{
		//mSelectedPoint.setLocation(punto);
		
			Iterator<Point2D> it = lista_Point2D.iterator();
			Point2D aux;
    		int cont=0;
    			while(it.hasNext())
    			{
    				aux = it.next();
    				Shape s_temp=get_punto_de_control(aux);
    				if( s_temp.contains(punto) )
    				{    			
    					mSelectedPoint=aux;
    					i_SelectedPoint=cont;
    					
    					mSelectedPoint.setLocation(punto);
    				}
    			cont++;	    		
    			}
				
		lista_Point2D.remove(i_SelectedPoint);
		lista_Point2D.add(i_SelectedPoint,punto);		
		//pintar_puntos();
		}
		else
		if(mSelectedPoint == null)
		{
			Iterator<Point2D> it = lista_Point2D.iterator();
    		Point2D aux;
    		int cont=0;
    			while(it.hasNext())
    			{
    				aux = it.next();
    				Shape s_temp=get_punto_de_control(aux);
    				if( s_temp.contains(punto) )
    				{    			
    					mSelectedPoint=aux;
    					i_SelectedPoint=cont;
    				}
    			cont++;	    		
    			}
		}
		
		
	}
	
	public void mover_figura(double x ,double y)
	{
System.out.println("Area_de_dibujo:mover_figura");
System.out.println("Area_de_dibujo:mover_figura tipo_de_figura: "+TIPO_DE_FIGURA);		
		
		Point2D centro_geometrico=get_centro_geometrico();
		
		Point2D vector_de_cambio=new Point2D.Double(x-centro_geometrico.getX(),
													y-centro_geometrico.getY() );
													
		LinkedList<Point2D> lista_nueva_Point2D = new LinkedList<Point2D>();
															
		Iterator<Point2D> it = lista_Point2D.iterator();
			Point2D aux;
    		int cont=0;
    			while(it.hasNext())
    			{
    				aux = it.next();
    				
    				Point2D aux_nuevo=new Point2D.Double(vector_de_cambio.getX()+aux.getX(),
    													 vector_de_cambio.getY()+aux.getY() );
    				
    				
    				lista_nueva_Point2D.add(aux_nuevo);
    				
					    				
    			cont++;	    		
    			}											
		
		lista_Point2D=lista_nueva_Point2D;
	}
	
	public Point2D get_centro_geometrico()
	{
		Point2D p2d_salida;
		
		double x_centro=0,y_centro=0;
		
		Iterator<Point2D> it = lista_Point2D.iterator();
			Point2D aux;
    		int cont=0;
    			while(it.hasNext())
    			{
    				aux = it.next();
    				
    				x_centro+=aux.getX();
    				y_centro+=aux.getY();
    				
    			cont++;	    		
    			}
		
		x_centro=x_centro/lista_Point2D.size();
		y_centro=y_centro/lista_Point2D.size();
		
		p2d_salida=new Point2D.Double(x_centro,y_centro);		
		
		return p2d_salida;
	}
	
	public void borrar_punto(double x ,double y)
	{
		Point2D punto;				
		punto= new Point2D.Double( x , y );
		
		Iterator<Point2D> it = lista_Point2D.iterator();
    	Point2D aux;
    	int cont=0;
    		while(it.hasNext())
    		{
    			aux = it.next();
    			Shape s_temp=get_punto_de_control(aux);
    			if( s_temp.contains(punto) )
    			{    			
    				lista_Point2D.remove(cont);
    				return;
    			}
    		cont++;	    		
    		}	
	}
	
	public Shape get_punto_de_control(Point2D p)
	{
	
	int tam=4;
	int lado=tam;
	return new Rectangle2D.Double( p.getX()-lado/2 , p.getY()-lado/2 , lado , lado );	
		
	}
	//Area_de_dibujo:agregar_punto
	public void dibujar( Graphics2D g2 )
	{
//System.out.println ( "Figura:dibujar TIPO_DE_FIGURA="+TIPO_DE_FIGURA );
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP , transparencia ));
System.out.println ( "Figura:dibujar transparencia="+transparencia );
		
		if( TIPO_DE_FIGURA.equalsIgnoreCase(LINEA) || TIPO_DE_FIGURA.equalsIgnoreCase(LINEA_PUNTEADA) )
		{	
			if( TIPO_DE_FIGURA.equalsIgnoreCase(LINEA_PUNTEADA) )
			{
//System.out.println ( "Figura:dibujar TIPO_DE_FIGURA setStroke");				
				setStroke(g2,3,10,0,5,20);//grosor
			}
			if(TIPO_DE_FIGURA == LINEA)
			{
//System.out.println ( "Figura:dibujar TIPO_DE_FIGURA setStroke");				
				setStroke(g2,2,2,2,2,2);//grosor
			}
			
			g2.setPaint(color_lineas);
			g2.draw( crear_LINEA() );
							
		}
		if( TIPO_DE_FIGURA.equalsIgnoreCase(ARCO) )
		{
			g2.setPaint(color_lineas);
			
			setStroke(g2,2,10,10,10,10);
			
			g2.draw( crear_ARCO() );
							
		}		
		if( TIPO_DE_FIGURA.equalsIgnoreCase(POLIGONO_CERRADO) )
		{
			g2.setPaint(color_lineas);
			
			setStroke(g2,2,10,10,10,10);
			
			g2.fill( crear_POLIGONO_CERRADO() );
											
		}
		
		if( TIPO_DE_FIGURA.equalsIgnoreCase(ELIPSE) )
		{
			g2.setPaint(color_lineas);			
			setStroke(g2,2,10,10,10,10);			
			if( lista_Point2D.size() ==2)
			g2.fill( crear_ELIPSE() );
		}
		
		if( TIPO_DE_FIGURA.equalsIgnoreCase(MEDIA_CIRCUNFERENCIA) )
		{
			g2.setPaint(color_lineas);			
			setStroke(g2,2,2,10,2,2);			
			if( lista_Point2D.size() ==2)
			g2.draw( crear_MEDIA_CIRCUNFERENCIA() );
		}
		if( TIPO_DE_FIGURA.equalsIgnoreCase(CURVA_CUBICA) )
		{
			g2.setPaint(color_lineas);			
			setStroke(g2,3,2,10,2,2);			
			g2.draw( crear_CURVA_CUBICA() );
		}
		
		if( TIPO_DE_FIGURA.equalsIgnoreCase(ARCO_CERRADO) )
		{
			g2.setPaint(color_lineas);
			
			setStroke(g2,2,10,10,10,10);
			
			g2.fill( crear_ARCO_CERRADO() );
											
		}
		
		if( TIPO_DE_FIGURA.equalsIgnoreCase(TEXTO) )
		{
			g2.setPaint(color_lineas);		
												
			g2.setFont(font_de_texto);
										
			if(! (lista_Point2D.size()==0) )
			{
				Point2D punto=lista_Point2D.getFirst();
				X0=(int)punto.getX();
				Y0=(int)punto.getY();
			}			
			g2.drawString(""+texto_figura,X0,Y0);
									
		}
		
		if( Barra_de_herramientas.handle.jchb_escribir_puntos.isSelected() )
				{					
				
				g2.setPaint(color_punto_normal);
				
				//para que los puntos no sean transparentes
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP , 1.0f ));
				g2.fill( crear_PUNTOS() );
					if(mover_punto)
					if(i_SelectedPoint!=-1)
					{
						g2.setPaint(color_punto_seleccionado);
						g2.fill( get_punto_de_control(mSelectedPoint) );
					}	
				}	
		
	}
	
	protected Shape crear_PUNTOS()
	{
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
//System.out.println ( "Figura:crear_PUNTOS n="+n );			
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
    
    GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO,
	mPoints.length);
	
	 
    for (int i = 0; i < n ; i += 1)
		{				
				path.moveTo(mPoints[0][i], mPoints[1][i]);
//System.out.println("Figura:crear_PUNTOS punto["+i+"]" );				
				
				{
//System.out.println("Figura:crear_PUNTOS agregamos puntos normales" );						
					path.append(get_punto_de_control(new Point2D.Double(mPoints[0][i], mPoints[1][i]) ) , false);
				}
		}
					   
	return path;
    		
	}	
	
	protected Shape crear_LINEA()
	{
	
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
	
	GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
	mPoints.length);
	
			
	path.moveTo(mPoints[0][0], mPoints[1][0]);
			
		for (int i = 1; i < n ; i += 1)
		{
				path.lineTo(mPoints[0][i], mPoints[1][i]);				
		}
		
	return path;
	}
	
	protected Shape crear_ARCO()
	{
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
	
	GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO,
	mPoints.length);
	
	path.moveTo(mPoints[0][0], mPoints[1][0]);
			
		for (int i = 0; i < n-2 ; i += 2)
		{
				path.curveTo(mPoints[0][i], mPoints[1][i],
							 mPoints[0][i+1], mPoints[1][i+1],
							 mPoints[0][i+2], mPoints[1][i+2]);				
		}
	
	return path;
	}
	
	protected Shape crear_ARCO_CERRADO()
	{
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
	
	GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
	mPoints.length);
	
	path.moveTo(mPoints[0][0], mPoints[1][0]);
			
		for (int i = 0; i < n-2 ; i += 2)
		{
				path.curveTo(mPoints[0][i], mPoints[1][i],
							 mPoints[0][i+1], mPoints[1][i+1],
							 mPoints[0][i+2], mPoints[1][i+2]);				
		}
	
	path.closePath();
	
	return path;
	}
	
	protected Shape crear_ELIPSE()
	{
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
//System.out.println ( "Figura:crear_ARCO n="+n );			
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
	
	Ellipse2D Elipse2D = new Ellipse2D.Float( mPoints[0][0] , mPoints[1][0] ,
											  mPoints[0][1] , mPoints[1][1] );	
	
	return Elipse2D;
	}
	
	protected Shape crear_MEDIA_CIRCUNFERENCIA()
	{
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
//System.out.println ( "Figura:crear_ARCO n="+n );			
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
	
	Arc2D arc2d = new Arc2D.Float( mPoints[0][0] , mPoints[1][0] ,
								   mPoints[0][1] , mPoints[1][1] , 180f , 180f, Arc2D.OPEN);//(ang inicio; extension)	// Arc2D.CHORD -->cerrada
	
	return arc2d;
	}
	protected Shape crear_CURVA_CUBICA()
	{
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
//System.out.println ( "Figura:crear_ARCO n="+n );			
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
		
	GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO,
	mPoints.length);
	
	path.moveTo(mPoints[0][0], mPoints[1][0]);
			
		for (int i = 0; i < n-3 ; i += 3)
		{
			path.moveTo(mPoints[0][i], mPoints[1][i]);
			
			CubicCurve2D cubicCurve2d=new CubicCurve2D.Float(mPoints[0][i], mPoints[1][i],
												 mPoints[0][i+1], mPoints[1][i+1],
												 mPoints[0][i+2], mPoints[1][i+2],
												 mPoints[0][i+3], mPoints[1][i+3]);
			path.append( cubicCurve2d , true );	
		}
			
	return path;
	}		
	
	protected Shape crear_POLIGONO_CERRADO()
	{
	int n=lista_Point2D.size();
	float[][] mPoints=new float[2][n];
//System.out.println ( "Figura:crear_ARCO n="+n );			
		
	Iterator<Point2D> it = lista_Point2D.iterator();
    Point2D aux;
    int cont=0;
    	while(it.hasNext())
    	{
    		aux = it.next();
    		if(aux instanceof Point2D)
    		{    			
    			mPoints[0][cont]=(float)aux.getX();
    			mPoints[1][cont]=(float)aux.getY();
    		}
    	cont++;	    		
    	}
	
	GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO,
	mPoints.length);
	
	path.moveTo(mPoints[0][0], mPoints[1][0]);
			
		for (int i = 0; i < n ; i += 1)
		{
				path.lineTo(mPoints[0][i], mPoints[1][i]);				
		}
	path.closePath();
	
	return path;
	}	
	
		
	public void set_estado_PUNTOS(String s)
	{
		ESTADO=new String(s);
		
		if( s.equalsIgnoreCase(MOVER_PUNTO) )
		{
			colocar_punto=false;	
			mover_punto=true;
			borrar_punto=false;
			borrar_figura=false;
			mover_figura=false;
		}
		else
		if(s.equalsIgnoreCase(COLOCAR_PUNTO) )
		{
			colocar_punto=true;	
			mover_punto=false;
			borrar_punto=false;
			borrar_figura=false;
			mover_figura=false;
		}
		else
		if(s.equalsIgnoreCase(BORRAR_PUNTO) )
		{
			colocar_punto=false;	
			mover_punto=false;
			borrar_punto=true;
			borrar_figura=false;
			mover_figura=false;
		}
		else
		if(s.equalsIgnoreCase(BORRAR_FIGURA) )
		{
			colocar_punto=false;	
			mover_punto=false;
			borrar_punto=false;
			borrar_figura=true;
			mover_figura=false;
		}
		else
		if(s.equalsIgnoreCase(MOVER_FIGURA) )
		{
			colocar_punto=false;	
			mover_punto=false;
			borrar_punto=false;
			borrar_figura=false;
			mover_figura=true;
		}
		
		
		
	}
	
	protected void setStroke(Graphics2D g2,int a,int b,int c,int d,int e)
	{
//System.out.println("--------------------------------------------------");	
//System.out.println("TIPO_DE_FIGURA = "+TIPO_DE_FIGURA);
//System.out.println("Figura:setStroke: ");	
//System.out.println("--------------------------------------------------");	
	// Crea un stroke CON LOS PARAMETROS.
	Stroke stroke = new BasicStroke(a, BasicStroke.CAP_SQUARE,
	BasicStroke.JOIN_MITER, b,
	new float[] { c, d }, e);
	g2.setStroke(stroke);
	}
	
	public int esta_en_la_lista(int x, int y)
	{
		int i_salida=-1;
		
		Iterator<Point2D> it = lista_Point2D.iterator();
    	Point2D aux;
    	int cont=0;
    		while(it.hasNext())
    		{
    			aux = it.next();
    			if(aux instanceof Point2D)
    			{    			
    				Shape s_aux=get_punto_de_control(aux);
    				if(s_aux.contains(new Point2D.Double(x,y)))
    				i_salida=cont;    				
    			}
    		cont++;	    		
    		}
    		
    	return i_salida;	
	}
	
	public String get_puntos_para_guardar()
	{
		int n=lista_Point2D.size();
		String s_salida="";
		
		//System.out.println ( "Figura:get_puntos_para_guardar n="+n );			
		
		Iterator<Point2D> it = lista_Point2D.iterator();
    		Point2D aux;
    			int cont=0;
    				while(it.hasNext())
    				{
    					aux = it.next();
    					if(aux instanceof Point2D)
    					{    			
    						
    						s_salida += ""+aux.getX()+",";
    						s_salida += ""+aux.getY()+",";
    						
    						s_salida += "#";
    					}
    				cont++;	    		
    				}
    	
    	return s_salida;			
	}
	
}