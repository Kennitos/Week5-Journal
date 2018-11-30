package com.example.kenne.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor cursor) {
        super(context,R.layout.entry_row, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        String title = getCursor().getString(cursor.getColumnIndex("title"));
        String date = getCursor().getString(cursor.getColumnIndex("date"));
        String mood = getCursor().getString(cursor.getColumnIndex("mood"));

        TextView titleview = view.findViewById(R.id.titleView);
        TextView dateview = view.findViewById(R.id.dateView);
        TextView moodview = view.findViewById(R.id.moodView);
        ImageView imageview = view.findViewById(R.id.imageView);

        titleview.setText(title);
        dateview.setText(date);
        moodview.setText(mood);

        if(mood!=null){
            switch (mood) {
                case "happy":
                    imageview.setImageResource(R.drawable.happy);
                    break;
                case "sleepy":
                    imageview.setImageResource(R.drawable.sleeping);
                    break;
                case "sick":
                    imageview.setImageResource(R.drawable.sick);
                    break;
                case "angry":
                    imageview.setImageResource(R.drawable.angry);
                    break;
                case "stoically":
                    imageview.setImageResource(R.drawable.stoically);
                    break;
            }
        }
    }
}
