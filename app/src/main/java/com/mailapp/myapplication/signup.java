package com.mailapp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    private EditText un;
    private EditText pw;
    private EditText cp;
    private Button cf;

    private final String CREDENTIAL_SHARED_PREF="our_shared_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        un=findViewById(R.id.un);
        pw=findViewById(R.id.pw);
        cp=findViewById(R.id.cp);
        cf=findViewById(R.id.cf);
        this.setTitle("MAIL APP");

        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPassword=pw.getText().toString();
                String strConfirmPassword=cp.getText().toString();
                String strUsername=un.getText().toString();
                if(strPassword!=null&&strConfirmPassword!=null&&strPassword.equalsIgnoreCase(strConfirmPassword));
                SharedPreferences credentials=getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=credentials.edit();
                editor.putString("Password",strConfirmPassword);
                editor.putString("Username",strUsername);
                editor.commit();

                signup.this.finish();
            }
        });

    }
}