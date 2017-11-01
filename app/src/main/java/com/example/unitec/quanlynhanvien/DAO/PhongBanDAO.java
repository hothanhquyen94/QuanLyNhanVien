package com.example.unitec.quanlynhanvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.unitec.quanlynhanvien.DTO.PhongBanDTO;

/**
 * Created by Unitec on 01/11/2017.
 */

public class PhongBanDAO {
    Context context;
    Database databasehelper;
    SQLiteDatabase sqLiteDatabase;

    public PhongBanDAO(Context context){
        this.context = context;
        databasehelper = new Database(context);
    }

    public void themPhongBan(PhongBanDTO phongBanDTO){
        sqLiteDatabase = databasehelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.TenPB_PHONGBAN,phongBanDTO.getTenPhongBan());
        sqLiteDatabase.insert(Database.TABLE_PHONGBAN,null,contentValues);
        sqLiteDatabase.close();
    }
}
