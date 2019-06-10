package com.cc.paint2D.io;

import com.cc.paint2D.gui.JFrame_Principal;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
//java.awt.image.Raster;

public class Guardar_como_JPG
{		
	public Guardar_como_JPG()
	{
		//JOptionPane.showMessageDialog(null,"�Por favor no olvide colocar la extension del archivo (*.txt)!");
		JFileChooser fileChooser = new JFileChooser();

System.out.println( "System.getProperty(\"user.dir\")"+System.getProperty("user.dir") );
String aux=System.getProperty("user.dir");
	   if(aux.endsWith("bin"))	
       {
       		aux=aux.substring( 0 , aux.length()-"bin".length() );
       		aux+="ARCHIVOS_JPG";
       }
       else
       {
       		aux+="/ARCHIVOS_JPG";
       }
fileChooser.setCurrentDirectory( new File( aux ) );		
		
		
		fileChooser.setFileFilter(new FileFilter()
	   							{	public String getDescription()
	   								{
										return ".jpg";
									}
	
									public boolean accept( File archivo )
									{
									boolean res = false;		
									String nombre = archivo.getName();
		
									if( nombre.endsWith(".jpg") ||archivo.isDirectory()|| archivo.isFile())
									res = true;
		
									return res;
									}
	   							}
	   							);
		
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= fileChooser.showSaveDialog(JFrame_Principal.handle);
		if (result== JFileChooser.CANCEL_OPTION) return;
			
			File name= fileChooser.getSelectedFile();
			try {
////////////////////////////////////////////////////////////////////////////////				
System.out.println("Guardar_como_JPG:------------------------------------------");				
			int width=JFrame_Principal.handle.area_de_dibujo.ancho;
			int height=JFrame_Principal.handle.area_de_dibujo.alto;
System.out.println("width ="+width);
System.out.println("height ="+height);
								
				BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR); 
								
				JFrame_Principal.handle.area_de_dibujo.paint(bi.getGraphics());
								
System.out.println("BufferedImage ="+bi);				
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				JPEGEncodeParam param = JPEGCodec.getDefaultJPEGEncodeParam(bi);
        		param.setQuality(0.99f, true);
        		JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(out, param);
        		enc.encode(bi);
        		
        	//bi.flush();
        														
				byte[] imageBytes = out.toByteArray();
                
                FileOutputStream binFile = new FileOutputStream(name+".jpg");
                binFile.write(imageBytes);
                binFile.close();
                
////////////////////////////////////////////////////////////////////////////////				
				}
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(null,"Error en el archivo","Error",JOptionPane.ERROR_MESSAGE);
			}
	}
		
}