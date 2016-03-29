package ro.pub.cs.systems.eim.practicaltest01var03;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var03Service extends Service{

	ProcessingThread thread = null;
	 @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	    String mesaj = intent.getExtras().getString("forService") ;
	    thread = new ProcessingThread(this, mesaj);
	    thread.start();
	    return Service.START_REDELIVER_INTENT;
	  }
	 
	  @Override
	  public IBinder onBind(Intent intent) {
	    return null;
	  }
	 
	  @Override
	  public void onDestroy() {
	    thread.stopThread();
	  }
	
	

}
