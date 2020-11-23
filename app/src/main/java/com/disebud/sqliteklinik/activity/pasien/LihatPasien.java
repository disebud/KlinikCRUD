package com.disebud.sqliteklinik.activity.pasien;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.disebud.sqliteklinik.DataHelper;
import com.disebud.sqliteklinik.R;

public class LihatPasien extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnKembali;
    EditText ned1, ned2, ned3, ned4, ned5, ned6, ned7, ned8, ned9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pasien);
        dbHelper = new DataHelper(this);

        ned1 = (EditText) findViewById(R.id.et_noPasien_lihat);
        ned2 = (EditText) findViewById(R.id.et_namaPasien_lihat);
        ned3 = (EditText) findViewById(R.id.et_jk_pasien_lihat);
        ned4 = (EditText) findViewById(R.id.et_tgl_lahir_pasien_lihat);
        ned5 = (EditText) findViewById(R.id.et_agama_pasien_lihat);
        ned6 = (EditText) findViewById(R.id.et_telp_pasien_lihat);
        ned7 = (EditText) findViewById(R.id.et_alamat_pasien_lihat);

        btnKembali = (Button) findViewById(R.id.button_kembali_pasien_lihat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pasien WHERE namapasien = '" +
                getIntent().getStringExtra("nama") + "'" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            ned1.setText(cursor.getString(0).toString());
            ned2.setText(cursor.getString(1).toString());
            ned3.setText(cursor.getString(2).toString());
            ned4.setText(cursor.getString(3).toString());
            ned5.setText(cursor.getString(4).toString());
            ned6.setText(cursor.getString(5).toString());
            ned7.setText(cursor.getString(6).toString());
        }
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        } );
    }
}