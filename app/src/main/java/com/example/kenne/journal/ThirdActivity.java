package com.example.kenne.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String date = intent.getStringExtra("date");
        String mood = intent.getStringExtra("mood");

        TextView dtitle = findViewById(R.id.detailsTitle);
        dtitle.setText(title);

        TextView dcontent= findViewById(R.id.detailsContent);
        dcontent.setText(content);

        TextView ddate= findViewById(R.id.detailsTime);
        ddate.setText(date);

        TextView dmood= findViewById(R.id.detailsMood);
        dmood.setText(mood);
    }
}
