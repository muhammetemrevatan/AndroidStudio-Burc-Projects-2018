package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.*;

public class anasayfa extends AppCompatActivity {
    private String[] aylar={"OCAK","ŞUBAT","MART","NİSAN","MAYIS","HAZİRAN","TEMMUZ","AĞUSTOS","EYLÜL","EKİM","KASIM","ARALIK"};
    private String[] gunler={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] gunler30={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    private String[] gunler28={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
    ArrayList year = new ArrayList();

    private Spinner spinaylar;
    private Spinner spingunler;
    private Spinner spinyil;

    private ArrayAdapter <String> DataAdapterForAylar;
    private ArrayAdapter <String> DataAdapterForGunler;
    private ArrayAdapter <String> DataAdapterForYil;

    private Button hesapla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        for (int i=1950; i<=2019; i++)
            year.add(i);

        spinaylar = (Spinner) findViewById(R.id.spin_ay);
        spingunler = (Spinner) findViewById(R.id.spin_gun);
        spinyil = (Spinner) findViewById(R.id.spin_yil);
        hesapla = (Button) findViewById(R.id.hesap);

        DataAdapterForAylar = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, aylar);
        DataAdapterForGunler = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, gunler);
        DataAdapterForYil = new ArrayAdapter<String >(this,android.R.layout.simple_spinner_item, year);

        DataAdapterForAylar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DataAdapterForGunler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DataAdapterForYil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinaylar.setAdapter(DataAdapterForAylar);
        spingunler.setAdapter(DataAdapterForGunler);
        spinyil.setAdapter(DataAdapterForYil);

        spinaylar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getSelectedItem().toString().equals(aylar[1]))
                    DataAdapterForGunler = new ArrayAdapter<String>(anasayfa.this, android.R.layout.simple_spinner_item,gunler28);
                else if (parent.getSelectedItem().toString().equals(aylar[3]))
                    DataAdapterForGunler = new ArrayAdapter<String>(anasayfa.this, android.R.layout.simple_spinner_item,gunler30);
                else if (parent.getSelectedItem().toString().equals(aylar[5]))
                    DataAdapterForGunler = new ArrayAdapter<String>(anasayfa.this, android.R.layout.simple_spinner_item,gunler30);
                else if (parent.getSelectedItem().toString().equals(aylar[8]))
                    DataAdapterForGunler = new ArrayAdapter<String>(anasayfa.this, android.R.layout.simple_spinner_item,gunler30);
                else if (parent.getSelectedItem().toString().equals(aylar[10]))
                    DataAdapterForGunler = new ArrayAdapter<String>(anasayfa.this, android.R.layout.simple_spinner_item,gunler30);
                else
                    DataAdapterForGunler = new ArrayAdapter<String>(anasayfa.this, android.R.layout.simple_spinner_item,gunler);
                DataAdapterForGunler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spingunler.setAdapter(DataAdapterForGunler);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinaylar.getSelectedItem().toString() == aylar[0] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22)
                    Toast.makeText(anasayfa.this,"KOVA BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[1] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 19)
                    Toast.makeText(anasayfa.this,"KOVA BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[1] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 20)
                    Toast.makeText(anasayfa.this,"BALIK BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[2] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 20)
                    Toast.makeText(anasayfa.this,"BALIK BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[2] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 21)
                    Toast.makeText(anasayfa.this,"KOÇ BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[3] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 20)
                    Toast.makeText(anasayfa.this,"KOÇ BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[3] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 21)
                    Toast.makeText(anasayfa.this,"BOĞA BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[4] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21)
                    Toast.makeText(anasayfa.this,"BOĞA BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[4] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22)
                    Toast.makeText(anasayfa.this,"İKİZLER BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[5] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22)
                    Toast.makeText(anasayfa.this,"İKİZLER BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[5] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23)
                    Toast.makeText(anasayfa.this,"YENGEÇ BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[6] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22)
                    Toast.makeText(anasayfa.this,"YENGEÇ BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[6] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23)
                    Toast.makeText(anasayfa.this,"ASLAN BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[7] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22)
                    Toast.makeText(anasayfa.this,"ASLAN BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[7] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23)
                    Toast.makeText(anasayfa.this,"BAŞAK BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[8] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22)
                    Toast.makeText(anasayfa.this,"BAŞAK BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[8] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23)
                    Toast.makeText(anasayfa.this,"TERAZİ BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[9] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22)
                    Toast.makeText(anasayfa.this,"TERAZİ BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[9] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23)
                    Toast.makeText(anasayfa.this,"AKREP BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[10] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21)
                    Toast.makeText(anasayfa.this,"AKREP BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[10] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22)
                    Toast.makeText(anasayfa.this,"YAY BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[11] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21)
                    Toast.makeText(anasayfa.this,"YAY BURCU",Toast.LENGTH_LONG).show();

                else if (spinaylar.getSelectedItem().toString() == aylar[11] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22)
                    Toast.makeText(anasayfa.this,"OĞLAK BURCU",Toast.LENGTH_LONG).show();
                else if (spinaylar.getSelectedItem().toString() == aylar[0] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21)
                    Toast.makeText(anasayfa.this,"OĞLAK BURCU",Toast.LENGTH_LONG).show();
            }
        });
    }
}
