package com.disebud.sqliteklinik.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.View;

import com.disebud.sqliteklinik.R;
import com.disebud.sqliteklinik.activity.dokter.Dokter;
import com.disebud.sqliteklinik.activity.pasien.Pasien;
import com.disebud.sqliteklinik.activity.rekamMedis.RekamMedis;

public class HalamanUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
    }

    public void pasienMove(View view) {
        Intent i =  new Intent(HalamanUtama.this, Pasien.class);
        startActivity(i);
    }

    public void dokterMove(View view) {
        Intent i = new Intent(HalamanUtama.this, Dokter.class);
        startActivity(i);
    }

    public void rekammedisMove(View view) {
        Intent i = new Intent(HalamanUtama.this, RekamMedis.class);
        startActivity(i);
    }
}