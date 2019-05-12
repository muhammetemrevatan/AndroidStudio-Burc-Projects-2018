package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button3);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emre = new Intent(Login.this,MainActivity.class);
                startActivity(emre);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,password);
                if (Chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "Başarıyla giriş yaptınız.", Toast.LENGTH_LONG).show();
                    Intent veli = new Intent(Login.this,anasayfa.class);
                    startActivity(veli);
                }


                else
                    Toast.makeText(getApplicationContext(),"Giriş Başarosız Lütfen Kayıt olun",Toast.LENGTH_LONG).show();



            }
        });

    }
}
