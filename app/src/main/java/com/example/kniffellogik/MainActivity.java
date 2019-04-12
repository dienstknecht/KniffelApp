package com.example.kniffellogik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int getEiner(){
        TextView v = findViewById(R.id.einer);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getZweier(){
        TextView v = findViewById(R.id.zweier);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getDreier(){
        TextView v = findViewById(R.id.dreier);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getVierer(){
        TextView v = findViewById(R.id.vierer);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getFuenfer(){
        TextView v = findViewById(R.id.fuenfer);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getSechser(){
        TextView v = findViewById(R.id.sechser);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int berechneGesamtObere(){
        return getEiner()+getZweier()+getDreier()+getVierer()+getFuenfer()+getSechser();
    }

    private boolean extraPunkte(){
        return berechneGesamtObere()>=63;
    }

    private int berechneGesamtObereMitExtra(){
        if(extraPunkte()){
            return berechneGesamtObere()+35;
        }
        return berechneGesamtObere();
    }

    private int getDreierpasch(){
        TextView v = findViewById(R.id.dreierpasch);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getViererpasch(){
        TextView v = findViewById(R.id.viererpasch);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getFullHouse(){
        TextView v = findViewById(R.id.fullhouse);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getKleineStrasse(){
        TextView v = findViewById(R.id.kleinestrasse);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getGrosseStrasse(){
        TextView v = findViewById(R.id.grossestrasse);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getKniffel(){
        TextView v = findViewById(R.id.kniffel);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getChance(){
        TextView v = findViewById(R.id.chance);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getGesamtUntere(){
        return getDreierpasch()+getViererpasch()+getFullHouse()+getKleineStrasse()+getGrosseStrasse()+getKniffel()+getChance();
    }

    private int getGesamt(){
        return getGesamtUntere()+berechneGesamtObereMitExtra();
    }
}
