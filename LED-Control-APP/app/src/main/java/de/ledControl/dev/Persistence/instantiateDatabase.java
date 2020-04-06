package de.ledControl.dev.Persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import de.ledControl.dev.AppDatabase;

public class instantiateDatabase {
    public AppDatabase getDatabase(Context context){
        return Room.databaseBuilder(context, AppDatabase .class, "mydb")
                .allowMainThreadQueries()
                .build();

    }

}
