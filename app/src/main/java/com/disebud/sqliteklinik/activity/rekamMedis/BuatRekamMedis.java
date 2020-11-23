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
        text1 = (EditText) findViewById(R.id.et_noPasien); // noDokter
        text2 = (EditText) findViewById(R.id.et_namaPasien); // namaDokter
        text3 = (EditText) findViewById(R.id.et_jk_pasien); // jk
        text4 = (EditText) findViewById(R.id.et_tgl_lahir_pasien); // tglLahir
        text5 = (EditText) findViewById(R.id.et_agama_pasien); // agama
        text6 = (EditText) findViewById(R.id.et_telp_pasien); // telp
        text7 = (EditText) findViewById(R.id.et_alamat_pasien); // alamat
        btn1 = (Button) findViewById(R.id.button_save_pasien);
        btn2 = (Button) findViewById(R.id.button_kembali_pasien);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into pasien (nopasien, namapasien, jk, tgl_lahir, agama,telp,alamat) values('" +
                        Integer.parseInt(text1.getText().toString()) + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "','" +
                        text6.getText().toString() + "','" +
                        text7.getText().toString() + "')");
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