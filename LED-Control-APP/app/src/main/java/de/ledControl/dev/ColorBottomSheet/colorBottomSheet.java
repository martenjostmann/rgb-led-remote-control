package de.ledControl.dev.ColorBottomSheet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.ledControl.dev.AppDatabase;
import de.ledControl.dev.Controller.APIControl;
import de.ledControl.dev.MainActivity;
import de.ledControl.dev.Persistence.dao.ledDAO;
import de.ledControl.dev.Persistence.elements.led;
import de.ledControl.dev.Persistence.instantiateDatabase;
import de.ledControl.dev.R;

public class colorBottomSheet extends BottomSheetDialogFragment {

    private ColorBottomSheetViewModel mViewModel;
    private AppDatabase database;
    private de.ledControl.dev.Persistence.dao.ledDAO ledDAO;
    private LinearLayout linearLayout;
    private FloatingActionButton red;
    private FloatingActionButton green;
    private FloatingActionButton blue;
    private FloatingActionButton white;
    private FloatingActionButton orange1;
    private FloatingActionButton orange2;
    private FloatingActionButton yellow1;
    private FloatingActionButton yellow2;
    private FloatingActionButton green2;
    private FloatingActionButton turquoise;
    private FloatingActionButton lightblue1;
    private FloatingActionButton lightblue2;
    private FloatingActionButton lightblue3;
    private FloatingActionButton purple1;
    private FloatingActionButton purple2;
    private FloatingActionButton pink;
    private FloatingActionButton currentSelected;
    private led ledcontrol;
    private APIControl apiControl;
    public static colorBottomSheet newInstance() {
        return new colorBottomSheet();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.colorbottomsheet, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ColorBottomSheetViewModel.class);

        database = new instantiateDatabase().getDatabase(getContext());
        ledDAO = database.getLedDAO();
        ledcontrol = ledDAO.getItemById(1);

        currentSelected = red;
        linearLayout = (LinearLayout) getView().findViewById(R.id.txt_headline);
        inititialState(ledcontrol.getColorName(),ledcontrol.getColor());

        apiControl = new APIControl(getContext());



        final TextView colorText = getView().findViewById(R.id.colortext);

