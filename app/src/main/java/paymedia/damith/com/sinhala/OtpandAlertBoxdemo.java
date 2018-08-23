package paymedia.damith.com.sinhala;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OtpandAlertBoxdemo extends AppCompatActivity {

    public EditText otp1, otp2, otp3, otp4;
    public static final String TAG = "Language";
    public String val1, val2, val3, val4, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_box);

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
//        otp4.setOnKeyListener(new View.OnKeyListener() {
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                int b = otp4.getText().length();
//                Log.d(TAG, "onClick: " + b);
//                if (otp4.getText().length() == 1) {
//                    hideSoftKeyboard(v);
//                    return false;
//                }
//
//                return false;
//            }
//        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void warningColorChange() {
        otp1.setBackgroundResource(R.color.warning_color);
        otp2.setBackgroundResource(R.color.warning_color);
        otp3.setBackgroundResource(R.color.warning_color);
        otp4.setBackgroundResource(R.color.warning_color);
    }

    public void getValue(View view) {

        val1 = otp1.getText().toString();
        val2 = otp2.getText().toString();
        val3 = otp3.getText().toString();
        val4 = otp4.getText().toString();
        if (!(val1.equals("")) && (!val2.equals("")) && (!val3.equals("")) && (!val4.equals(""))) {
            value = val1 + val2 + val3 + val4;
            Toast.makeText(this, "value is : " + value, Toast.LENGTH_SHORT).show();
            showmessgebox("3466", "money", "Rs 900", "Rs 789", "damith");

        } else {
            if (val1.equals("")) {
                otp1.setError("Empty");
                otp1.requestFocus();
                warningColorChange();
                return;
            }
            if (val2.equals("")) {
                otp2.setError("Empty");
                otp2.requestFocus();
                return;
            }
            if (val3.equals("")) {
                otp3.setError("Empty");
                otp3.requestFocus();
                warningColorChange();
                return;
            }
            if (val4.equals("")) {
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

    private void showmessgebox(final String accountRef, final String paymentType, String total, final String amount, String username) {

        total = amount;
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Transaction Confirmation");
        alertDialog.setCanceledOnTouchOutside(false);


        final EditText transactionCodeInput = new EditText(this);
        LayoutInflater inflater = getLayoutInflater();


        final View dialogView = inflater.inflate(R.layout.alert_box_layout, null);
        alertDialog.setView(dialogView);

        final EditText pwd_key1, pwd_key2, pwd_key3, pwd_key4;
        pwd_key1 = dialogView.findViewById(R.id.pwd_key1);
        pwd_key2 = dialogView.findViewById(R.id.pwd_key2);
        pwd_key3 = dialogView.findViewById(R.id.pwd_key3);
        pwd_key4 = dialogView.findViewById(R.id.pwd_key4);

        pwd_key1.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = pwd_key1.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (pwd_key1.getText().length() == 1) {
                    pwd_key2.requestFocus();
                }
                return false;
            }
        });
        pwd_key2.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = pwd_key2.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (pwd_key2.getText().length() == 1) {
                    pwd_key3.requestFocus();
                }
                return false;
            }
        });
        pwd_key3.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = pwd_key3.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (pwd_key3.getText().length() == 1) {
                    pwd_key4.requestFocus();
                }
                return false;
            }
        });
        pwd_key4.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int b = pwd_key4.getText().length();
                Log.d(TAG, "onClick: " + b);
                if (pwd_key4.getText().length() == 1) {
                    hideSoftKeyboard(v);
                }
                return false;
            }
        });


       // final TextView transactionCodeLabel = new TextView(this);
       // transactionCodeLabel.setText("Please enter the transaction PIN to confirm the transaction");


        alertDialog.setTitle("Transaction Confirmation");

        alertDialog.setMessage("Pay " + total + " LKR to " + username + ":" + value + " using ");


        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // showProgress(false);

                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // showProgress(true);
                        //  payBillPayments(transactionCodeInput.getText().toString(), accountRef, paymentType, amount, Api.getAccessToken(getApplicationContext()), intent, false);
                        // Log.d("checkout_activity", " accountRef:" + accountRef + " type:" + paymentType);
//                        if(paymentModel.isTip() ){
//                            String tipamount = tipTextView.getText().toString().replaceAll("[$, LKR]", "");;
//                            if(!tipamount.equals("")&& Double.parseDouble(tipamount)>0.0){
//                                payTransaction(paymentType,tipperId,tipTextView.getText().toString(), Api.getAccessToken(getApplicationContext()),intent,true);
//                                Log.d("tipperid",tipperId);
//                            }
//
//                        }

                        String pwd1 = pwd_key1.getText().toString();
                        String pwd2 = pwd_key2.getText().toString();
                        String pwd3 = pwd_key3.getText().toString();
                        String pwd4 = pwd_key4.getText().toString();

                        final String pws = pwd1 + pwd2 + pwd3 + pwd4;
                        Log.d(TAG, "showmessgebox: pws" + pws);


                        Toast.makeText(getApplicationContext(), "Payment Successful pws " + pws, Toast.LENGTH_LONG).show();

                    }
                });

        alertDialog.show();

    }
    public void changeLanguage(View view){
        startActivity(new Intent(this, sinhalaActivity.class));

    }
}
