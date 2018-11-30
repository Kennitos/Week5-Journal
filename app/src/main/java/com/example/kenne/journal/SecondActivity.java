package com.example.kenne.journal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addEntry (View view ){
        EditText edittitle = findViewById(R.id.editTitle);
        String title = edittitle.getText().toString();
        EditText editcontent = findViewById(R.id.editContent);
        String content = editcontent.getText().toString();

        JournalEntry entry = new JournalEntry(0,title,content,null,"happy");
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert(entry);

        Log.d("newentry","secondactivty "+title+content);




        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("title",title);
//        intent.putExtra("content",content);
        startActivity(intent);
    }
}
