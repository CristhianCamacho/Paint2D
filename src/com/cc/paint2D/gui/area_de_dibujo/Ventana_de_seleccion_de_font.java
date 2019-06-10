package com.cc.paint2D.gui.area_de_dibujo;

import com.cc.paint2D.gui.JFrame_Principal;
import com.cc.paint2D.props.Props;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ventana_de_seleccion_de_font
{

    final JFrame infr=new JFrame("cambiar_font");
    JTextArea eti=new JTextArea("Texto");

    public Ventana_de_seleccion_de_font()
    {

        infr.setLayout(null);
        dar_tamaño();
        crear_GUI();
        centrar();

        infr.setVisible(true);
    }

    public void crear_GUI()
    {

        infr.setLayout(new GridLayout(5,1) );


        JPanel jpanel_texto=new JPanel();
        jpanel_texto.setLayout( new BorderLayout() );
        JScrollPane scroll_texto= new JScrollPane(eti);
        jpanel_texto.add(scroll_texto,BorderLayout.CENTER);
        infr.add(jpanel_texto);

        final Choice choice_font = new Choice();
        final Choice choice_tamanyo = new Choice();
        final Choice choice_style = new Choice();
        final int size = 14;


        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] allFonts = ge.getAllFonts();

        for (int i = 0; i < allFonts.length; i++)
            choice_font.addItem(allFonts[i].getName());

        //choice.select(0);//"Adler"

        for (int i = 1; i < 100; i++)
            choice_tamanyo.addItem(""+i);

        choice_tamanyo.select(13);

        choice_style.add("Font.PLAIN");//0
        choice_style.add("Font.BOLD");//1
        choice_style.add("Font.ITALIC");//2


////////////////////////////////////////////////////////////////////////////////
        Font font = new Font(choice_font.getSelectedItem(), choice_style.getSelectedIndex(), Integer.parseInt(choice_tamanyo.getSelectedItem()));
        eti.setFont(font);
////////////////////////////////////////////////////////////////////////////////

        choice_tamanyo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try
                {
                    Font font = new Font(choice_font.getSelectedItem(), choice_style.getSelectedIndex(), Integer.parseInt(choice_tamanyo.getSelectedItem()));

                    eti.setFont(font);

                }
                catch (Exception e)
                {
                }

            }
        });
        infr.add(choice_tamanyo);

        choice_font.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try
                {
                    Font font = new Font(choice_font.getSelectedItem(), choice_style.getSelectedIndex(), Integer.parseInt(choice_tamanyo.getSelectedItem()));
                    eti.setFont(font);
                }
                catch (Exception e)
                {
                }

            }
        });
        infr.add(choice_font);

        choice_style.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try
                {
                    Font font = new Font(choice_font.getSelectedItem(), choice_style.getSelectedIndex(), Integer.parseInt(choice_tamanyo.getSelectedItem()));
                    eti.setFont(font);
                }
                catch (Exception e)
                {
                }

            }
        });
        infr.add(choice_style);

        JButton boton=new JButton("aceptar");

        boton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) //throws Exception_del_rango_de_parametros
            {
                Font font = new Font(choice_font.getSelectedItem(), choice_style.getSelectedIndex(), Integer.parseInt(choice_tamanyo.getSelectedItem()));
                JFrame_Principal.handle.area_de_dibujo.set_FIGURA_ACTUAL(Props.TEXTO);
                JFrame_Principal.handle.area_de_dibujo.font_de_figura_actual=font;
                JFrame_Principal.handle.area_de_dibujo.texto_de_figura_actual=new String(eti.getText());
                JFrame_Principal.handle.barra_de_herramientas.JTF_estado.figura_actual.setText("Dibujamos: "+ Props.TEXTO);

                JFrame_Principal.handle.area_de_dibujo.firePropertyChangeListenerPropertyChange(this, "Ventana_de_seleccion_de_font:dibujamos", null, Props.TEXTO+
                        "$"+font.getFontName()+
                        "$"+font.getStyle()+
                        "$"+font.getSize()+
                        "$"+new String(eti.getText())
                );
                infr.setVisible(false);
            }
        });
        infr.add(boton);

    }

    public void centrar()
    {
        //centrar
        Dimension dimension_de_la_pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension_del_Main = infr.getSize();

        int x = (dimension_de_la_pantalla.width - dimension_del_Main.width) / 2;
        int y = (dimension_de_la_pantalla.height - dimension_del_Main.height) / 2;

        infr.setLocation(x, y);
        //
    }

    public void dar_tamaño()
    {
        //dar tamaño
        Dimension dimension_de_la_pantalla_ = Toolkit.getDefaultToolkit().getScreenSize();

        //int ancho=dimension_de_la_pantalla_.width-800;
        int ancho=224;
        System.out.println("Ventana_d_seleccion_de_font:dar_tamaño: ancho="+ancho);
        //int alto=dimension_de_la_pantalla_.height-550;
        int alto=218;
        System.out.println("Ventana_d_seleccion_de_font:dar_tamaño: alto="+alto);

        infr.resize(ancho,alto);

    }
}