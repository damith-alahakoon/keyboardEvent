package paymedia.damith.com.sinhala;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;



public class LogoutTimer extends BroadcastReceiver  {

    private static String TAG = "LogoutTimer";
    public Handler handler;
    Runnable r;


    @Override
    public void onReceive(final Context context, Intent intent) {

        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {

                // TODO Auto-generated method stub
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                //  context.startActivity(intent);

                 Log.d(TAG, "Logged out after 1 minutes on inactivity.");


                Toast.makeText(context, "Logged out after 1 minutes on inactivity.", Toast.LENGTH_SHORT).show();
            }
        };
        startHandler();
    }
    public void stopHandler() {
        handler.removeCallbacks(r);
        Log.d("HandlerRun","stopHandlerMain");
    }

    public void startHandler() {
        handler.postDelayed(r, 5*60*1000);
        Log.d("HandlerRun","startHandlerMain");
    }


}
