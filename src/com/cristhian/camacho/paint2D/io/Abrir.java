package com.cristhian.camacho.paint2D.io;

import com.cristhian.camacho.paint2D.gui.JFrame_Principal;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Abrir
{
	String texto="";
	
	public Abrir () {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
System.out.println( "System.getProperty(\"user.dir\")"+System.getProperty("user.dir") );
String aux=System.getProperty("user.dir");

       if(aux.endsWith("bin"))	
       {
       		aux=aux.substring( 0 , aux.length()-"bin".length() );
       		aux+="ARCHIVOS_TXT";
       }
       else       
       {       		
       		aux+="/ARCHIVOS_TXT";
       }
System.out.println( "aux" + aux );


fileChooser.setCurrentDirectory( new File( aux ) );
								
		fileChooser.setFileFilter(new FileFilter()
	   							{	public String getDescription()
	   								{
										return ".txt";
									}
	
									public boolean accept( File archivo )
									{
									boolean res = false;		
									String nombre = archivo.getName();
		
									if( nombre.endsWith(".txt") ||archivo.isDirectory()|| archivo.isFile())
									res = true;
		
									return res;
									}
	   							}
	   							);	


		
		int result= fileChooser.showOpenDialog(JFrame_Principal.handle);
		if (result== JFileChooser.CANCEL_OPTION) return;
		File name= fileChooser.getSelectedFile();
		if(name.exists()) {
//System.out.println("Abrir:"+name.getName());			
			if (name.isFile() && name.getName().endsWith(".txt") )//solo archivos de texto
			{
				try 
				{
					BufferedReader input= new BufferedReader(new FileReader (name));
					StringBuffer buffer= new StringBuffer();
					String text;
					while ((text=input.readLine()) !=null)
						buffer.append(text+ "\n");
					texto=buffer.toString();
////////////////////////////////////////////////////////////////////////////////
System.out.println("Abrir:----------------------------------------------------");
					JFrame_Principal.handle.area_de_dibujo.abrir_Area_de_dibujo(texto);
////////////////////////////////////////////////////////////////////////////////					
				}
				catch (IOException ioException) {
					JOptionPane.showMessageDialog(null,"Error en el archivo", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if (name.isDirectory ()) {
				JOptionPane.showMessageDialog(null,"Error en el archivo no se puede cargar un directorio", "Error",JOptionPane.ERROR_MESSAGE);
				//String directory[] = name.list();
				//areaTexto.append("\n\nContenido del directorio:\n");
				//for (int i=0;i<directory.length; i++)
				//	texto+=directory [i]+"\n");
			}
			else {
				JOptionPane.showMessageDialog(null," No existe o la extensi�n es invalida \n"+
												   " Solo archivos .txt",
													" Error ",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public String getText()
	{
		return texto;
	}
	
}