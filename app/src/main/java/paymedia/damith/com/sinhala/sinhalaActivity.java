package paymedia.damith.com.sinhala;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import static android.content.Intent.ACTION_SCREEN_OFF;

public class sinhalaActivity extends AppCompatActivity {
    // private Context mContext;
    private Locale mylocale;


    Handler handler;
    Runnable r;
    LogoutService mReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhala);
        String [] selectOption =  {"English","Sinhala","Tamil"};
        Locale mylocale;

        ArrayList<String> array=new ArrayList<>(Arrays.asList(selectOption));

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);



        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,selectOption);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        handler = new Handler();
        r = new Runnable() {

            @Override
            public void run() {

                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),OtpandAlertBoxdemo.class);
                startActivity(intent);
               // log.appendLog("Home Screen","Logout",true);
                finish();

                Toast.makeText(sinhalaActivity.this, "Logged out after 5 minutes on inactivity.",
                        Toast.LENGTH_SHORT).show();
            }
        };


        startHandler();


    }
    @Override
    public void onUserInteraction() {
        // TODO Auto-generated method stub
        super.onUserInteraction();
        stopHandler();//stop first and then start
        startHandler();
    }
    public void stopHandler() {
        handler.removeCallbacks(r);
        Log.d("HandlerRun","stopHandlerMain");
    }

    public void startHandler() {
        handler.postDelayed(r, 1*60*500);
        Log.d("HandlerRun","startHandlerMain");
    }
    @Override
    protected void onPause() {

        if (mReceiver.wasScreenOn) {
            // THIS IS THE CASE WHEN ONPAUSE() IS CALLED BY THE SYSTEM DUE TO A SCREEN STATE CHANGE

        } else {
            // THIS IS WHEN ONPAUSE() IS CALLED WHEN THE SCREEN STATE HAS NOT CHANGED
            stopHandler();
            Log.d("onPause","onPauseActivity change");
        }


        super.onPause();
        try{
            Log.d("error","homeUnregistered");
            unregisterReceiver(mReceiver);
        }catch (Exception e) {
            Log.d("error","homePause");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        startHandler();

        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(ACTION_SCREEN_OFF);
        mReceiver = new LogoutService();
        registerReceiver(mReceiver, filter);

        Log.d("onResume","onResume_restartActivity");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopHandler();
        try{
            unregisterReceiver(mReceiver);
        }catch (Exception e){
            Log.d("erro","exceptionHome");
        }
        Log.d("onDestroy","onDestroyActivity change");

    }
    protected void setLanguage(String language){
        mylocale=new Locale(language);
        Resources resources=getResources();
        DisplayMetrics dm=resources.getDisplayMetrics();
        Configuration conf= resources.getConfiguration();
        conf.locale=mylocale;
        resources.updateConfiguration(conf,dm);
        Intent refreshIntent=new Intent(this,sinhalaActivity.class);
        finish();
        startActivity(refreshIntent);
    }
    public void goHome(View view){
        startActivity(new Intent(this, HomeActivity.class));
    }
}
