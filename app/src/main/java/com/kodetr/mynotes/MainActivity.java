package com.kodetr.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterMyNotes.MyNotesOnClikListener{

    private AdapterMyNotes adapterMyNotes;
    private RecyclerView rv_mynotes;
    private List<MyNotes> notesList;
    private MyNotesInterface notesInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        rv_mynotes = (RecyclerView) findViewById(R.id.rv_mynotes);
        rv_mynotes.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InputActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        read();
    }

    private void read(){
        notesList = new ArrayList<>();

        notesInterface = new MyNotesImp(this);

        Cursor cursor = notesInterface.read();

        if(cursor.moveToFirst()){
            do {
                MyNotes notes = new MyNotes(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );

                notesList.add(notes);
            }while (cursor.moveToNext());
        }
        adapterMyNotes = new AdapterMyNotes(this, notesList);
        rv_mynotes.setAdapter(adapterMyNotes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        read();
    }

    @Override
    public void onClick(int posisi) {

        MyNotes notes = notesList.get(posisi);

        String[] pilian = {"Ubah","Hapus"};
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setTitle("Pilihan");

       builder.setItems(pilian, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               if(i == 0){
                   Intent intent = new Intent(MainActivity.this, InputActivity.class);

                   startActivity(intent);
               }else{

               }
           }
       });

       builder.show();

    }
}
