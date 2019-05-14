package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class yukselenhesapla extends AppCompatActivity {


    private TextView burc,yukselen,ozellik;


    private String[] burclar={"KOÇ BURCU","BOĞA BURCU","İKİZLER BURCU","YENGEÇ BURCU","ASLAN BURCU","BAŞAK BURCU","TERAZİ BURCU","AKREP BURCU","YAY BURCU","OĞLAK BURCU","KOVA BURCU","BALIK BURCU"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yukselenhesapla);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_yukselenhesapla);





        burc = (TextView) findViewById(R.id.burc_tv);
        yukselen = (TextView) findViewById(R.id.yukselen_tv);
        ozellik = (TextView) findViewById(R.id.ozellik_tv);

        burc.setText(getIntent().getExtras().getString("burc"));
        yukselen.setText(getIntent().getExtras().getString("yukselen"));
        ozellik.setText(getIntent().getExtras().getString("ozellik"));












    }
}
