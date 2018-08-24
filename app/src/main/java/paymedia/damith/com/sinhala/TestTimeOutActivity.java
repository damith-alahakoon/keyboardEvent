package paymedia.damith.com.sinhala;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TestTimeOutActivity extends AppCompatActivity {
    LogoutTimer mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mReceiver = new LogoutTimer();


    }

    @Override
    public void onUserInteraction() {
        // TODO Auto-generated method stub
        super.onUserInteraction();
        mReceiver.stopHandler();//stop first and then start
        mReceiver.startHandler();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mReceiver.startHandler();
//
//        mReceiver = new LogoutTimer();
//
//        Log.d("onResume", "onResume_restartActivity");
//
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReceiver.stopHandler();
        try {
            unregisterReceiver(mReceiver);
        } catch (Exception e) {
            Log.d("error", "exceptionHome");
        }
        Log.d("onDestroy", "onDestroyActivity change");

    }

    @Override
    protected void onPause() {

        super.onPause();
        try {
            Log.d("erro", "homeUnregistered");
            unregisterReceiver(mReceiver);
        } catch (Exception e) {
            Log.d("erro", "homePause");
        }

    }


}
