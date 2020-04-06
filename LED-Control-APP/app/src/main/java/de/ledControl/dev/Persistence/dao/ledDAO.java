package de.ledControl.dev.Persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import de.ledControl.dev.Persistence.elements.led;

@Dao
public interface ledDAO {
    @Insert
    public void insert(led... items);
    @Update
    public void update(led... items);
    @Delete
    public void delete(led item);

    @Query("SELECT * FROM led")
    public List<led> getLed();

    @Query("SELECT * FROM led WHERE id = :id")
    public led getItemById(int id);

    @Query("SELECT count(*) FROM led")
    public int checkIfEmpty();
}
