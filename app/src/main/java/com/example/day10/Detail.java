package com.example.day10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DecimalFormat formatter = new DecimalFormat("#,###.##");

        Intent intent = getIntent();
        String tipe = intent.getStringExtra("tipe");
        String tambahan = intent.getStringExtra("tambahan");
        int hargaTambahan = intent.getIntExtra("hargaTambahan", 0);
        int jumlahJam = intent.getIntExtra("jumlahJam", 0);
        int total = intent.getIntExtra("total", 0);

        TextView txtHargaAwal = findViewById(R.id.tipe);
        txtHargaAwal.setText("Tipe: " + tipe);

        TextView txtHargaTambahan = findViewById(R.id.tambahan);
        txtHargaTambahan.setText(tambahan + ": Rp " +  formatter.format(hargaTambahan));

        TextView txtJumlahJam = findViewById(R.id.waktu);
        txtJumlahJam.setText("Jumlah Jam: " + jumlahJam);

        TextView txtTotal = findViewById(R.id.total);
        txtTotal.setText("Total Harga: Rp " + formatter.format(total));
    }
}