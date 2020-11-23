package com.disebud.sqliteklinik.activity.dokter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.disebud.sqliteklinik.DataHelper;
import com.disebud.sqliteklinik.R;

public class Dokter extends AppCompatActivity {

    public static Dokter dok;
    protected Cursor cursor;
    String[] daftar;
    ListView ListView01;
    Button btn;
    Menu menu;
    DataHelper dbcenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);
        btn=(Button)findViewById(R.id.buttonDokter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte = new Intent(Dokter.this, BuatDokter.class);
                startActivity(inte);
            }
        } );
        dok = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM dokter" ,null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView)findViewById(R.id.listViewDokter);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = { "Lihat Data" , "Update Data" , "Hapus Data"} ;
                AlertDialog.Builder builder = new AlertDialog.Builder(Dokter.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item) {
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), LihatDokter.class);
                                i.putExtra("nama" , selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdateDokter.class);
                                in.putExtra("nama" , selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("Delete from dokter where namadokter = '" +selection+ "'");
                                Toast.makeText(getApplicationContext(), "Data "+selection+" Berhasil Dihapus" ,
                                        Toast.LENGTH_LONG).show();
                                RefreshList();
                                break;
                        }
                    }
                } );
                builder.create().show();
            }
        } );
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}

