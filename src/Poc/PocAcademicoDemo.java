package Poc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;

public class PocAcademicoDemo {
	
	protected String doIt () throws Exception
	{
		String contenido = "";
		String file = "C:\\AdempiereInfo\\Prueba_Texto.txt"; // se carga el archivo
		
		try{
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF8");
			BufferedReader lectura = new BufferedReader (isr);
			
			contenido = lectura.readLine();
			int po_nombre = contenido.indexOf("nombre");
			int po_menor = contenido.indexOf(">");
			int po_apellido = contenido.indexOf("apellido");
			int p_iniciotrabajo = contenido.indexOf("fecha inicio de trabajo");
			
			char[] vector = contenido.toCharArray();
			String po_menor2 = ">";
			String po_mayor2 = "<";
			
			
			for (int i = 0; i<contenido.length();i++) {
				String letra = String.valueOf(vector[i]);
			    
				
				if(po_menor2.equals(letra)) {
					
					//System.out.println(contenido.substring( (po_nombre+7), (i+1)-1));
					//contenido.substring(po_apellido+9,(i+1)) ;
					//System.out.println( "hola"+(i+1));
					//System.out.println("borra"+(i+1));
				}
			}
			
		
			
			//System.out.println(contenido.substring(po_nombre+7, po_menor));
			//System.out.println(contenido.substring(po_apellido+9,po_menor));
			System.out.println(contenido);
			
			//crear archivo
			/*File archivo;
			
			archivo = new File("C:\\AdempiereInfo\\DocumentosSubidos\\Prueba_Texto_Adempiere.txt");
			try {
				if(archivo.createNewFile()) {
					System.out.println("Se creo el archivo correctamente");
				}else {
					System.out.println("El archivo ya existe no se pudo crear.");
				}
			}catch(Exception e){
				
			} */
			
			
			
			//Escritura en archivo
			FileWriter escritura = new FileWriter("D:\\Documentos\\Trabajo\\Java\\clases\\Archivo.txt");
			escritura.write(contenido +"\n");
			
			while( contenido != null){
				
				contenido = lectura.readLine();
				
				String nombre =contenido.substring(9,16);
				String apellido = contenido.substring(27,35);
				String rut = contenido.substring(41,49);
				String digito = contenido.substring(59);
				String Salud = contenido.substring(67,69);
				
				
				escritura.write(contenido +"\n");
				
				if (contenido != null)
				{
					System.out.println(contenido);
				}
				
			}
			
			isr.close();
			fis.close();
			escritura.close();
			lectura.close();
			
			
		} catch(Exception e){
			
		}
		return null;
	
		
	}
	
	public static void main(String[] args) throws Exception {
		PocAcademicoDemo poc= new PocAcademicoDemo();
		poc.doIt();
		
	}
	
}
