package com.cristhian.camacho.paint2D.io;

import com.cristhian.camacho.paint2D.gui.JFrame_Principal;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Guardar
{		
	public Guardar (String s)
	{
		//JOptionPane.showMessageDialog(null,"�Por favor no olvide colocar la extension del archivo (*.txt)!");
		JFileChooser fileChooser = new JFileChooser();

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
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= fileChooser.showSaveDialog(JFrame_Principal.handle);
		if (result== JFileChooser.CANCEL_OPTION) return;
			File name= fileChooser.getSelectedFile();
			try{
////////////////////////////////////////////////////////////////////////////////
System.out.println("Guardar_como_txt:------------------------------------------");

////////////////////////////////////////////////////////////////////////////////				
				PrintWriter output= new PrintWriter(new FileWriter(name+".txt"));
				output.write(s);
				output.close();
				}
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(null,"Error en el archivo","Error",JOptionPane.ERROR_MESSAGE);
			}
	}
		
}