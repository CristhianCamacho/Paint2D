package com.cristhian.camacho.paint2D.gui.area_de_dibujo;

import com.cristhian.camacho.paint2D.gui.JFrame_Principal;
import com.cristhian.camacho.paint2D.gui.barra_de_herramientas.Barra_de_herramientas;
import com.cristhian.camacho.paint2D.gui.barra_de_herramientas.JPopupMenu_de_Estado_Figura;
import com.cristhian.camacho.paint2D.gui.barra_de_herramientas.JPopupMenu_de_Seleccionar_Figura;
import com.cristhian.camacho.paint2D.gui.figura.Figura;
import com.cristhian.camacho.paint2D.props.Props;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Area_de_dibujo extends JPanel implements Props
{

    public LinkedList<Figura> lista_Figura = new LinkedList<Figura>();
    public Figura mSelectedFigura=null;

    String ESTADO="";

    public boolean colocar_Figura=false;
    public boolean mover_Figura=false;
    public boolean borrar_Figura=false;
    public boolean borrar_todo=false;


    public int ancho,alto;
    public static Area_de_dibujo handle;

    String NINGUNA="ninguna";

    public Color color_de_fondo=Color.white;

    public String FIGURA_ACTUAL=NINGUNA;
    public Font font_de_figura_actual=new Font("Arial",Font.PLAIN, 10 );
    public String texto_de_figura_actual="ninguna";

    public float transparencia_de_figura_actual=1f;

    public Area_de_dibujo()
    {
        handle=this;

        addMouseListener( new Eventos_Figuras() );
        addMouseMotionListener( new Eventos_Figuras() );

        init();
    }

    public void set_FIGURA_ACTUAL(String s)
    {


        FIGURA_ACTUAL=s;
        System.out.println ( "Area_de_dibujo:set_FIGURA_ACTUAL s = "+ s);
        if(mSelectedFigura!=null)
        {
            System.out.println("Area_de_dibujo:set_FIGURA_ACTUAL mSelectedFigura!=null ");
            System.out.println("Area_de_dibujo:set_FIGURA_ACTUAL s="+FIGURA_ACTUAL);
//System.out.println("3:Area_de_dibujo:dibujamos mSelectedFigura="+mSelectedFigura.TIPO_DE_FIGURA);

            lista_Figura.add(mSelectedFigura);
            mSelectedFigura=null;
        }

        System.out.println ( "Area_de_dibujo:set_FIGURA_ACTUAL mSelectedFigura = "+ mSelectedFigura);
    }
    //Figura:dibujar
    public void agregar_punto(int x, int y, boolean lanzamos)
    {
        int i_temp=esta_en_la_lista(new Integer(x),new Integer(y));
        System.out.println ( "**********************************************************");
        //solo si movemos el punto podemos cambiar de figuras
        if(mSelectedFigura!=null)
            if(mSelectedFigura.mover_punto || FIGURA_ACTUAL.equals("ninguna") )//||mSelectedFigura.borrar_punto)
                if(i_temp!=-1)
                {
                    System.out.println ( "----------------------------------------------------------");
                    System.out.println ( "Area_de_dibujo:agregar_punto: esta en la lista ( "+x+" , "+y+")");
                    Figura f_temp=mSelectedFigura;
                    lista_Figura.add(mSelectedFigura);
                    mSelectedFigura=lista_Figura.get(i_temp);
                    lista_Figura.remove(i_temp);

                    mSelectedFigura.borrar_figura=false;//f_temp.borrar_figura;
                    mSelectedFigura.mover_punto=true;//f_temp.mover_punto;
                    mSelectedFigura.colocar_punto=false;//f_temp.colocar_punto;
                    mSelectedFigura.borrar_punto=false;//f_temp.borrar_punto;
                    mSelectedFigura.ESTADO=f_temp.ESTADO;
                    FIGURA_ACTUAL=mSelectedFigura.TIPO_DE_FIGURA;
                }

        System.out.println ( "Area_de_dibujo:agregar_punto: FIGURA_ACTUAL=*"+FIGURA_ACTUAL+"*" );
//System.out.println ( "Area_de_dibujo:agregar_punto: mSelectedFigura="+mSelectedFigura);

        if( FIGURA_ACTUAL.equalsIgnoreCase(LINEA) || FIGURA_ACTUAL.equalsIgnoreCase(LINEA_PUNTEADA) ||
                FIGURA_ACTUAL.equalsIgnoreCase(ARCO) || FIGURA_ACTUAL.equalsIgnoreCase(POLIGONO_CERRADO) ||
                FIGURA_ACTUAL.equalsIgnoreCase(ARCO_CERRADO) || FIGURA_ACTUAL.equalsIgnoreCase(TEXTO) ||
                FIGURA_ACTUAL.equalsIgnoreCase(ELIPSE) || FIGURA_ACTUAL.equalsIgnoreCase(MEDIA_CIRCUNFERENCIA) ||
                FIGURA_ACTUAL.equalsIgnoreCase(CURVA_CUBICA))
        {
            System.out.println ( "Area_de_dibujo:agregar_punto: mSelectedFigura="+mSelectedFigura);
            if(mSelectedFigura==null)
            {

                System.out.println ( "Area_de_dibujo:agregar_punto: mSelectedFigura=null");
                if( FIGURA_ACTUAL.equalsIgnoreCase(LINEA) )
                    mSelectedFigura=new Figura(LINEA);
                if( FIGURA_ACTUAL.equalsIgnoreCase(LINEA_PUNTEADA) )
                    mSelectedFigura=new Figura(LINEA_PUNTEADA);
                if( FIGURA_ACTUAL.equalsIgnoreCase(ARCO) )
                    mSelectedFigura=new Figura(ARCO);
                if( FIGURA_ACTUAL.equalsIgnoreCase(POLIGONO_CERRADO) )
                    mSelectedFigura=new Figura(POLIGONO_CERRADO);
                if( FIGURA_ACTUAL.equalsIgnoreCase(ARCO_CERRADO) )
                    mSelectedFigura=new Figura(ARCO_CERRADO);
                if( FIGURA_ACTUAL.equalsIgnoreCase(ELIPSE) )
                    mSelectedFigura=new Figura(ELIPSE);
                if( FIGURA_ACTUAL.equalsIgnoreCase(MEDIA_CIRCUNFERENCIA) )
                    mSelectedFigura=new Figura(MEDIA_CIRCUNFERENCIA);
                if( FIGURA_ACTUAL.equalsIgnoreCase(CURVA_CUBICA) )
                    mSelectedFigura=new Figura(CURVA_CUBICA);

                if( FIGURA_ACTUAL.equalsIgnoreCase(TEXTO) )
                {
                    mSelectedFigura=new Figura(TEXTO);
                    mSelectedFigura.font_de_texto=font_de_figura_actual;
                    font_de_figura_actual=new Font("Arial",Font.PLAIN, 10 );;
                    mSelectedFigura.texto_figura=texto_de_figura_actual;
                    texto_de_figura_actual="ninguna";
                };


                mSelectedFigura.transparencia = transparencia_de_figura_actual;
                transparencia_de_figura_actual=1.0f;

                mSelectedFigura.set_estado_PUNTOS( Figura.COLOCAR_PUNTO );
            }


            if(mSelectedFigura.colocar_punto)
            {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

                //por que no pueden tener un numero indefinido de puntos
                if( !( FIGURA_ACTUAL.equalsIgnoreCase(TEXTO)  ) &&
                        !( FIGURA_ACTUAL.equalsIgnoreCase(ELIPSE)  ) &&
                        !( FIGURA_ACTUAL.equalsIgnoreCase(MEDIA_CIRCUNFERENCIA)  ) )
                {
                    System.out.println ( "Area_de_dibujo:agregar_punto: colocar_punto "+"("+x+" , "+y+")");
                    mSelectedFigura.lista_Point2D.add(new Point2D.Double(x,y));

                }
                else
                if( FIGURA_ACTUAL.equalsIgnoreCase(TEXTO) )
                {
                    if(mSelectedFigura.lista_Point2D.size()<1)
                    {
                        mSelectedFigura.lista_Point2D.add(new Point2D.Double(x,y));
                        mSelectedFigura.set_estado_PUNTOS( Figura.MOVER_PUNTO );
                    }
                }
                else
                if( FIGURA_ACTUAL.equalsIgnoreCase(ELIPSE) || FIGURA_ACTUAL.equalsIgnoreCase(MEDIA_CIRCUNFERENCIA) )
                {
                    if(mSelectedFigura.lista_Point2D.size()==2)
                    {
                        mSelectedFigura.set_estado_PUNTOS( Figura.MOVER_PUNTO );
                    }
                    if(mSelectedFigura.lista_Point2D.size()<2)
                    {
                        mSelectedFigura.lista_Point2D.add(new Point2D.Double(x,y));
                    }
                };

            }
            else
            if(mSelectedFigura.mover_punto)
            {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                System.out.println ( "Area_de_dibujo:agregar_punto: mover_punto "+"("+x+" , "+y+")");
                mSelectedFigura.mover_punto((double)x,(double)y);
            }
            else
            if(mSelectedFigura.borrar_punto)
            {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                System.out.println ( "Area_de_dibujo:agregar_punto: borrar_punto "+"("+x+" , "+y+")");
                mSelectedFigura.borrar_punto((double)x,(double)y);
            }
            else
            if(mSelectedFigura.borrar_figura)
            {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                mSelectedFigura=null;
                if(lista_Figura.size()!=0)
                    mSelectedFigura=lista_Figura.getLast();
            }
            else
            if(mSelectedFigura.mover_figura)
            {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                mSelectedFigura.mover_figura((double)x,(double)y);
            }
        }

        if(lanzamos)
/////////////////////////////////////////////////////////
            firePropertyChangeListenerPropertyChange(this, "Area_de_dibujo:repintar", null, x+"$"+y+"$" );
///////////////////////////////////////////////////////
    }

    public int esta_en_la_lista(int x, int y)
    {
        int i_salida=-1;

        Iterator<Figura> it = lista_Figura.iterator();
        Figura aux;
        int cont=0;
        while(it.hasNext())
        {
            aux = it.next();
            if(aux instanceof Figura)
            {
                //g2.setStroke(stroke_normal);
                if(aux.esta_en_la_lista(x,y)!=-1)
                    i_salida=cont;
            }
            cont++;
        }

        return i_salida;
    }

    public void init()
    {
        //setBackground(color_de_fondo);

        setDoubleBuffered(true);
    }

    public void paint( Graphics g )
    {
        ancho=getSize().width;
        alto=getSize().height;


        Graphics2D g2=(Graphics2D)g;
        g2.setBackground(color_de_fondo);
        g2.clearRect(0,0,ancho,alto);


        if(Barra_de_herramientas.handle.jchb_antialiasing.isSelected())
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        else
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);

        g2.setBackground(Color.white);

        if( Barra_de_herramientas.handle.jchb_pintar_ejes.isSelected() )
        {
            pintar_ejes(g2);
        }

        try
        {
            pintar_Figuras(g2);

        }catch(Exception e)
        {
            System.out.println( "paint: Error "+e.getMessage() );
        }

    }

    public void pintar_Figuras( Graphics2D g2 )
    {

        Iterator<Figura> it = lista_Figura.iterator();
        Figura aux;
        int cont=0;
        while(it.hasNext())
        {
            aux = it.next();
            if(aux instanceof Figura)
            {
                aux.dibujar(g2);
            }
            cont++;
        }

        if(mSelectedFigura!=null)
        {
            mSelectedFigura.dibujar(g2);
        }



    }

    public void pintar_ejes(Graphics2D g2d)
    {
        //ancho=getSize().width;
        //alto=getSize().height;


        int n_f=(int)((ancho/2)/escala);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setFont(new Font("Helvetica",Font.PLAIN,6));

        for(int i=0;i<=n_f;i++)
        {
            g2d.drawLine( (int)(ancho/2-i*escala),(int)(5),(int)(ancho/2-i*escala),(int)(alto-5) );
        }
        for(int i=0;i<=n_f;i++)
        {
            g2d.drawLine( (int)(ancho/2+i*escala),(int)(5),(int)(ancho/2+i*escala),(int)(alto-5) );
        }

        int n_c=(int)((alto/2)/escala);
        for(int i=0;i<=n_c;i++)
        {
            g2d.drawLine( (int)(5),(int)(alto/2-i*escala),(int)(ancho-5),(int)(alto/2-i*escala) );
        }
        for(int i=0;i<=n_c;i++)
        {
            g2d.drawLine( (int)(5),(int)(alto/2+i*escala),(int)(ancho-5),(int)(alto/2+i*escala) );
        }


        g2d.setColor(Color.BLACK);
        //eje y
        g2d.drawLine( (int)(ancho/2),(int)(5),(int)(ancho/2),(int)(alto-5) );
        //eje x
        g2d.drawLine( (int)(5),(int)(alto/2),(int)(ancho-5),(int)(alto/2) );

    }

    public int escala=40;

    public String guardar_Area_de_dibujo()
    {
        if(mSelectedFigura!=null)
        {
            lista_Figura.add(mSelectedFigura);
            mSelectedFigura=null;
        }

        String s_salida = "";

        Iterator<Figura> it = lista_Figura.iterator();
        Figura aux;
        int cont=0;
        while(it.hasNext())
        {
            aux = it.next();
            if(aux instanceof Figura)
            {
                System.out.println("Area_de_dibujo:guardar_Area_de_dibujo TIPO_DE_FIGURA="+aux.TIPO_DE_FIGURA);
                s_salida += aux.TIPO_DE_FIGURA+"@";
                s_salida += ""+color_de_fondo.hashCode()+"@";
                s_salida += ""+aux.color_punto_seleccionado.hashCode()+"@";
                s_salida += ""+aux.color_punto_normal.hashCode()+"@";
                s_salida += ""+aux.color_lineas.hashCode()+"@";
                System.out.println("Area_de_dibujo:guardar_Area_de_dibujo TIPO_DE_FIGURA="+aux.font_de_texto);
                s_salida += aux.font_de_texto.getFontName()+"@";
                s_salida += ""+aux.font_de_texto.getStyle()+"@";
                s_salida += ""+aux.font_de_texto.getSize()+"@";
                s_salida += aux.texto_figura+"@";
                s_salida += ""+aux.X0+"@";
                s_salida += ""+aux.Y0+"@";
                s_salida += ""+aux.transparencia+"@";
                s_salida += aux.get_puntos_para_guardar()+"@";

                if( it.hasNext() )
                    s_salida += ":";


                System.out.println("Area_de_dibujo:guardar_Area_de_dibujo s_salida="+s_salida);
            }
            cont++;
        }
        return s_salida;
    }
    public void abrir_Area_de_dibujo(String s)
    {
        lista_Figura.clear();
        mSelectedFigura=null;

        System.out.println("Area_de_dibujo:abrir_Area_de_dibujo s:"+s);

        StringTokenizer t = new StringTokenizer(s,":");
        while(t.hasMoreTokens())
        {
            StringTokenizer t_1= new StringTokenizer( t.nextToken() , "@" );
            System.out.println("Area_de_dibujo:abrir_Area_de_dibujo t_1:"+t_1);

            String fig=t_1.nextToken();
            System.out.println("Area_de_dibujo:Figura_actual= **"+fig+"**");

            {

                System.out.println("!fig.equalsIgnoreCase(\"\")"+"**"+fig+"**");
                (JPopupMenu_de_Seleccionar_Figura.handle!= null ?
                        (JPopupMenu_de_Seleccionar_Figura.handle) :
                        (new JPopupMenu_de_Seleccionar_Figura()) ).handle.cambiar_Figura( new String(fig) );

                String color_de_fondo_=t_1.nextToken();
                String color_punto_seleccionado=t_1.nextToken();
                String color_punto_normal = t_1.nextToken();
                String color_lineas = t_1.nextToken();

                String font_name=t_1.nextToken();
                int font_style=Integer.parseInt( t_1.nextToken() );
                int font_size=Integer.parseInt( t_1.nextToken() );
                Font font_de_texto=new Font(font_name,font_style,font_size);
                font_de_figura_actual=font_de_texto;
                String texto_figura=t_1.nextToken();
                texto_de_figura_actual=texto_figura;

                int X0=(int)Float.parseFloat( t_1.nextToken() );
                int Y0=(int)Float.parseFloat( t_1.nextToken() );
                float transparencia=Float.parseFloat( t_1.nextToken() );

                System.out.println("Area_de_dibujo:abrir_Area_de_dibujo font_de_texto="+font_de_texto);

                System.out.println("Area_de_dibujo:abrir_Area_de_dibujo =set_puntos_para_abrir");

////////////////////////////////////////////////////////////////////////////////
                System.out.println("Area_de_dibujo:set_puntos_para_abrir s="+s);
                StringTokenizer tt = new StringTokenizer(t_1.nextToken(),"#");
                System.out.println("Area_de_dibujo:set_puntos_para_abrir t="+tt.toString() );
                while(tt.hasMoreTokens())
                {
                    StringTokenizer tt_1= new StringTokenizer( tt.nextToken() , "," );
                    String s_x=tt_1.nextToken();
                    System.out.println("Area_de_dibujo:set_puntos_para_abrir s_x="+s_x);
                    String s_y=tt_1.nextToken();
                    System.out.println("Area_de_dibujo:set_puntos_para_abrir s_y="+s_y);

                    double x=1234567;
                    double y=2345678;
                    try{
                        x=Double.parseDouble(s_x);
                        y=Double.parseDouble(s_y);
                    }
                    catch(Exception e)
                    {
                        System.out.println("ERRORRRRRRR !!!!!!!");
                    }

                    if(x!=1234567&&y!=2345678)
                        agregar_punto((int)x,(int)y,false);

                }


////////////////////////////////////////////////////////////////////////////////
                Area_de_dibujo.handle.color_de_fondo=new Color ( Integer.parseInt(color_de_fondo_) );

                (JPopupMenu_de_Estado_Figura.handle!= null ?
                        (JPopupMenu_de_Estado_Figura.handle) :
                        (new JPopupMenu_de_Estado_Figura()) ).cambiar_color_SELECCIONADO( color_punto_seleccionado );

                (JPopupMenu_de_Estado_Figura.handle!= null ?
                        (JPopupMenu_de_Estado_Figura.handle) :
                        (new JPopupMenu_de_Estado_Figura()) ).cambiar_color_NORMAL( color_punto_normal );

                (JPopupMenu_de_Estado_Figura.handle!= null ?
                        (JPopupMenu_de_Estado_Figura.handle) :
                        (new JPopupMenu_de_Estado_Figura()) ).cambiar_color_RELLENO( color_lineas );


                JFrame_Principal.handle.area_de_dibujo.font_de_figura_actual=font_de_texto;
                JFrame_Principal.handle.area_de_dibujo.texto_de_figura_actual=new String(texto_figura);
                if(FIGURA_ACTUAL.equalsIgnoreCase(Props.TEXTO))
                    JFrame_Principal.handle.barra_de_herramientas.JTF_estado.figura_actual.setText("Dibujamos: "+Props.TEXTO);

                System.out.println("texto_figura "+texto_figura);

                System.out.println("X0 "+X0);
                //mSelectedFigura.X0=X0;

                System.out.println("Y0 "+Y0);
                //mSelectedFigura.Y0=Y0;

                System.out.println("transparencia "+transparencia);
                mSelectedFigura.transparencia=transparencia;

                System.out.println("Area_de_dibujo:abrir_Area_de_dibujo s_salida="+lista_Figura);

            }
            repaint();

        }

    }

    public static void main(String arg[])
    {
    }

    /**
     * Registers PropertyChangeListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {

        if (listenerList == null ) {
            listenerList = new javax.swing.event.EventListenerList();
        }
        listenerList.add (java.beans.PropertyChangeListener.class, listener);
    }

    /**
     * Removes PropertyChangeListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {

        listenerList.remove (java.beans.PropertyChangeListener.class, listener);
    }

    /**
     * Notifies all registered listeners about the event.
     *
     * @param param1 Parameter #1 of the <CODE>PropertyChangeEvent<CODE> constructor.
     * @param param2 Parameter #2 of the <CODE>PropertyChangeEvent<CODE> constructor.
     * @param param3 Parameter #3 of the <CODE>PropertyChangeEvent<CODE> constructor.
     * @param param4 Parameter #4 of the <CODE>PropertyChangeEvent<CODE> constructor.
     */
    public void firePropertyChangeListenerPropertyChange(java.lang.Object param1, java.lang.String param2, java.lang.Object param3, java.lang.Object param4)
    {

        java.beans.PropertyChangeEvent e = null;
        if (listenerList == null)
        {
            //System.out.println("la lista esta vacia");
            return;
        }
        Object[] listeners = listenerList.getListenerList ();
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==java.beans.PropertyChangeListener.class) {
                if (e == null)
                    e = new java.beans.PropertyChangeEvent (param1, param2, param3, param4);
                ((java.beans.PropertyChangeListener)listeners[i+1]).propertyChange (e);
            }
        }

    }

}