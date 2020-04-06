package de.ledControl.dev;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import de.ledControl.dev.Persistence.dao.ledDAO;
import de.ledControl.dev.Persistence.elements.led;

@Database(entities = {led.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public abstract ledDAO getLedDAO();

}
