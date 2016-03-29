package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessingThread extends Thread {
	
	private Context context = null;
	private boolean isRunning = true;
	String mesaj="";
	
	 
	  public ProcessingThread(Context context, String mesaj) {
	    this.context = context;
	    for(int i=0;i<mesaj.length();i++)
	    {
	    	mesaj +="*";
	    }
	  }
	 
	  @Override
	  public void run() {
	    Log.d("[ProcessingThread]", "Thread has started!");
	    while (isRunning) {
	      sendMessage();
	      sleep();
	    }
	    Log.d("[ProcessingThread]", "Thread has stopped!");
	  }
	 
	  private void sendMessage() {
	   
		Intent intent = new Intent();
	    intent.putExtra("message", " " + mesaj );
	    context.sendBroadcast(intent);
	  }
	 
	  private void sleep() {
	    try {
	      Thread.sleep(10000);
	    } catch (InterruptedException interruptedException) {
	      interruptedException.printStackTrace();
	    }
	  }
	 
	  public void stopThread() {
	    isRunning = false;
	  }

}
