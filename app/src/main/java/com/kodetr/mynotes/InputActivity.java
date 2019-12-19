package com.kodetr.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private MyNotesInterface notesInterface;
    private EditText et_image, et_title, et_desc;
    private Button btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        init();

    }

    private void init(){
        et_image = (EditText) findViewById(R.id.et_image);
        et_title = (EditText) findViewById(R.id.et_title);
        et_desc = (EditText) findViewById(R.id.et_desc);
        btn_simpan = (Button) findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    private void save(){
        notesInterface = new MyNotesImp(this);

        MyNotes myNotes = new MyNotes(
                TextRandom.generateTextRandom(),
                et_image.getText().toString(),
                et_title.getText().toString(),
                et_desc.getText().toString()
        );

        if(notesInterface.create(myNotes)){
            Toast.makeText(this, "Berhasil disimpan", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
