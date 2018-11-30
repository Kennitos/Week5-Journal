package com.example.kenne.journal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private String moodString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        moodString="";
    }

    public void chooseMood(View view){
        ImageView mood = (ImageView) view;
        if (R.id.imageHappy == mood.getId()){
            moodString= "happy";
        }
        else if (R.id.imageSleep == mood.getId()) {
            moodString= "sleepy";
        }
        else if (R.id.imageSick == mood.getId()) {
            moodString= "sick";
        }
        else if (R.id.imageAngry == mood.getId()) {
            moodString= "angry";
        }

        Context context = getApplicationContext();
        CharSequence text = "You're ";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text+moodString+"!", duration);
        toast.show();
    }

    public void addEntry (View view ){
        EditText edittitle = findViewById(R.id.editTitle);
        String title = edittitle.getText().toString();
        if (title.equals("")){
            title = "No title";
        }

        EditText editcontent = findViewById(R.id.editContent);
        String content = editcontent.getText().toString();
        if (content.equals("")){
            content = "No Content";
        }

        if (moodString.equals("")){
            moodString="stoically";
        }

        JournalEntry entry = new JournalEntry(0,title,content,null,moodString);
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert(entry);

        Log.d("newentry","secondactivty "+title+content);




        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("title",title);
//        intent.putExtra("content",content);
        startActivity(intent);
    }
}
