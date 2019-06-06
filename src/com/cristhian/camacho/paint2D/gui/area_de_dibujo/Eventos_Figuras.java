package com.cristhian.camacho.paint2D.gui.area_de_dibujo;

import com.cristhian.camacho.paint2D.gui.barra_de_herramientas.Barra_de_herramientas;
import com.cristhian.camacho.paint2D.gui.barra_de_herramientas.JPopupMenu_de_Estado_Figura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Eventos_Figuras implements MouseListener,MouseMotionListener
{

    public Eventos_Figuras()
    {

    }

    //MouseListener
    public void mouseClicked(MouseEvent e)
    {
        System.out.println ( "mouseClicked Eventos_Figuras" );
//		System.out.println ( " "+e.getPoint().getX()+" ; "+e.getPoint().getY() );
        Area_de_dibujo.handle.agregar_punto( (int)(e.getPoint().getX()) ,
                (int)(e.getPoint().getY()) , true);

        Area_de_dibujo.handle.repaint();
    }

    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {

    }
    public void mousePressed(MouseEvent e)
    {
        System.out.println ( "mouseClicked Eventos_Figuras "+e.getButton() );
        if(e.getButton()==e.BUTTON3)
        {
            showPopup(   JPopupMenu_de_Estado_Figura.handle!= null ?
                    ((JPopupMenu) (JPopupMenu_de_Estado_Figura.handle)) :
                    ((JPopupMenu) (new JPopupMenu_de_Estado_Figura())) ,e.getX(),e.getY(),e);
        }
    }
    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseMoved(MouseEvent e)
    {
		/*System.out.println ( ":Eventos_Figuras:mousePressed " );
    	Area_de_dibujo.handle.agregar_punto( (int)(e.getPoint().getX()) ,
										     (int)(e.getPoint().getY()) );
    	Area_de_dibujo.handle.repaint();
    	*/
    }
    public void mouseDragged(MouseEvent e)
    {
//		System.out.println("mouseDragged");

//		System.out.println ( ":Eventos_Figuras:mouseDragged " );
        Area_de_dibujo.handle.agregar_punto( (int)(e.getPoint().getX()) ,
                (int)(e.getPoint().getY()), true );


        Area_de_dibujo.handle.repaint();
    }




    public void showPopup(JPopupMenu jpopupmenu, int x, int y, MouseEvent e)
    {
        if(jpopupmenu.isVisible())
            return;
        //menu_actual = jpopupmenu;
        //Component component = (Component)actionevent.getSource();
        Component component = (Component)e.getSource();
        Container container = component.getParent();

        //if(container.isAncestorOf(jpopupmenu))
        //{
        //    jpopupmenu.setVisible(true);
        //} else
        {
            //Point point = component.getLocation();
            //Dimension dimension = component.getSize();
            //container.add(jpopupmenu);
            //jpopupmenu.show(container, point.x, point.y + dimension.height);
            jpopupmenu.show(container, x, y + Barra_de_herramientas.handle.getSize().height );
        }


    }

}