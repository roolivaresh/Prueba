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

public class DiasDeLaSemana {
	protected String doIt() throws ParseException
	{
		
		//Fechas por Parametro
        Timestamp PrimeraFecha = Timestamp.valueOf("2022-12-17 11:09:22.37");
        Timestamp SegundaFecha = Timestamp.valueOf("2022-12-20 11:11:23.57");
        
        // Separamos los datos de la primera fecha
        String SPrimeraFecha = String.valueOf(PrimeraFecha);
		String pano = SPrimeraFecha.substring(0,4);
		int panoo = Integer.parseInt(pano);
		String pmes =  SPrimeraFecha.substring(5,7);
		int pmess = Integer.parseInt(pmes);
		String pdia = SPrimeraFecha.substring(8,10);
		int pdiaa = Integer.parseInt(pdia);
		// si el numero del mes o del día es menor a 10 se le quita el cero 
		//para que se puedan ingrsar en el campo de Calendar
		if(pmess <10) {
			 pmes = SPrimeraFecha.substring(6,7);
			 pmess = Integer.parseInt(pmes);
		}else {
		}
		
		if(pdiaa <10) {
			 pdia = SPrimeraFecha.substring(9,10);
			 pdiaa = Integer.parseInt(pdia);
		}else {
		}
		
        // Separamos los datos de la Segunda fecha
        String SSegundaFecha = String.valueOf(SegundaFecha);
		String sano = SSegundaFecha.substring(0,4);
		int sanoo = Integer.parseInt(sano);
		String smes =  SSegundaFecha.substring(5,7);
		int smess = Integer.parseInt(smes);
		String sdia = SSegundaFecha.substring(8,10);
		int sdiaa = Integer.parseInt(sdia);
		// si el numero del mes o del día es menor a 10 se le quita el cero 
	    //para que se puedan ingrsar en el campo de Calendar
		if(smess <10) {
			 smes = SSegundaFecha.substring(6,7);
			 smess = Integer.parseInt(smes);
		}else {
		}
		
		if(sdiaa <10) {
			 sdia = SSegundaFecha.substring(9,10);
			 sdiaa = Integer.parseInt(sdia);
		}else {		
		}
		
		//se define el incio y el fin de la semana segun la fecha dada por parametro
		Calendar hoy = Calendar.getInstance();
		Calendar otraFecha = Calendar.getInstance();
        Calendar jueves = Calendar.getInstance();
        Calendar miercolesnx = Calendar.getInstance();
        hoy.set(panoo,pmess-1,pdiaa); // Fijamos la fecha para el parametro (Calendar utiliza los meses en base a 0 por eso le restamos 1)
        otraFecha.set(sanoo, smess-1,sdiaa);
        jueves.set(panoo,pmess-1,pdiaa);
        miercolesnx.set(panoo,pmess-1,pdiaa);

        
        int diaHoy = hoy.get(Calendar.DAY_OF_WEEK); // 
        if(diaHoy<hoy.getFirstDayOfWeek()+3) {
           //Si el día es menor al primer día de la semana se asigna el sabado.
           diaHoy+=Calendar.SATURDAY;
        }
        //Calculamos la fecha del Jueves sumando la diferencia entre el numero del dia de semana del Jueves con la de hoy. 
        //Este es un resultado negativo para ir hacia atrás.
        jueves.add(Calendar.DATE,hoy.getFirstDayOfWeek()+3 - diaHoy); 
        //Calculamos la fecha del miercoles de la siguiente semana 
        //sumando la diferencia entre el martes y el dia de hoy
        int ndias =  hoy.getFirstDayOfWeek()+7 + Calendar.TUESDAY-diaHoy-1;  
        miercolesnx.add(Calendar.DATE,ndias); // le sumamos ese dia
        
        
        //se le añade nuevamente el 0 a los días y meses que eran inferior a 10
        String diaJue = "";
        if(jueves.get(Calendar.DATE)< 10) {
        	diaJue = "0"+jueves.get(Calendar.DATE);
        } else {
        	diaJue = String.valueOf(jueves.get(Calendar.DATE));
        } 
        String mesJue = "";
        
        if ((jueves.get(Calendar.MONTH)+1)< 10) {
        	mesJue = "0"+ String.valueOf(jueves.get(Calendar.MONTH)+1);
        }else {
        	mesJue = String.valueOf(jueves.get(Calendar.MONTH)+1);
        }
        
        
        
        String diaMie = "";
        if(miercolesnx.get(Calendar.DATE)< 10) {
        	diaMie = "0"+miercolesnx.get(Calendar.DATE);
        } else {
        	diaMie = String.valueOf(miercolesnx.get(Calendar.DATE));
        } 
        String mesMie = "";
        
        if ((miercolesnx.get(Calendar.MONTH)+1)< 10) {
        	mesMie = "0"+ String.valueOf(miercolesnx.get(Calendar.MONTH)+1);
        }else {
        	mesMie = String.valueOf(miercolesnx.get(Calendar.MONTH)+1);
        }
        
        
        
        String DiaOtra = "";
        if(otraFecha.get(Calendar.DATE)< 10) {
        	DiaOtra = "0"+otraFecha.get(Calendar.DATE);
        } else {
        	DiaOtra = String.valueOf(otraFecha.get(Calendar.DATE));
        } 
        String MesOtra = "";
        if ((otraFecha.get(Calendar.MONTH)+1)< 10) {
        	MesOtra = "0"+ String.valueOf(otraFecha.get(Calendar.MONTH)+1);
        }else {
        	MesOtra = String.valueOf(otraFecha.get(Calendar.MONTH)+1);
        }
        
        
        
        String DiaPrimero = "";
        if(hoy.get(Calendar.DATE)< 10) {
        	DiaPrimero = "0"+hoy.get(Calendar.DATE);
        } else {
        	DiaPrimero = String.valueOf(hoy.get(Calendar.DATE));
        } 
        
        String MesPrimero = "";
        if ((hoy.get(Calendar.MONTH)+1)< 10) {
        	MesPrimero = "0"+ String.valueOf(hoy.get(Calendar.MONTH)+1);
        }else {
        	MesPrimero = String.valueOf(hoy.get(Calendar.MONTH)+1);
        }
        
        //Se juntan día, mes, año de las respectivas fechas
        String InSemana = jueves.get(Calendar.YEAR) +"-" + mesJue +"-"+diaJue +" 10:27:13";
        String FinSemana = miercolesnx.get(Calendar.YEAR) +"-" + mesMie +"-"+diaMie+" 10:27:13";
        String otra = String.valueOf(otraFecha.get(Calendar.YEAR) +"-" + MesOtra +"-"+DiaOtra +" 10:27:13");
        String primeraFecha = String.valueOf(hoy.get(Calendar.YEAR) +"-" +MesPrimero +"-"+DiaPrimero +" 10:27:13");
        
        //Se le da el formato de LocalDate
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate fechaInSemana = LocalDate.parse(InSemana,formateador);
        LocalDate fechaFinSemana = LocalDate.parse(FinSemana,formateador);
        LocalDate fechaOtra = LocalDate.parse(otra,formateador);
        LocalDate fechaprimera = LocalDate.parse(primeraFecha,formateador);
        
        //se hace la validacion correspodiente para que ambas fechas esten en la misma semana.
        if (fechaOtra.compareTo(fechaFinSemana)<= 0  && fechaOtra.compareTo(fechaInSemana)>= 0) {
        	System.out.println("Las fechas estan dentro de la misma semana. ");
        	/*System.out.println("Primera Fecha: " + fechaprimera); 
        	System.out.println("Segunda Fecha: " + fechaOtra) ;
        	System.out.println("inicio de semana: " + fechaInSemana);
            System.out.println("Ultimo dia de la semana: "+fechaFinSemana);*/
            
        } else {
        	System.out.println("Las fechas deben estar dentro de la misma semana, es decir entre: "+fechaInSemana +" y "+fechaFinSemana);
        	System.out.println("Primera Fecha:"+fechaprimera);
        	System.out.println("Segunda Fecha: " + fechaOtra) ;
        }
                
        
       
        return null;
	}// END Doit
	
	public static void main(String[] args) throws Exception {
		System.out.println("mensaje 1");
		DiasDeLaSemana dsm = new DiasDeLaSemana();
		dsm.doIt();
		System.out.println("mensaje de prueba");
	}
	
	

}
