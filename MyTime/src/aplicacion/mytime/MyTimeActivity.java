package aplicacion.mytime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyTimeActivity extends Activity {
	   
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);						
    }
	
	public void showCal(View v) {
		Intent intent = new Intent(MyTimeActivity.this, ShowCalendar.class);
		startActivity(intent);
    }
	
	public void showEv(View v) {
		Intent intent = new Intent(MyTimeActivity.this, ShowEvent.class);
		startActivity(intent);
	}
	
	public void newEv(View v) {
		Intent intent = new Intent(MyTimeActivity.this, NewEvent.class);
		startActivity(intent);
	}
}