package com.cristhian.camacho.paint2D.props;

import java.awt.Font;

public interface Props
{
	public static String ARCHIVO="Archivo";
	
	public static String NUEVO="nuevo";
	public static String ABRIR="abrir";
	public static String GUARDAR="guardar";
	public static String GUARDAR_COMO="guardar como";
	public static String GUARDAR_COMO_TXT="guardar como txt";
	public static String GUARDAR_COMO_JPG="guardar como jpg";
	public static String SALIR="salir";
	
	public static String COLOR_DE_FONDO="color_de_fondo";
	public static String COLOR_DE_RELLENO="color_de_relleno";
	public static String COLOR_DE_PUNTO_NORMAL="color_de_punto_normal";
	public static String COLOR_DE_PUNTO_SELECCIONADO="color_de_punto_seleccionado";
	public static String TRANSPARENCIA="transparencia";
	
	public static String COLOCAR_PUNTO = "colocar_puntos";
	public static String MOVER_PUNTO="mover_puntos";
	public static String BORRAR_PUNTO="borrar_puntos";
	public static String BORRAR_FIGURA="borrar_figura";
	public static String MOVER_FIGURA="mover_figura";
	
	public static String LINEA="linea";
	public static String LINEA_PUNTEADA="linea_punteada";
	public static String ARCO="arco";	
	public static String POLIGONO_CERRADO="poligono_cerrado";
	public static String ARCO_CERRADO="arco_cerrado";
	public static String ELIPSE="elipse";
	public static String MEDIA_CIRCUNFERENCIA="media_circunferencia";
	public static String CURVA_CUBICA="curva_cubica";
	
	
	public static String TEXTO="texto";
	
	public static Font font_barra_menus=new Font("Georgia",Font.BOLD,16);//Bugaboo SSi//Edda
	public static Font font_barra_herramientas=new Font("Georgia",Font.BOLD,14);//Neuropolitical
	public static Font font_chat_pequenyo=new Font("Arial",Font.BOLD,14);//Neuropolitical
	public static Font font_chat_grande=new Font("Arial",Font.BOLD,16);//Neuropolitical
	
}