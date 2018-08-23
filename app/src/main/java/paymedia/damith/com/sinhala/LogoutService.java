package paymedia.damith.com.sinhala;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LogoutService extends BroadcastReceiver {
    public boolean wasScreenOn;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            // DO WHATEVER YOU NEED TO DO HERE

            wasScreenOn = true;
            Log.d("LogoutServiceScreen","screenOff");

            Intent loginIntent = new Intent(context,OtpandAlertBoxdemo.class);
            context.startActivity(loginIntent);
            //finish();
            Log.d("onPause","onPauseScreenOff");

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // AND DO WHATEVER YOU NEED TO DO HERE

            wasScreenOn = false;
            Log.d("LogoutServiceScreen","screenOn");
        }
    }
}
