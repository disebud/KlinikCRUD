package com.disebud.sqliteklinik;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_klinik.db" ;
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table pasien(nopasien integer primary key, namapasien text , jk text,tgl_lahir date, agama text,telp text,alamat text)");
        db.execSQL("INSERT INTO pasien (nopasien, namapasien, jk, tgl_lahir, agama,telp,alamat) VALUES (001, 'Disebud', 'L', '1998-02-10','Islam','082218231488','Pekanbaru')");
        db.execSQL("INSERT INTO pasien (nopasien, namapasien, jk, tgl_lahir, agama,telp,alamat) VALUES (002, 'Niyuna', 'P', '2000-10-28','Islam','083830082299','Lampung')");

        db.execSQL("create table rekammedis(norekam integer primary key, tgl_rekam date, nopasien integer,nodokter integer, keluhan text,diagnosa text,biaya integer)");
        db.execSQL("INSERT INTO rekammedis (norekam, tgl_rekam, nopasien, nodokter, keluhan,diagnosa,biaya) VALUES (1000, '2020-11-20', 001, 200,'MCU','TEST',200000)");
        db.execSQL("INSERT INTO rekammedis (norekam, tgl_rekam, nopasien, nodokter, keluhan,diagnosa,biaya) VALUES (1001, '2020-11-21', 002, 201,'DONOR','DARAH',100000)");


        db.execSQL("create table dokter(nodokter integer primary key, namadokter text, jk text,tgl_lahir date, email text, telp text,alamat text,spesialis text,tarif integer)");
        db.execSQL("INSERT INTO dokter (nodokter, namadokter, jk, tgl_lahir, email,telp,alamat,spesialis,tarif) VALUES (200, 'SUGIHARTO', 'L', '1970-10-20','sugiharto@gmail.com','082234501987','BEKASI','GIGI',200000)");
        db.execSQL("INSERT INTO dokter (nodokter, namadokter, jk, tgl_lahir, email,telp,alamat,spesialis,tarif) VALUES (201, 'SUHARTINI', 'P', '1971-10-20','suhartini@gmail.com','082234501980','BEKASI','KULIT',100000)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE pasien");
        db.execSQL("DROP TABLE rekammedis");
        db.execSQL("DROP TABLE dokter");
        onCreate(db);
    }
}
