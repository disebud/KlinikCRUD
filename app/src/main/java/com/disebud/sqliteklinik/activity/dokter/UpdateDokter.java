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

public class UpdateDokter extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5, text6, text7, text8, text9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_dokter);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_noDokter_update); // noDokter
        text2 = (EditText) findViewById(R.id.et_namaDokter_update); // namaDokter
        text3 = (EditText) findViewById(R.id.et_jk_update); // jk
        text4 = (EditText) findViewById(R.id.et_tgl_lahir_update); // tglLahir
        text5 = (EditText) findViewById(R.id.et_email_update); // email
        text6 = (EditText) findViewById(R.id.et_telp_update); // telp
        text7 = (EditText) findViewById(R.id.et_alamat_update); // alamat
        text8 = (EditText) findViewById(R.id.et_spesialis_update); // spesialis
        text9 = (EditText) findViewById(R.id.et_tarif_update); // tarif
        btn1 = (Button) findViewById(R.id.button_save_dokter_update);
        btn2 = (Button) findViewById(R.id.button_kembali_dokter_update);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM dokter WHERE namadokter = '" +
                getIntent().getStringExtra("nama") + "'" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
            text6.setText(cursor.getString(5).toString());
            text7.setText(cursor.getString(6).toString());
            text8.setText(cursor.getString(7).toString());
            text9.setText(cursor.getString(8).toString());
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" update dokter set namadokter ='" + text2.getText().toString() + "', " +
                        "jk='" + text3.getText().toString() +
                        "', tgl_lahir='" + text4.getText().toString() + "', email='" + text5.getText().toString() +
                        "', telp ='" + text6.getText().toString() + "', alamat='" + text7.getText().toString() +
                        "', spesialis='" + text8.getText().toString() + "', tarif=" + Integer.parseInt(text9.getText().toString()) +
                        " where nodokter=" + Integer.parseInt(text1.getText().toString()) + " ");
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