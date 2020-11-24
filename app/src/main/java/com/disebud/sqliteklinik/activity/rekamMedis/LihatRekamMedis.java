package com.disebud.sqliteklinik.activity.rekamMedis;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.disebud.sqliteklinik.DataHelper;
import com.disebud.sqliteklinik.R;


public class LihatRekamMedis extends AppCompatActivity {

    protected Cursor cursor,cursor2,cursor3,cursor4;
    DataHelper dbHelper;
    Button btnKembali;
    TextView ned1, ned2, ned3, ned4, ned5, ned6, ned7, ned8, ned9, ned10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_rekam_medis);
        dbHelper = new DataHelper(this);

        ned1 = (TextView) findViewById(R.id.tv_noRekam);
        ned2 = (TextView) findViewById(R.id.tv_tgl_rekam);
        ned3 = (TextView) findViewById(R.id.tv_noPasien_rekam);
        ned4 = (TextView) findViewById(R.id.tv_noDokter_rekam);
        ned5 = (TextView) findViewById(R.id.tv_keluhan_rekam);
        ned6 = (TextView) findViewById(R.id.tv_diagnosa_rekam);
        ned7 = (TextView) findViewById(R.id.tv_biaya_rekam);

        ned8 = (TextView) findViewById(R.id.tv_namaPasien_rekam);
        ned9 = (TextView) findViewById(R.id.tv_namaDokter_rekam);
        ned10 = (TextView) findViewById(R.id.tv_spesialisDokter_rekam);

        btnKembali = (Button) findViewById(R.id.button_kembali_rekam_lihat);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Integer Hasil = Integer.parseInt(getIntent().getStringExtra("noRekam"));
//        cursor = db.rawQuery("SELECT * FROM rekammedis WHERE norekam = " +
//                Hasil + "" , null);
//        cursor.moveToFirst();
//        if (cursor.getCount() > 0) {
//            cursor.moveToPosition(0);
//            ned1.setText(cursor.getString(0).toString());
//            ned2.setText(cursor.getString(1).toString());
//            ned3.setText(cursor.getString(2).toString());
//            ned4.setText(cursor.getString(3).toString());
//            ned5.setText(cursor.getString(4).toString());
//            ned6.setText(cursor.getString(5).toString());
//            ned7.setText(cursor.getString(6).toString());
//        }
//
//        cursor2 = db.rawQuery("SELECT * FROM pasien WHERE nopasien = " + Integer.parseInt(cursor.getString(2).toString()) + "",null);
//        cursor2.moveToFirst();
//        if (cursor2.getCount()>0)
//        {
//            cursor2.moveToPosition(0);
//            ned8.setText(cursor2.getString(1).toString());
//
//        }
//
//        cursor3 = db.rawQuery("SELECT * FROM dokter WHERE nodokter = " + Integer.parseInt(cursor.getString(3).toString()) + "",null);
//        cursor3.moveToFirst();
//        if (cursor3.getCount()>0)
//        {
//            cursor3.moveToPosition(0);
//            ned9.setText(cursor3.getString(1).toString());
//            ned10.setText(cursor3.getString(7).toString());
//
//        }

        cursor4 = db.rawQuery("SELECT norekam,tgl_rekam,pasien.nopasien,pasien.namapasien,dokter.nodokter,dokter.namadokter,keluhan,diagnosa,biaya FROM rekammedis LEFT JOIN pasien ON rekammedis.nopasien = pasien.nopasien LEFT JOIN dokter ON rekammedis.nodokter=dokter.nodokter WHERE norekam ="+ Hasil +"",null);
        cursor4.moveToFirst();
        if (cursor4.getCount()>0)
        {
            cursor4.moveToPosition(0);
            ned1.setText(cursor4.getString(0).toString());
            ned2.setText(cursor4.getString(1).toString());
            ned3.setText(cursor4.getString(2).toString());
            ned8.setText(cursor4.getString(3).toString());

            ned4.setText(cursor4.getString(4).toString());
            ned9.setText(cursor4.getString(5).toString());

            ned5.setText(cursor4.getString(6).toString());
            ned6.setText(cursor4.getString(7).toString());
            ned7.setText(cursor4.getString(8).toString());

        }


        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        } );
    }
}