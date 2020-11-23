package com.disebud.sqliteklinik.activity.dokter;

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

public class BuatDokter extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5, text6, text7, text8, text9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_dokter);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_noDokter); // noDokter
        text2 = (EditText) findViewById(R.id.et_namaDokter); // namaDokter
        text3 = (EditText) findViewById(R.id.et_jk); // jk
        text4 = (EditText) findViewById(R.id.et_tgl_lahir); // tglLahir
        text5 = (EditText) findViewById(R.id.et_email); // email
        text6 = (EditText) findViewById(R.id.et_telp); // telp
        text7 = (EditText) findViewById(R.id.et_alamat); // alamat
        text8 = (EditText) findViewById(R.id.et_spesialis); // spesialis
        text9 = (EditText) findViewById(R.id.et_tarif); // tarif
        btn1 = (Button) findViewById(R.id.button_save_dokter);
        btn2 = (Button) findViewById(R.id.button_kembali_dokter);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into dokter(nodokter, namadokter, jk, tgl_lahir, email,telp,alamat,spesialis,tarif) values('" +
                        Integer.parseInt(text1.getText().toString()) + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "','" +
                        text6.getText().toString() + "','" +
                        text7.getText().toString() + "','" +
                        text8.getText().toString() + "','" +
                        Integer.parseInt(text9.getText().toString()) + "')");
                Toast.makeText(getApplicationContext(), "Berhasil" ,
                        Toast.LENGTH_LONG).show();
                Dokter.dok.RefreshList();
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