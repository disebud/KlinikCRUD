package com.disebud.sqliteklinik.activity.rekamMedis;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.disebud.sqliteklinik.DataHelper;
import com.disebud.sqliteklinik.R;
import com.disebud.sqliteklinik.activity.pasien.Pasien;

public class UpdateRekamMedis extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5, text6, text7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rekam_medis);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_noRekam_update); // noDokter
        text2 = (EditText) findViewById(R.id.et_tgl_rekam_update); // namaDokter
        text3 = (EditText) findViewById(R.id.et_noPasien_rekam_update); // jk
        text4 = (EditText) findViewById(R.id.et_noDokter_rekam_update); // tglLahir
        text5 = (EditText) findViewById(R.id.et_keluhan_rekam_update); // email
        text6 = (EditText) findViewById(R.id.et_diagnosa_rekam_update); // telp
        text7 = (EditText) findViewById(R.id.et_biaya_rekam_update); // alamat

        btn1 = (Button) findViewById(R.id.button_save_rekam_update);
        btn2 = (Button) findViewById(R.id.button_kembali_rekam_update);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Integer hasil = Integer.parseInt(getIntent().getStringExtra("noRekam"));
        cursor = db.rawQuery("SELECT * FROM rekammedis WHERE norekam = " +
                hasil + "" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2));
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" update rekammedis set tgl_rekam ='" + text2.getText().toString() + "', " +
                        "nopasien=" + Integer.parseInt(text3.getText().toString()) + ", " +
                        "nodokter=" + Integer.parseInt(text4.getText().toString()) + ", keluhan='" + text5.getText().toString() +
                        "', diagnosa ='" + text6.getText().toString() + "', biaya=" + Integer.parseInt(text7.getText().toString()) +
                        " where norekam =" + Integer.parseInt(text1.getText().toString()) + " ");
                Toast.makeText(getApplicationContext(), "Berhasil" ,
                        Toast.LENGTH_LONG).show();
                RekamMedis.rek.RefreshList();
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