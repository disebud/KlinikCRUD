package com.disebud.sqliteklinik.activity.rekamMedis;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.disebud.sqliteklinik.DataHelper;
import com.disebud.sqliteklinik.R;
import com.disebud.sqliteklinik.activity.pasien.Pasien;


public class BuatRekamMedis extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5, text6, text7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_rekam_medis);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_noRekam); // noRekam
        text2 = (EditText) findViewById(R.id.et_tgl_rekam); // tgl rekam
        text3 = (EditText) findViewById(R.id.et_noPasien_rekam); // no pasien Rekam
        text4 = (EditText) findViewById(R.id.et_noDokter_rekam); // no Dokter Rekam
        text5 = (EditText) findViewById(R.id.et_keluhan_rekam); // Keluhan
        text6 = (EditText) findViewById(R.id.et_diagnosa_rekam); // Diagnosa
        text7 = (EditText) findViewById(R.id.et_biaya_rekam); // biaya
        btn1 = (Button) findViewById(R.id.button_save_rekam);
        btn2 = (Button) findViewById(R.id.button_kembali_rekam);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into rekammedis (norekam, tgl_rekam, nopasien, nodokter, keluhan,diagnosa,biaya) VALUES('" +
                        Integer.parseInt(text1.getText().toString()) + "','" +
                        text2.getText().toString() + "','" +
                        Integer.parseInt(text3.getText().toString()) + "','" +
                        Integer.parseInt(text4.getText().toString()) + "','" +
                        text5.getText().toString() + "','" +
                        text6.getText().toString() + "','" +
                        Integer.parseInt(text7.getText().toString()) + "')");
                Toast.makeText(getApplicationContext(), "Berhasil" ,
                        Toast.LENGTH_LONG).show();
                Pasien.pas.RefreshList();
                finish();
            }
        } );

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                finish();
            }
        } );
    }
}