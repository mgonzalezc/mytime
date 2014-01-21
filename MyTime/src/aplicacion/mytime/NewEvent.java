package aplicacion.mytime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class NewEvent extends Activity {

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.nuevo);
	}
	
	public void examenForm(View v) {
		View showElements[] = new View[]{
		     (TextView) findViewById(R.id.course_form),			  // TextView asociado a la materia
		     (EditText) findViewById(R.id.courseText),			  // Cuadro de texto asociado a la materia
		     (TextView) findViewById(R.id.kind_form),			  // TextView asociado al tipo de evento
		     (RadioGroup) findViewById(R.id.kindEx_radioGroup),   // Opciones específicas de exámenes.
		     (TextView) findViewById(R.id.ini_form),			  // TextView asociado a la hora de inicio.
		     (TimePicker) findViewById(R.id.iniTime)			  // Reloj para marcar la hora de inicio.
		};
		
		View hideElements[] = new View[]{
			 (RadioGroup) findViewById(R.id.kindEnt_radioGroup),  // Opciones específicas de entregas.
			 (RadioGroup) findViewById(R.id.kindTra_radioGroup),  // Opciones específicas de trabajos.
			 (TextView) findViewById(R.id.fin_form),			  // TextView asociado a la fecha límite.
			 (DatePicker) findViewById(R.id.dateTime)			  // Reloj para marcar la fecha límite.
		};
		
		for (View val: showElements){							  // Mostramos los elementos correspondientes
			val.setVisibility(View.VISIBLE);					  // a la vista de exámenes.
		}
		
		for(View val: hideElements){							  // Ocultamos los elementos que no corresponden
			val.setVisibility(View.GONE);						  // a esta vista.
		}
	}
	
	public void entregaForm(View v) {
		View showElements[] = new View[]{
			(TextView) findViewById(R.id.course_form),			  // TextView asociado a la materia
			(EditText) findViewById(R.id.courseText),			  // Cuadro de texto asociado a la materia
			(TextView) findViewById(R.id.kind_form),			  // TextView asociado al tipo de evento
			(RadioGroup) findViewById(R.id.kindEnt_radioGroup),   // Opciones específicas de entregas.
			(TextView) findViewById(R.id.fin_form),			      // TextView asociado a la fecha límite.
			(DatePicker) findViewById(R.id.dateTime)			  // Reloj para marcar la fecha límite.
		};
		
		View hideElements[] = new View[]{
			(RadioGroup) findViewById(R.id.kindEx_radioGroup),    // Opciones específicas de entregas.
			(RadioGroup) findViewById(R.id.kindTra_radioGroup),   // Opciones específicas de trabajos.
			(TextView) findViewById(R.id.ini_form),			      // TextView asociado a la fecha límite.
			(TimePicker) findViewById(R.id.iniTime)			      // Reloj para marcar la fecha límite.
		};
			
		for (View val: showElements){							  // Mostramos los elementos correspondientes
			val.setVisibility(View.VISIBLE);					  // a la vista de exámenes.
		}
		
		for(View val: hideElements){							  // Ocultamos los elementos que no corresponden
			val.setVisibility(View.GONE);						  // a esta vista.
		}
	}
	
	public void trabajoForm(View v) {
		View showElements[] = new View[]{
			(TextView) findViewById(R.id.course_form),			  // TextView asociado a la materia
			(EditText) findViewById(R.id.courseText),			  // Cuadro de texto asociado a la materia
			(TextView) findViewById(R.id.kind_form),			  // TextView asociado al tipo de evento
			(RadioGroup) findViewById(R.id.kindTra_radioGroup),   // Opciones específicas de trabajos.
			(TextView) findViewById(R.id.fin_form),			      // TextView asociado a la fecha límite.
			(DatePicker) findViewById(R.id.dateTime)			  // Reloj para marcar la fecha límite.
		};
		
		View hideElements[] = new View[]{
			(RadioGroup) findViewById(R.id.kindEx_radioGroup),    // Opciones específicas de entregas.
			(RadioGroup) findViewById(R.id.kindEnt_radioGroup),   // Opciones específicas de trabajos.
			(TextView) findViewById(R.id.ini_form),			      // TextView asociado a la fecha límite.
			(TimePicker) findViewById(R.id.iniTime)			      // Reloj para marcar la fecha límite.
		};
			
		for (View val: showElements){							  // Mostramos los elementos correspondientes
			val.setVisibility(View.VISIBLE);					  // a la vista de exámenes.
		}
		
		for(View val: hideElements){							  // Ocultamos los elementos que no corresponden
			val.setVisibility(View.GONE);						  // a esta vista.
		}
	}
}