package de.ledControl.dev.Persistence.elements;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "led")
public class led {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @Nullable
    private boolean status;

    @Nullable
    private int color;

    @Nullable
    private String colorName;

    @Nullable
    private int brightness;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
