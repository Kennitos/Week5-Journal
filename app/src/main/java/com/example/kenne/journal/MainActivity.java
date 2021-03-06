package com.example.kenne.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity {

    private EntryDatabase db;
    private EntryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = EntryDatabase.getInstance(getApplicationContext());
        adapter = new EntryAdapter(this,db.selectAll());

        Log.d("countdb",String.valueOf(db.selectAll().getCount()));

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new InnerClassLongClick());
        listView.setOnItemClickListener(new InnerClassClick());

    }

    public void goToSecond (View view ){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private class InnerClassLongClick implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor clickedEntry = (Cursor) adapterView.getItemAtPosition(i);
            Integer id = clickedEntry.getInt(clickedEntry.getColumnIndex("_id"));

            Log.d("longpress","id: "+id);
            EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
            db.delete(id);

            updateData();

            return true;
        }
    }

    private class InnerClassClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor clickedEntry = (Cursor) adapterView.getItemAtPosition(i);

            String title = clickedEntry.getString(clickedEntry.getColumnIndex("title"));
            String content = clickedEntry.getString(clickedEntry.getColumnIndex("content"));
            String mood = clickedEntry.getString(clickedEntry.getColumnIndex("mood"));
            String date = clickedEntry.getString(clickedEntry.getColumnIndex("date"));

            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            intent.putExtra("title",title);
            intent.putExtra("content",content);
            intent.putExtra("mood",mood);
            intent.putExtra("date",date);
            startActivity(intent);
        }
    }

    private void updateData(){
        adapter.swapCursor(db.selectAll());
    }





}
