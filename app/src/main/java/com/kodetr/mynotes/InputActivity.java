package com.kodetr.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private MyNotesInterface notesInterface;
    private EditText et_image, et_title, et_desc;
    private Button btn_simpan;
    private boolean TAG = true; // create

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        init();

        intent = getIntent();

        if (intent.getStringExtra("id") != null) {
            et_image.setText(intent.getStringExtra("image"));
            et_title.setText(intent.getStringExtra("title"));
            et_desc.setText(intent.getStringExtra("desc"));

            TAG = false; // update
        } else {
            TAG = true; // create
        }
    }

    private void init() {
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

    private void save() {
        notesInterface = new MyNotesImp(this);

        if(TAG){

            MyNotes myNotes1 = new MyNotes(
                    TextRandom.generateTextRandom(),
                    et_image.getText().toString(),
                    et_title.getText().toString(),
                    et_desc.getText().toString()
            );

            if (notesInterface.create(myNotes1)) {
                Toast.makeText(this, "Berhasil disimpan!", Toast.LENGTH_SHORT).show();
                finish();
            }

        }else{

            MyNotes myNotes2 = new MyNotes(
                    intent.getStringExtra("id"),
                    et_image.getText().toString(),
                    et_title.getText().toString(),
                    et_desc.getText().toString()
            );

            if (notesInterface.update(myNotes2)) {
                Toast.makeText(this, "Berhasil diubah!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

    }
}
