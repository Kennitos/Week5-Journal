package com.example.kenne.journal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class EntryDatabase extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table entries (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, mood TEXT, date DATETIME DEFAULT CURRENT_TIMESTAMP)");
        db.execSQL("INSERT INTO entries(title,content,mood) VALUES('title test','content test','happy')");
        db.execSQL("INSERT INTO entries(title,content,mood) VALUES('title test 2','content test 2','happy 2')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "contacts");
        onCreate(db);
    }

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static EntryDatabase instance;

    public static EntryDatabase getInstance(Context context){
        if(instance!=null){
            return instance;
        }
        else {
            instance = new EntryDatabase(context, "entries",null,1);
            return instance;
        }
    }

    public Cursor selectAll(){
        return getWritableDatabase().rawQuery("SELECT * FROM entries", null);
    }

    public void insert(JournalEntry entry){


    }


    public int delete(long id){
        return getWritableDatabase().delete("entries","_id = ?",new String[] {String.valueOf(id)});
    }
}
