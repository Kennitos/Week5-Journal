package com.example.kenne.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goToThird (View view ){
        EditText edittitle = findViewById(R.id.editTitle);
        String title = edittitle.toString();
        EditText editcontent = findViewById(R.id.editContent);
        String content = editcontent.toString();

        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        startActivity(intent);
    }
}
