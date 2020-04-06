package de.ledControl.dev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.room.Room;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.ledControl.dev.ColorBottomSheet.colorBottomSheet;
import de.ledControl.dev.Controller.APIControl;
import de.ledControl.dev.Persistence.dao.ledDAO;
import de.ledControl.dev.Persistence.elements.led;
import de.ledControl.dev.Persistence.instantiateDatabase;

public class MainActivity extends AppCompatActivity {

    private ImageButton onoff;
    private boolean ledStatus;
    private int brightness;
    private int color;
    private AppDatabase database;
    private ledDAO ledDAO;
    private APIControl apiControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("On");

        database = new instantiateDatabase().getDatabase(this);
        ledDAO = database.getLedDAO();

        onoff =(ImageButton) findViewById(R.id.testApiButton);
        onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ledStatus = ledDAO.getItemById(1).getStatus();
                active(ledStatus);
            }
        });

        checkFirstLogIn();




        apiControl = new APIControl(this);

        Button changecolor = findViewById(R.id.changecolor);
        changecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorBottomSheet bottomSheet = new colorBottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "colorbottomsheet");
            }
        });



    }

    public void active(Boolean status){
        if(status == false){
            checkFirstLogIn();
            apiControl.callApi("KEY_F1");
            changeActionBar(true);
            ledStatus = true;
        }else{
            apiControl.callApi("KEY_F2");
            changeActionBar(false);
            ledStatus = false;
        }
        //Update status of LED
        led ledcontrol = ledDAO.getItemById(1);
        ledcontrol.setStatus(ledStatus);
        ledDAO.update(ledcontrol);

    }


    private void checkFirstLogIn(){

        led ledControl = new led();

        if(ledDAO.checkIfEmpty() == 0){
            ledControl.setBrightness(15);
            ledControl.setColor(R.color.red);
            ledControl.setStatus(true);
            ledControl.setColorName("red");
            ledDAO.insert(ledControl);
        }else{
            ledStatus = ledDAO.getItemById(1).getStatus();
            brightness = ledDAO.getItemById(1).getBrightness();
            color = ledDAO.getItemById(1).getColor();
            changeActionBar(ledStatus);
        }

    }

    public void setActionBarColor(int color){
        int coloraccent = color;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(coloraccent)));
    }

    public void changeActionBar(Boolean status){
        if(status==true){
            onoff.setColorFilter(ResourcesCompat.getColor(getResources(), R.color.onColor, null));
            Spannable text = new SpannableString("On");
            getSupportActionBar().setTitle(text);
            setActionBarColor(color);
        }else{
            Spannable text = new SpannableString("Off");
            getSupportActionBar().setTitle(text);
            onoff.setColorFilter(ResourcesCompat.getColor(getResources(), R.color.offColor, null));
            setActionBarColor(R.color.offColor);
        }
    }






}
