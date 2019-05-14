package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        e1 = (EditText)findViewById(R.id.email);
        e2 = (EditText)findViewById(R.id.pass);
        e3 = (EditText)findViewById(R.id.cpass);
        b1 = (Button)findViewById(R.id.register);
        b2 = (Button)findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Bu alanlar boş geçilemez",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(s2.equals(s3))
                    {
                        Boolean chkemail = db.chkemail(s1);
                        if (chkemail==true)
                        {
                            Boolean insert = db.insert(s1,s2);
                            if (insert==true)
                            {
                                Toast.makeText(getApplicationContext(), "kayıt başarılı", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"E-posta zaten var",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Şifreler Uyuşmuyor.",Toast.LENGTH_LONG).show();
                    }
                }

                b2.setVisibility(View.VISIBLE);

            }
        });
    }
}
