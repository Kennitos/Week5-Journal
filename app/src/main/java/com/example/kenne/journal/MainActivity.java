package com.example.kenne.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        EntryAdapter adapter = new EntryAdapter(this,db.selectAll());

        Log.d("countdb",String.valueOf(db.selectAll().getCount()));

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }

    public void goToSecond (View view ){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
