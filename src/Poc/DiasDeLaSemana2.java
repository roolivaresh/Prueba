package Poc;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.Timestamp;





/*
 * La semana parte de jueves a miercoles
petro america
identificar la semana
la tarea debe estar en la misma semana
 * */

public class DiasDeLaSemana2 {
	protected String doIt() throws ParseException
	{
		Calendar hoy = Calendar.getInstance();
        Calendar lunes = Calendar.getInstance();
        Calendar domingo = Calendar.getInstance();
//      hoy.setFirstDayOfWeek(1);
        hoy.set(2022,4-1,13); // Fijamos la fecha para el 9/6/2021 (Calendar utiliza los meses en base a 0 por eso le restamos 1)
        lunes.set(2022,4-1,13);
        domingo.set(2022,4-1,13);

        int diaHoy = hoy.get(Calendar.DAY_OF_WEEK); // 
        if(diaHoy<hoy.getFirstDayOfWeek()+3) {
           diaHoy+=Calendar.SATURDAY;
        }
        lunes.add(Calendar.DATE,hoy.getFirstDayOfWeek()+3 - diaHoy); 
        int ndias =  hoy.getFirstDayOfWeek()+7 + Calendar.TUESDAY-diaHoy-1;  
        domingo.add(Calendar.DATE,ndias); // le sumamos ese dia
                
        System.out.println("Hoy: " + hoy.get(Calendar.DATE)+" " + (hoy.get(Calendar.MONTH)+1) +" "+hoy.get(Calendar.YEAR)); 
        System.out.println("inicio de semana: " + lunes.get(Calendar.DATE)+" " + (lunes.get(Calendar.MONTH)+1) +" "+lunes.get(Calendar.YEAR));
        System.out.println("Ultimo dia de la semana: " + domingo.get(Calendar.DATE)+" " + (domingo.get(Calendar.MONTH)+1) +" "+domingo.get(Calendar.YEAR));   
        
       
        return null;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("inicia calculo");
		DiasDeLaSemana2 dsm = new DiasDeLaSemana2();
		dsm.doIt();
		System.out.println("mensaje de prueba");
	}
	
	

}
