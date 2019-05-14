package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class anasayfa extends AppCompatActivity {
    private String[] aylar={"OCAK","ŞUBAT","MART","NİSAN","MAYIS","HAZİRAN","TEMMUZ","AĞUSTOS","EYLÜL","EKİM","KASIM","ARALIK"};
    private String[] gunler={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] gunler30={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    private String[] gunler28={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
    private String[] saat={" 05:00 - 07:00 "," 07:00 - 09:00 "," 09:00 - 11:00 "," 11:00 - 13:00 "," 13:00 - 15:00 "," 15:00 - 17:00 "," 17:00 - 19:00 "," 19:00 - 21:00 "," 21:00 - 23:00 "," 23:00 - 01:00 "," 01:00 - 03:00 "," 03:00 - 05:00 "};
    private String[] yukselenler={"Koç","Boğa","İkizler","Yengeç","Aslan","Başak","Terazi","Akrep","Yay","Oğlak","Kova","Balık"};
    private String burc="";
    private String yukselen="";
    private String ozellik="";

    private String[] ozellikler={
            "Bir Koç'u tanımlamak o kadar kolay değildir. Keskin ve kararlı bakışlarıyla, hedeflediği konular üzerinde hakimiyet sağlar. O, hızlı gelişen tutkuların insanıdır. Ne yapacağı hiç belli olmaz. Yenilgi kelimesi ile onun adını birlikte söylemeniz nerdeyse imkansızdır.",
            "İşte karşınızda sapasağlam kişilikte bir insan duruyor. Onu olduğu gibi kabul etmek zorundasınız. Kolay öfkelenmeyen Boğalar, canınızı sıkacak hiçbir şey yapmaz, sizin her şeyinizle yakından ilgilenirler ve tüm bunları yaparken asla gocunmazlar.",
            "Nedir, bu İkizler insanının farklı özellikleri. Ona dikkatlice bakarken, size ilginç gelen konuları not etmeye kalkışmayın. Çünkü, asla vaktiniz olmayacaktır. O, değişimleriyle vardır ve böyle olmaktan son derece mutludur. İnanılmaz aktif yapısını çözmeniz için beş duyunuzun yeteceğini sanmıyoruz. Gözlemciliği kuvvetli olmasına rağmen, bir konu üzerinde odanklanmaktan nefret eder.",
            "Bir Yengeç'le karşılaşıncaya kadar, onunla yaşamanın kolay olmadığını anlayamazsınız. Çünkü, o mehtaplı gecelerin ay parlaklığını size hissettirecek ekstra hiçbir şey yapmaz. Girdiğiniz topluluklarda herkes tarzını ortaya koyarken, o geri çekilip ve sıranın kendisinin gelmesini beklerken bile çekiciliğinin farkında değildir. Yaşamda yarışmayı öğrenmemiştir.",
            "Yaşamında yenilgiye tahammül edemeyen başka bir kişiye asla rastlayamazsınız. O gururlu ve vakur haliyle hükmetmeye öylesine alışmış ki, onu asla yönlendiremezsiniz. Sıcak romantik, ateşli aşıklardır. Birlikte olduğu insanın ayaklarını yerden keser. İyi bir konuşmacı olduğu için, güzel aşk sözleri söylemekte üstlerine yoktur.",
            "Başak insanları akıllı ve pratiktir. Eleştirici yönlerine tahammül edemeyeceğinize bilmem söylememe gerek var mı? Fakat, onun can alıcı iltifatları da hiç kimsede yoktur. Sözleri samimi ve içtendir. Işıldayan gözlerini size diktiği zaman etkilenmemeniz mümkün değildir.",
            "Kararsızlıkları ile ünlü cazibe sembolü karşınızda duruyor. Nedenini bilmediğiniz bir çekim gücünün etkisi altına girdiğinizi fark ettiğinizde iş işten çoktan geçmiş olacaktır. Onların büyülü bir havası vardır. Ritmik hareketleri ile dans eder gibi bir yaşam sürer. Onun yanında kızgınlıklarınız yok olur. En sinirli anınızda bile sizi regüle etme yeteneğine sahiptir. ",
            "Sadece gözleriyle konuşan tek insan, Akrep'tir. Bu tutku insanı ile boy ölçüşeceğinizi sanıyorsanız yanılıyorsunuz. İçlerindeki yüksek duygular, onları ihtiraslı ve gizemli yapar. Cinsel duygularını çok yoğun yaşarlar ve aşk yaşantıları bir hayli gizlidir. Kapılarını kolay kolay kimseye açmazlar. İnsanı mıknatıs gibi çeken bakışları vardır. Karşılarındaki kişiyi çok kolay etkileri altına alırlar.",
            "Kavrama yetenekleri gelişmiş olduğundan; ele aldıkları her işte felsefi konularda başarılı olurlar. Yay burcu insanları içtenlikleri ve iyimser yaşam görüşleri ile tanınırlar. Gençliklerinde; dikkatsiz, heyecanlı ve gelenekle aykırı davranışlar içinde olsalar da, geçmiş yanılgılarından en çok ders alan kişiler bu burçtan çıkar.",
            "Geleceği ayrıntılı biçimde planlamaya çalışan Oğlaklar; bu özellikleri nedeniyle sık sık kuruntulara kapılarak depresyona girerler. İşleri ile aşırı meşgul olduklarından, insanlarla zor ilişki kurarlar. Fakat, hiçbir zaman kendilerini yalnız hissetmezler. Oğlaklar ciddilikleri, tutuculukları ve güçlü iradeleri ile tanımlanırlar.",
            "Hayal güçleri sınırsız olmakla birlikte, düşünceleri bulundukları anın ötesinde akılcı ve sezgiseldir. Kovalar dik kafalıdırlar. Kendilerini dinleyenlerin 'ne demek istediğini' anladıklarını sanırlar. Kova burcu insanları sevecen tavırları ile tanınırlar ve bencil değildirler. Irk, cinsiyet ve sosyal durumuna bakmaksızın, herkesin aynı olanaklara sahip olmasını isterler.",
            "Sabır, eli açıklık ve duyarlılık bu burçta doğan kişilerin en önemli nitelikleridir. Büyük bir inandırma yetenekleri vardır. Dürüst, vicdan sahibi, sadık ve uysaldırlar. Her çevreye kolayca uyabilirler. Genellikle hayal dünyasında yaşarlar. Yaşam görüşleri ciddi fakat gerçekçi değildirler. Balıklar, diğer burçlar arasında dış etkenlerden en çok etkilenen kişilerldir."}
            ;

    ArrayList year = new ArrayList();

    private Spinner spinaylar;
    private Spinner spingunler;
    private Spinner spinyil;
    private Spinner spinsaat;

    private ArrayAdapter <String> DataAdapterForAylar;
    private ArrayAdapter <String> DataAdapterForGunler;
    private ArrayAdapter <String> DataAdapterForYil;
    private ArrayAdapter <String> DataAdapterForSaat;

    private Button hesapla;
    private TextView sonuc;
    private Button yksln;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_anasayfa);




        for (int i=1950; i<=2019; i++)
            year.add(i);

        spinaylar = (Spinner) findViewById(R.id.spin_ay);
        spingunler = (Spinner) findViewById(R.id.spin_gun);
        spinyil = (Spinner) findViewById(R.id.spin_yil);
        spinsaat=(Spinner) findViewById(R.id.spin_saat);
        hesapla = (Button) findViewById(R.id.hesap);
        //sonuc = (TextView) findViewById(R.id.sonuc);
        //yksln = (Button) findViewById(R.id.yksln);

        DataAdapterForAylar = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, aylar);
        DataAdapterForGunler = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, gunler);
        DataAdapterForYil = new ArrayAdapter<String >(this,android.R.layout.simple_spinner_item, year);
        DataAdapterForSaat = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, saat);

        DataAdapterForAylar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DataAdapterForGunler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        DataAdapterForYil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinaylar.setAdapter(DataAdapterForAylar);
        spingunler.setAdapter(DataAdapterForGunler);
        spinyil.setAdapter(DataAdapterForYil);
        spinsaat.setAdapter(DataAdapterForSaat);

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
                if (spinaylar.getSelectedItem().toString() == aylar[0] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22 || spinaylar.getSelectedItem().toString() == aylar[1] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 19 ){
               //     Toast.makeText(anasayfa.this,"KOVA BURCU",Toast.LENGTH_LONG).show();
                    burc=("Kova");
                }
                else if (spinaylar.getSelectedItem().toString() == aylar[1] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 20 || spinaylar.getSelectedItem().toString() == aylar[2] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 20 ) {
                //    Toast.makeText(anasayfa.this, "BALIK BURCU", Toast.LENGTH_LONG).show();
                    burc=("Balık");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[2] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 21 || spinaylar.getSelectedItem().toString() == aylar[3] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 20 ) {
                //    Toast.makeText(anasayfa.this, "KOÇ BURCU", Toast.LENGTH_LONG).show();
                    burc=("Koç");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[3] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 21 || spinaylar.getSelectedItem().toString() == aylar[4] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21) {
               //     Toast.makeText(anasayfa.this, "BOĞA BURCU", Toast.LENGTH_LONG).show();
                    burc=("Boğa");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[4] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22 || spinaylar.getSelectedItem().toString() == aylar[5] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22 ) {
                 //   Toast.makeText(anasayfa.this, "İKİZLER BURCU", Toast.LENGTH_LONG).show();
                    burc=("İkizler");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[5] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23 || spinaylar.getSelectedItem().toString() == aylar[6] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22 ){
                //    Toast.makeText(anasayfa.this,"YENGEÇ BURCU",Toast.LENGTH_LONG).show();
                    burc=("Yengeç");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[6] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23 || spinaylar.getSelectedItem().toString() == aylar[7] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22 ){
                  //  Toast.makeText(anasayfa.this,"ASLAN BURCU",Toast.LENGTH_LONG).show();
                    burc=("Aslan");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[7] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23 || spinaylar.getSelectedItem().toString() == aylar[8] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22 ){
                //    Toast.makeText(anasayfa.this,"BAŞAK BURCU",Toast.LENGTH_LONG).show();
                    burc=("Başak");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[8] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23 || spinaylar.getSelectedItem().toString() == aylar[9] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 22){
                 //   Toast.makeText(anasayfa.this,"TERAZİ BURCU",Toast.LENGTH_LONG).show();
                    burc=("Terazi");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[9] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 23 || spinaylar.getSelectedItem().toString() == aylar[10] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21){
                //    Toast.makeText(anasayfa.this,"AKREP BURCU",Toast.LENGTH_LONG).show();
                    burc=("Akrep");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[10] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22 || spinaylar.getSelectedItem().toString() == aylar[11] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21){
                   // Toast.makeText(anasayfa.this,"YAY BURCU",Toast.LENGTH_LONG).show();
                    burc=("Yay");
                }

                else if (spinaylar.getSelectedItem().toString() == aylar[11] && Integer.parseInt(spingunler.getSelectedItem().toString()) >= 22 || spinaylar.getSelectedItem().toString() == aylar[0] && Integer.parseInt(spingunler.getSelectedItem().toString()) <= 21){
               //     Toast.makeText(anasayfa.this,"OĞLAK BURCU",Toast.LENGTH_LONG).show();
                    burc=("Oğlak");
                }



                if (burc=="Koç")
                {
                    ozellik=ozellikler[0];
                }
               else if (burc=="Boğa")
                {
                    ozellik=ozellikler[1];
                }
                else if (burc=="İkizler")
                {
                    ozellik=ozellikler[2];
                }
                else if (burc=="Yengeç")
                {
                    ozellik=ozellikler[3];
                }
                else if (burc=="Aslan")
                {
                    ozellik=ozellikler[4];
                }
                else if (burc=="Başak")
                {
                    ozellik=ozellikler[5];
                }
                else if (burc=="Terazi")
                {
                    ozellik=ozellikler[6];
                }
                else if (burc=="Akrep")
                {
                    ozellik=ozellikler[7];
                }
                else if (burc=="Yay")
                {
                    ozellik=ozellikler[8];
                }
                else if (burc=="Oğlak")
                {
                    ozellik=ozellikler[9];
                }
                else if (burc=="Kova")
                {
                    ozellik=ozellikler[10];
                }
                else if (burc=="Balık")
                {
                    ozellik=ozellikler[11];
                }
               else

                    Toast.makeText(anasayfa.this,"Hatalı Giriş Lütfen Admine Bildirin",Toast.LENGTH_LONG).show();



                for(int i = 0; i < 12; i++){

                    for(int j = 0; j < 12; j++){

                        if ( spinaylar.getSelectedItem().toString() == aylar[i]&& spinsaat.getSelectedItem().equals(saat[j]))
                        {
                            yukselen=yukselenler[j];

                        }
                    }
                }


                Intent newpage = new Intent(anasayfa.this,yukselenhesapla.class);
                newpage.putExtra("burc", burc);
                newpage.putExtra("ozellik", ozellik);
                newpage.putExtra("yukselen", yukselen);
                startActivity(newpage);

            }
        });
        /*yksln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emre = new Intent(anasayfa.this,yukselenhesapla.class);
                startActivity(emre);
                yksln.setVisibility(View.INVISIBLE);
                sonuc.setVisibility(View.INVISIBLE);
            }
        });*/
    }
}
