package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PracticalTest01Var03MainActivity extends Activity {

	 Button btnPlay;
      EditText tvRiddle;
      EditText tvAnswer;
	
    protected static final int SEND_CODE = 1;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
       
        
        
      
        tvAnswer = (EditText)findViewById(R.id.idAnswer);
        tvRiddle = (EditText)findViewById(R.id.idRiddle);
        btnPlay = (Button) findViewById(R.id.idPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PracticalTest01Var03MainActivity.this, PracticalTest01Var02PlayActivity.class);
				Bundle extras = new Bundle();
				if(!tvRiddle.getText().toString().equals("") && ! tvAnswer.getText().toString().equals(""))
				{
					
				
				extras.putString("riddle", tvRiddle.getText().toString());
				extras.putString("answer", tvAnswer.getText().toString());
				intent.putExtras(extras);
				startActivity(intent);
				}
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var03_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
        Button btnPlay;
        final EditText tvRiddle;
        final EditText tvAnswer;
        
        
      
        tvAnswer = (EditText)findViewById(R.id.idAnswer);
        tvRiddle = (EditText)findViewById(R.id.idRiddle);
        if(savedInstanceState!=null)
        {
        	 String riddle = getIntent().getExtras().getString("riddle");
             String answer = getIntent().getExtras().getString("answer");
             tvRiddle.setText(riddle);
             tvAnswer.setText(answer);
        }
       
    }
}
