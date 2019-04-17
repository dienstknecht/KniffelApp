package com.example.kniffellogik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
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

    private int countSechsen(int[] wuerfel){
        int count =0;
        for(int i : wuerfel){
            if(i==6){
                count++;
            }
        }
        return count;
    }

    private int countFuenfen(int[] wuerfel){
        int count =0;
        for(int i : wuerfel){
            if(i==5){
                count++;
            }
        }
        return count;
    }

    private int countVieren(int[] wuerfel){
        int count =0;
        for(int i : wuerfel){
            if(i==4){
                count++;
            }
        }
        return count;
    }

    private int countDreien(int[] wuerfel){
        int count =0;
        for(int i : wuerfel){
            if(i==3){
                count++;
            }
        }
        return count;
    }

    private int countZweien(int[] wuerfel){
        int count =0;
        for(int i : wuerfel){
            if(i==2){
                count++;
            }
        }
        return count;
    }

    private int countEinsen(int[] wuerfel){
        int count =0;
        for(int i : wuerfel){
            if(i==1){
                count++;
            }
        }
        return count;
    }

    private boolean isFullHouse(int[] wuerfel){
        boolean drei = false;
        boolean zwei = false;

        if(countSechsen(wuerfel)==3||countFuenfen(wuerfel)==3||countVieren(wuerfel)==3||countDreien(wuerfel)==3||countZweien(wuerfel)==3||countEinsen(wuerfel)==3){
            drei=true;
        }
        if(countSechsen(wuerfel)==2||countFuenfen(wuerfel)==2||countVieren(wuerfel)==2||countDreien(wuerfel)==2||countZweien(wuerfel)==2||countEinsen(wuerfel)==2){
            zwei=true;
        }

        return (zwei&&drei);
    }

    private int isDreierpasch(int[] wuerfel){
        int zahl = 0;
        if(countEinsen(wuerfel)>=3){
            zahl=1;
        }
        if(countZweien(wuerfel)>=3){
            zahl=2;
        }
        if(countDreien(wuerfel)>=3){
            zahl=3;
        }
        if(countVieren(wuerfel)>=3){
            zahl=4;
        }
        if(countFuenfen(wuerfel)>=3){
            zahl=5;
        }
        if(countSechsen(wuerfel)>=3){
            zahl=6;
        }
        return zahl;
    }

    private int isViererpasch(int[] wuerfel){
        int zahl = 0;
        if(countEinsen(wuerfel)>=4){
            zahl=1;
        }
        if(countZweien(wuerfel)>=4){
            zahl=2;
        }
        if(countDreien(wuerfel)>=4){
            zahl=3;
        }
        if(countVieren(wuerfel)>=4){
            zahl=4;
        }
        if(countFuenfen(wuerfel)>=4){
            zahl=5;
        }
        if(countSechsen(wuerfel)>=4){
            zahl=6;
        }
        return zahl;
    }

    private boolean isKleineStrasse(int[] wuerfel){
        if(countEinsen(wuerfel)==1&&countZweien(wuerfel)==1&&countDreien(wuerfel)==1&&countVieren(wuerfel)==1&&countFuenfen(wuerfel)==1){
            return true;
        }
        if(countZweien(wuerfel)==1&&countDreien(wuerfel)==1&&countVieren(wuerfel)==1&&countFuenfen(wuerfel)==1&&countSechsen(wuerfel)==1){
            return true;
        }
        return false;
    }

    private boolean isGrosseStrasse(int[] wuerfel){
        if(countEinsen(wuerfel)==1&&countZweien(wuerfel)==1&&countDreien(wuerfel)==1&&countVieren(wuerfel)==1&&countFuenfen(wuerfel)==1&&countSechsen(wuerfel)==1){
            return true;
        }
        return false;
    }

    private boolean isKniffel(int[] wuerfel){
        if(countSechsen(wuerfel)==5||countFuenfen(wuerfel)==5||countVieren(wuerfel)==5||countDreien(wuerfel)==5||countZweien(wuerfel)==5||countEinsen(wuerfel)==5){
            return true;
        }
        return false;
    }

    private int countChance(int[] wuerfel){
        return countEinsen(wuerfel)+countZweien(wuerfel)*2+countDreien(wuerfel)*3+countVieren(wuerfel)*4+countFuenfen(wuerfel)*5+countSechsen(wuerfel)*6;
    }

    public void berechneMoeglichkeiten(int[] wuerfel){
        zeigeSechsenAn(countSechsen(wuerfel));
        zeigeFuenfenAn(countFuenfen(wuerfel));
        zeigeVierenAn(countVieren(wuerfel));
        zeigeDreienAn(countDreien(wuerfel));
        zeigeZweienAn(countZweien(wuerfel));
        zeigeEinsenAn(countEinsen(wuerfel));

        zeigeFullHouseAn(isFullHouse(wuerfel));
        zeigeDreierpaschAn(isDreierpasch(wuerfel));
        zeigeViererpaschAn(isViererpasch(wuerfel));
        zeigeKleineStrasseAn(isKleineStrasse(wuerfel));
        zeigeGrosseStrassean(isGrosseStrasse(wuerfel));
        zeigeKniffelAn(isKniffel(wuerfel));
        zeigeChanceAn(countChance(wuerfel));
    }

    public void zeigeSechsenAn(int anzahl){
        //erstelle Button mit anzahl * 6 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeFuenfenAn(int anzahl){
        //erstelle Button mit anzahl * 5 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeVierenAn(int anzahl){
        //erstelle Button mit anzahl * 4 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeDreienAn(int anzahl){
        //erstelle Button mit anzahl * 3 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeZweienAn(int anzahl){
        //erstelle Button mit anzahl * 2 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeEinsenAn(int anzahl){
        //erstelle Button mit anzahl * 1 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeFullHouseAn(boolean fullhouse){
        //wenn fullhouse, neuer button mit 25, wenn nicht, kein button
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeDreierpaschAn(int zahl){
        //falls zahl = 0, erstelle keinen neuen button, sonst button mit zahl * 3 erstellen
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeViererpaschAn(int zahl){
        //falls zahl = 0, erstelle keinen neuen button, sonst button mit zahl * 4 erstellen
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeKleineStrasseAn(boolean kleineStrasse){
        //falls true, neuen button mit 30 erstellen, sonst keinen
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeGrosseStrassean(boolean grosseStrasse){
        //falls true, neuen button mit 40 erstellen, sonst keinen
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeKniffelAn(boolean kniffel){
        //falls true, neuen button mit 50 erstellen, sonst keinen
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void zeigeChanceAn(int zahl){
        //erstelle button mit zahl
        //button nur erstellen, wenn textfeld dort leer ist
    }

    public void starteSpielNeu(){
        //setze alle textfelder auf leer
    }

}
