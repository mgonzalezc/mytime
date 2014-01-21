package aplicacion.mytime;

import android.os.Bundle;

import java.util.Calendar;
import java.util.Locale;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.view.LayoutInflater;

/**
 * La clase ShowCalendar muestra la vista calendario.
 * 
 * @author Marina y Daniel
 *
 */
public class ShowCalendar extends MyTimeActivity {
	private static final String formatoFecha = "MMMM yyyy"; 
	private Calendar calendario;
	private int mes, ano;
	private Button seleccionDiaMesAno;
	private Button mesActual;
	private Button celdaCalendario;
	private CalendarAdapter celda;
	
	
	
	/** 
	 * Se llama cuando se crea la actividad por primera vez
	 */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.calendario); // Muestra la vista calendario generada en layout
	        
	        calendario = Calendar.getInstance(Locale.getDefault()); //Crea un calendario con valores por defecto
	        mes = calendario.get(Calendar.MONTH); //Actualiza el mes con el mes actual
	        ano = calendario.get(Calendar.YEAR);  //Actualiza el año con el año actual
	        
	        seleccionDiaMesAno = (Button) this.findViewById(R.id.seleccionarDiaMesFecha); //Busca el botón seleccionDiaMesAno en la vista
            seleccionDiaMesAno.setText("Calendario"); //Escribe el texto en el botón seleccionDiaMesAno
            
            mesActual = (Button) this.findViewById(R.id.mesActual); // Busca el botón mesActual en la vista
            mesActual.setText(DateFormat.format(formatoFecha, calendario.getTime())); //Escribe la fecha en el botón
            
            crearCelda(mes,ano); //Crea una celda adecuada al mes actual.
	    }
	    
	    /**
	     * Permite retroceder a meses anteriores en el calendario
	     * @param v vista del calendario
	     */
	    public void irMesAnterior(View v) {
	    	//Si nos encontramos en enero, se retrocede a diciembre del año anterior
	    	if (mes==0) {
	    		mes=11;
	    		ano = ano-1;
	    	//Si es otro mes, se retrocede al mes anterior
	    	} else  {
	    		mes = mes-1;
	    	}
	    	
	    	//Modifica el texto del botón mesActual según el mes localizado
	    	mesActual = (Button) this.findViewById(R.id.mesActual);
	    	GregorianCalendar cal = new GregorianCalendar(ano, mes, 1);
	        mesActual.setText(DateFormat.format(formatoFecha, cal));
	  
	    	crearCelda(mes,ano); //Actualiza la celda del calendario según el mes en el que estemos
	    }
	    
	    /**
	     * Permite avanzar a meses posteriores en el calendario
	     * @param v vista del calendario
	     */
	    public void irMesSiguiente(View v){
	    	//Si nos encontramos en diciembre, se retrocede a enero del año siguiente
	    	if (mes==11) {
	    		mes=0;
	    		ano = ano+1;
	    	// Si es otro mes, avanza al mes siguiente
	    	} else {
	    		mes = mes+1;
	    	}
	    	
	    	//Modifica el texto del botón mesActual según el mes en el que estemos
	    	mesActual = (Button) this.findViewById(R.id.mesActual);
	    	GregorianCalendar cal = new GregorianCalendar(ano, mes, 1);
	        mesActual.setText(DateFormat.format(formatoFecha, cal));
	        crearCelda(mes,ano); //Actualiza la celda del calendario según el mes en el que estemos
	    }
	    
	    public void crearCelda(int mes, int ano) {
	    	GridView vistaCeldas = (GridView) findViewById(R.id.calendar);
	        celda = new CalendarAdapter(getApplicationContext(), mes, ano);
			celda.notifyDataSetChanged();
			vistaCeldas.setAdapter(celda);
	    }
	  
	    /**
	     * Clase GridCellAdapter
	     * Permite incluir la celda de días en el calendario.
	     * @author Marina y Daniel
	     *
	     */
	    public class CalendarAdapter extends BaseAdapter {
	    	private final Context context;
	    	private final List<String> list;
	    	private final int mes, ano;
	    	private int diaMesActual;
			private int diaSemanaActual;
			private final int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			private int diasEnMesActual;
			private static final int DAY_OFFSET = 1;
	    	
	    	/**
	    	 * Constructor de la clase CalendarAdapter. 
	    	 * @param context
	    	 * @param mes Mes en el que nos encontramos
	    	 * @param ano Año en el que nos encontramos
	    	 */
	    	public CalendarAdapter(Context context, int mes, int ano) {
	    		this.list= new ArrayList<String>(); //Inicializa la List.
	    		this.context = context;
	    		this.mes= mes;
	    		this.ano= ano;	
	    		
	    		Calendar.getInstance();	//Crea un calendario	
				imprimeMes(mes, ano); // Imprime el mes adecuado.
	    	}
	    	
	    	public int getCount() {        
	    		return list.size();    
	    	}    
	    	
	    	public Object getItem(int position) {       
	    		return list.get(position);    
	    	}    
	    	
	    	public long getItemId(int position) {        
	    		return position;    
	    	}
	    	
	    	/**
	    	 * Genera la vista para la celda del calendario
	    	 * @param position
	    	 * @param convertView
	    	 * @param parent
	    	 */
	    	public View getView(int position, View convertView, ViewGroup parent) {
	    		View row = convertView;
	    		
	    		if (row == null) {
		 			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					row = inflater.inflate(R.layout.celda_calendario , parent, false);
				}

	    		// Busca la vista celda_calendario
				celdaCalendario = (Button) row.findViewById(R.id.celda_calendario);
				
	
				String[] DiaYColor = list.get(position).split("-");
				String dia = DiaYColor[0];
							
				// Actualiza la celda del calendario
				celdaCalendario.setText(dia);

				if (DiaYColor[1].equals("GREY")) {
					celdaCalendario.setTextColor(Color.LTGRAY);
				}
				if (DiaYColor[1].equals("WHITE")) {
					celdaCalendario.setTextColor(Color.WHITE);
				}
				
				return row;
	    	}
	    	
	    	private int dameNumeroDiasMes(int i) {
				return diasMes[i];
			}

	    	private void imprimeMes(int mes, int ano) {
				
				int espacios = 0; //Número de espacios libres en la celda que no son del mes actual
				int diasEnMesAnterior = 0;
				int mesAnterior = 0;

				diasEnMesActual = dameNumeroDiasMes(mes);


				// Gregorian Calendar 
				GregorianCalendar cal = new GregorianCalendar(ano, mes, 1);

				if (mes == 11) {
						mesAnterior = mes - 1;
						diasEnMesAnterior = dameNumeroDiasMes(mesAnterior);
				} else if (mes == 0) {
						mesAnterior = 11;
						diasEnMesAnterior = dameNumeroDiasMes(mesAnterior);			
				} else 	{
						mesAnterior = mes - 1;
						diasEnMesAnterior= dameNumeroDiasMes(mesAnterior);
				}

			    espacios = cal.get(Calendar.DAY_OF_WEEK) - 1; //Calcula el día de la semana y, así, el  número de espacios en blanco
				

				//Suma un día a Febrero si el año es bisiesto
				if (cal.isLeapYear(cal.get(Calendar.YEAR)) && mes == 1) {
						++diasEnMesActual;
				}

				// Días del mes anterior
				for (int i = 0; i < espacios; i++) {
						list.add(String.valueOf((diasEnMesAnterior - espacios + DAY_OFFSET) + i) + "-GREY");
				}

				// Días mes actual
				for (int i = 1; i <= diasEnMesActual; i++) {
						list.add(String.valueOf(i) + "-WHITE");
				}

				// Días del mes siguiente
				for (int i = 0; i < list.size() % 7; i++) {
						list.add(String.valueOf(i + 1) + "-GREY");
				}
			}
	    	
	    	public int getCurrentDayOfMonth() 	{
				return diaMesActual;
			}
		    
		    public int getDiaSemanaActual() 	{
				return diaSemanaActual;
			}

	    }
}
