package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends Activity{
	

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_second);
        final TextView tvRiddle;
        final EditText edtAnswerplayer;
        Button btnCheck;
        Button btncancel;
        
        tvRiddle = (TextView)findViewById(R.id.idRiddletv);
        edtAnswerplayer  = (EditText)findViewById(R.id.idAnswerPlayer);
        btnCheck = (Button)findViewById(R.id.Check);
        btncancel = (Button)findViewById(R.id.Cancel);
        final String riddle = getIntent().getExtras().getString("riddle");
        final String answer = getIntent().getExtras().getString("answer");
        tvRiddle.setText(riddle);
        
        Intent intent  = new Intent(PracticalTest01Var02PlayActivity.this, PracticalTest01Var03Service.class);
        intent.putExtra("forService", answer);
        getApplicationContext().startService(intent);
        
        btnCheck.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(edtAnswerplayer.getText().toString().equals(answer))
				{
					Toast.makeText(getApplicationContext(), "S-a introdus acelasi raspuns", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Raspunsurile nu sunt aceleasi", Toast.LENGTH_LONG).show();
				}
			}
		});
        
        btncancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Intent intent = new Intent(PracticalTest01Var02PlayActivity.this, PracticalTest01Var03MainActivity.class);
				Bundle extras = new Bundle();
				
				
				extras.putString("riddle", riddle);
				extras.putString("answer", answer);
				intent.putExtras(extras);
				startActivity(intent);*/
				finish();
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

}
