package com.example.kenne.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
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

        titleview.setText(title);
        dateview.setText(date);
        moodview.setText(mood);

    }


}
