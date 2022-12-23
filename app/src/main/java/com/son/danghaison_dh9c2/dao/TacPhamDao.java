package com.son.danghaison_dh9c2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.son.danghaison_dh9c2.entities.DBHelper;
import com.son.danghaison_dh9c2.entities.TacPham;
import java.util.ArrayList;
import java.util.List;

public class TacPhamDao {
    private final DBHelper csdl;

    public TacPhamDao(Context context){
        csdl=new DBHelper(context);
    }


    // Thêm tp
    public void ThemTP(TacPham tp){
        SQLiteDatabase db=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("maTP", tp.getMaTP());
        values.put("tenTP", tp.getTenTP());
        values.put("nxb", tp.getNxb());
        values.put("soxb", tp.getSoxuatban());
        values.put("soluong", tp.getSoluong());
        values.put("dongia", tp.getDongia());
        db.insert("TacPham",null, values);
        db.close();

    }
    // Sửa thông tin tp
    public void Suatp(TacPham tp){
        SQLiteDatabase db=csdl.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("maTP", tp.getMaTP());
        values.put("tenTP", tp.getTenTP());
        values.put("nxb", tp.getNxb());
        values.put("soxb", tp.getSoxuatban());
        values.put("soluong", tp.getSoluong());
        values.put("dongia", tp.getDongia());
        db.update("TacPham", values, "maTP=?", new String[]{String.valueOf(tp.getMaTP())});
    }
    // Xóa tp;
    public void Xoatp(int id){
        SQLiteDatabase db=csdl.getWritableDatabase();
        db.delete("TacPham","maTP=?",new String[]{String.valueOf(id)});
        db.close();
    }
    // Hiển thị thông tin
    public List<TacPham> ThongTintp(){
        List<TacPham> tpList=new ArrayList<>();
        String sql="SELECT * FROM TacPham";
        SQLiteDatabase db=csdl.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int matp=cursor.getInt(0);
            String tenTP=cursor.getString(1);
            String nxb = cursor.getString(2);
            String sosb=cursor.getString(3);
            String sluong=cursor.getString(4);
            String dongia=cursor.getString(5);
            TacPham tp=new TacPham(matp,tenTP,nxb,sosb,sluong,dongia);
            tpList.add(tp);
            cursor.moveToNext();
        }
        return  tpList;
    }
    // Tìm kiếm
    public List<TacPham> TimKiemtp(String s){
        List<TacPham> tpList=new ArrayList<TacPham>();
        SQLiteDatabase db=csdl.getReadableDatabase();
        String sql="SELECT * FROM TacPham WHERE maTP LIKE '%"+s+"%'OR tenTP LIKE '%"+s+"%' ";
        Cursor cursor=db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int matp=cursor.getInt(0);
            String tenTP=cursor.getString(1);
            String nxb = cursor.getString(2);
            String sosb=cursor.getString(3);
            String sluong=cursor.getString(4);
            String dongia=cursor.getString(5);
            TacPham tp=new TacPham(matp,tenTP,nxb,sosb,sluong,dongia);
            tpList.add(tp);
            cursor.moveToNext();
        }
        return tpList;
    }
}
