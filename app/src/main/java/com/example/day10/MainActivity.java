package com.example.day10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton ps5, ps4, ps3, psvr, indomie, mieAyam, somay;
    EditText jam;
    String tipe, tambahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ps5 = findViewById(R.id.radioPS5);
        ps4 = findViewById(R.id.radioPS4);
        ps3 = findViewById(R.id.radioPS3);
        psvr = findViewById(R.id.radioPSVR);
        indomie = findViewById(R.id.indomie);
        mieAyam = findViewById(R.id.mieAyam);
        somay = findViewById(R.id.somay);
        jam = findViewById(R.id.waktu);

        Button pesan = findViewById(R.id.btnPesan);

        pesan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPesan){
            int hargaAwal = 0;
            int hargaTambahan = 0;
            if (ps5.isChecked()){
                hargaAwal += 10000;
                tipe = "PS5";
            } else if (ps4.isChecked()) {
                hargaAwal += 8000;
                tipe = "PS4";
            } else if(ps3.isChecked()){
                hargaAwal += 5000;
                tipe = "PS3";
            } else if(psvr.isChecked()){
                hargaAwal += 20000;
                tipe = "PSVR";
            }

            if (indomie.isChecked()){
                hargaTambahan += 7000;
                tambahan = "Indomie";
            } else if (mieAyam.isChecked()){
                hargaTambahan += 10000;
                tambahan = "Mie Ayam";
            } else if (somay.isChecked()) {
                hargaTambahan += 5000;
                tambahan = "Somay";
            }

            int jumlahJam = 0;
            try {
                jumlahJam = Integer.parseInt(jam.getText().toString());
            } catch (NumberFormatException e){
                e.printStackTrace();
            }

            int total = (hargaAwal * jumlahJam) + hargaTambahan;

            Intent intent = new Intent(this, Detail.class);
            intent.putExtra("tipe", tipe);
            intent.putExtra("tambahan", tambahan);
            intent.putExtra("hargaTambahan", hargaTambahan);
            intent.putExtra("jumlahJam", jumlahJam);
            intent.putExtra("total", total);
            startActivity(intent);
        }
    }
}