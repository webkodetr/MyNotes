package com.kodetr.mynotes;

import android.database.Cursor;

public interface MyNotesInterface {
    public Cursor read();
    public boolean create(MyNotes notes);
    public boolean update(MyNotes notes);
    public boolean delete(String id);
}
