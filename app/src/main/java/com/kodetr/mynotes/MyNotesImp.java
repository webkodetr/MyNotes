package com.kodetr.mynotes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyNotesImp extends SQLiteOpenHelper implements MyNotesInterface {

    public MyNotesImp(Context context) {
        super(context, "db_mynotes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_mynotes (id TEXT,image TEXT, title TEXT, description TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE tbl_mynotes");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM tbl_mynotes", null);
    }

    @Override
    public boolean create(MyNotes notes) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO tbl_mynotes VALUES ('" + notes.getId() + "','" + notes.getImage() + "'," +
                "'" + notes.getTitle() + "','" + notes.getDesc() + "')");
        return true;
    }

    @Override
    public boolean update(MyNotes notes) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE tbl_mynotes SET image='" + notes.getImage() + "', title='" + notes.getTitle() + "'," +
                " description='" + notes.getDesc() + "' WHERE id='" + notes.getId() + "'");
        return true;
    }

    @Override
    public boolean delete(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM tbl_mynotes WHERE id='" + id + "'");
        return true;
    }


}