        red = (FloatingActionButton) getView().findViewById(R.id.red);
        green = (FloatingActionButton) getView().findViewById(R.id.green);
        blue = (FloatingActionButton) getView().findViewById(R.id.blue);
        white = (FloatingActionButton) getView().findViewById(R.id.white);
        orange1 = (FloatingActionButton) getView().findViewById(R.id.orange1);
        orange2 = (FloatingActionButton) getView().findViewById(R.id.orange2);
        yellow1 = (FloatingActionButton) getView().findViewById(R.id.yellow1);
        yellow2 = (FloatingActionButton) getView().findViewById(R.id.yellow2);
        green2 = (FloatingActionButton) getView().findViewById(R.id.green2);
        turquoise = (FloatingActionButton) getView().findViewById(R.id.turquoise);
        lightblue1 = (FloatingActionButton) getView().findViewById(R.id.lightblue1);
        lightblue2 = (FloatingActionButton) getView().findViewById(R.id.lightblue2);
        lightblue3 = (FloatingActionButton) getView().findViewById(R.id.lightblue3);
        purple1 = (FloatingActionButton) getView().findViewById(R.id.purple1);
        purple2 = (FloatingActionButton) getView().findViewById(R.id.purple2);
        pink = (FloatingActionButton) getView().findViewById(R.id.pink);


        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.red, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(red);
                ledcontrol.setColor(R.color.red);
                ledcontrol.setColorName("red");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.red)));
                setStatus();
                apiControl.callApi("KEY_F3");
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.green, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(green);
                ledcontrol.setColor(R.color.green);
                ledcontrol.setColorName("green");
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.green)));
                setStatus();
                ledDAO.update(ledcontrol);

                apiControl.callApi("KEY_F4");
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.blue, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(blue);
                ledcontrol.setColor(R.color.blue);
                ledcontrol.setColorName("blue");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.blue)));
                setStatus();
                apiControl.callApi("KEY_F5");
            }
        });

        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
                colorText.setTextColor(Color.BLACK);
                currentSelected.setImageResource(0);
                setCheck(white);
                ledcontrol.setColor(R.color.white);
                ledcontrol.setColorName("white");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.white)));
                setStatus();
                apiControl.callApi("KEY_F6");
            }
        });

        orange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.orange1, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(orange1);
                ledcontrol.setColor(R.color.orange1);
                ledcontrol.setColorName("orange1");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.orange1)));
                setStatus();
                apiControl.callApi("KEY_F7");
            }
        });

        orange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.orange2, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(orange2);
                ledcontrol.setColor(R.color.orange2);
                ledcontrol.setColorName("orange2");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.orange2)));
                setStatus();
                apiControl.callApi("KEY_F8");
            }
        });

        yellow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.yellow1, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(yellow1);
                ledcontrol.setColor(R.color.yellow1);
                ledcontrol.setColorName("yellow1");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.yellow1)));
                setStatus();
                apiControl.callApi("KEY_F9");
            }
        });

        yellow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.yellow2, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(yellow2);
                ledcontrol.setColor(R.color.yellow2);
                ledcontrol.setColorName("yellow2");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.yellow2)));
                setStatus();
                apiControl.callApi("KEY_F10");
            }
        });

        green2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.green2, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(green2);
                ledcontrol.setColor(R.color.green2);
                ledcontrol.setColorName("green2");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.green2)));
                setStatus();
                apiControl.callApi("KEY_F11");
            }
        });

        turquoise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.turquoise, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(turquoise);
                ledcontrol.setColor(R.color.turquoise);
                ledcontrol.setColorName("turquoise");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.turquoise)));
                setStatus();
                apiControl.callApi("KEY_F12");
            }
        });

        lightblue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.lightblue1, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(lightblue1);
                ledcontrol.setColor(R.color.lightblue1);
                ledcontrol.setColorName("lightblue1");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.lightblue1)));
                setStatus();
                apiControl.callApi("KEY_F13");
            }
        });

        lightblue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.lightblue2, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(lightblue2);
                ledcontrol.setColor(R.color.lightblue2);
                ledcontrol.setColorName("lightblue2");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.lightblue2)));
                setStatus();
                apiControl.callApi("KEY_F14");
            }
        });

        lightblue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.lightblue3, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(lightblue3);
                ledcontrol.setColor(R.color.lightblue3);
                ledcontrol.setColorName("lightblue3");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.lightblue3)));
                setStatus();
                apiControl.callApi("KEY_F15");
            }
        });

        purple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.purple1, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(purple1);
                ledcontrol.setColor(R.color.purple1);
                ledcontrol.setColorName("purple1");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.purple1)));
                setStatus();
                apiControl.callApi("KEY_F16");
            }
        });

        purple2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.purple2, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(purple2);
                ledcontrol.setColor(R.color.purple2);
                ledcontrol.setColorName("purple2");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.purple1)));
                setStatus();
                apiControl.callApi("KEY_F17");
            }
        });

        pink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.pink, null));
                colorText.setTextColor(Color.WHITE);
                currentSelected.setImageResource(0);
                setCheck(pink);
                ledcontrol.setColor(R.color.pink);
                ledcontrol.setColorName("pink");
                ledDAO.update(ledcontrol);
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                        .getColor(R.color.pink)));
                setStatus();
                apiControl.callApi("KEY_F18");
            }
        });

    }

    private void setCheck(FloatingActionButton currentSelected){
        this.currentSelected = currentSelected;
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(getContext(), R.drawable.ic_check);
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(currentSelected == white){
            DrawableCompat.setTint(wrappedDrawable, Color.BLACK);
            Spannable text = new SpannableString((actionBar.getTitle()));
            text.setSpan(new ForegroundColorSpan(Color.BLACK), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            actionBar.setTitle(text);
        }else{
            DrawableCompat.setTint(wrappedDrawable, Color.WHITE);
            Spannable text = new SpannableString((actionBar.getTitle()));
            text.setSpan(new ForegroundColorSpan(Color.WHITE), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            actionBar.setTitle(text);
        }
        currentSelected.setImageResource(R.drawable.ic_check);

    }

    private void setStatus(){
        apiControl.callApi("KEY_F1");
        ledcontrol.setStatus(true);
        ledDAO.update(ledcontrol);
        ((MainActivity)getActivity()).active(false);
    }

    public void inititialState(String colorname, int color){
        int resID = getResources().getIdentifier(colorname, "id", getActivity().getPackageName());
        setCheck((FloatingActionButton) getView().findViewById(resID));
        linearLayout.setBackgroundColor(ResourcesCompat.getColor(getResources(), color, null));
    }

}
