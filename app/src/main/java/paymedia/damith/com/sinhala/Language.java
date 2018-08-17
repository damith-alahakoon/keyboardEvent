package paymedia.damith.com.sinhala;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class Language extends AppCompatActivity {

    private EditText otp1, otp2, otp3, otp4;
    public static final String TAG = "Language";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        otp1.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = otp1.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (otp1.getText().length() == 1) {
                    otp2.requestFocus();
                }
                return false;
            }
        });

        otp2.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = otp2.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (otp2.getText().length() == 1) {
                    otp3.requestFocus();
                }
                return false;
            }
        });
        otp3.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = otp3.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (otp3.getText().length() == 1) {
                    otp4.requestFocus();
                }
                return false;
            }
        });
        otp4.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = otp4.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (otp4.getText().length() == 1) {
                    hideSoftKeyboard(v);
                    return false;
                }

                return false;
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void getValue(View view) {
        String val1, val2, val3, val4, value;
        val1 = otp1.getText().toString();
        val2 = otp2.getText().toString();
        val3 = otp3.getText().toString();
        val4 = otp4.getText().toString();
        if (!(val1.equals("")) && (!val2.equals("")) && (!val3.equals("")) && (!val4.equals(""))) {
            value = val1 + val2 + val3 + val4;
            Toast.makeText(this, "value is : " + value, Toast.LENGTH_SHORT).show();

        } else {
            if(val1.equals("")){
                otp1.setError("Empty");
                otp1.requestFocus();
                return;
            }
            if(val2.equals("")){
                otp2.setError("Empty");
                otp2.requestFocus();
                return;
            }
            if(val3.equals("")){
                otp3.setError("Empty");
                otp3.requestFocus();
                return;
            }
            if(val4.equals("")){
                otp4.setError("Empty");
                otp4.requestFocus();
                return;
            }

            Toast.makeText(this, "OTP not valid", Toast.LENGTH_SHORT).show();
        }


    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

}
