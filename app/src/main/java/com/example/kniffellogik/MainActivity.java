package com.example.kniffellogik;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // variables for shake detection
    private static final float SHAKE_THRESHOLD = 3.25f; // m/S**2
    private static final int MIN_TIME_BETWEEN_SHAKES_MILLISECS = 1000;
    private long mLastShakeTime;
    private SensorManager mSensorMgr;
    private boolean rollItBaby;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int getEiner(){
        TextView v = findViewById(R.id.txEiner);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getZweier(){
        TextView v = findViewById(R.id.txZweier);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getDreier(){
        TextView v = findViewById(R.id.txDreier);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getVierer(){
        TextView v = findViewById(R.id.txVierer);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getFuenfer(){
        TextView v = findViewById(R.id.txFuenfer);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getSechser(){
        TextView v = findViewById(R.id.txSechser);
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
        TextView v = findViewById(R.id.txDreierpasch);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getViererpasch(){
        TextView v = findViewById(R.id.txViererpasch);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getFullHouse(){
        TextView v = findViewById(R.id.txFullHouse);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getKleineStrasse(){
        TextView v = findViewById(R.id.txKleineStrasse);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getGrosseStrasse(){
        TextView v = findViewById(R.id.txGrosseStrasse);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getKniffel(){
        TextView v = findViewById(R.id.txKniffel);
        if(v.getText().equals("")){
            return 0;
        }
        return Integer.parseInt((String)v.getText());
    }

    private int getChance(){
        TextView v = findViewById(R.id.txChance);
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
        if(countEinsen(wuerfel)>=3||countZweien(wuerfel)>=3||countDreien(wuerfel)>=3||countVieren(wuerfel)>=3||countFuenfen(wuerfel)>=3||countSechsen(wuerfel)>=3) {
            zahl=countEinsen(wuerfel)+countZweien(wuerfel)*2+countDreien(wuerfel)*3+countVieren(wuerfel)*4+countFuenfen(wuerfel)*5+countSechsen(wuerfel)*6;

        }
        return zahl;
    }

    private int isViererpasch(int[] wuerfel){
        int zahl = 0;
        if(countEinsen(wuerfel)>=4||countZweien(wuerfel)>=4||countDreien(wuerfel)>=4||countVieren(wuerfel)>=4||countFuenfen(wuerfel)>=4||countSechsen(wuerfel)>=4) {
            zahl=countEinsen(wuerfel)+countZweien(wuerfel)*2+countDreien(wuerfel)*3+countVieren(wuerfel)*4+countFuenfen(wuerfel)*5+countSechsen(wuerfel)*6;

        }
        return zahl;
    }

    private boolean isKleineStrasse(int[] wuerfel){
        if(countEinsen(wuerfel)==1&&countZweien(wuerfel)==1&&countDreien(wuerfel)==1&&countVieren(wuerfel)==1){
            return true;
        }
        if(countZweien(wuerfel)==1&&countDreien(wuerfel)==1&&countVieren(wuerfel)==1&&countFuenfen(wuerfel)==1){
            return true;
        }
        if(countDreien(wuerfel)==1&&countVieren(wuerfel)==1&&countFuenfen(wuerfel)==1&&countSechsen(wuerfel)==1){
            return true;
        }
        return false;
    }

    private boolean isGrosseStrasse(int[] wuerfel){
        if(countEinsen(wuerfel)==1&&countZweien(wuerfel)==1&&countDreien(wuerfel)==1&&countVieren(wuerfel)==1&&countFuenfen(wuerfel)==1){
            return true;
        }
        if(countZweien(wuerfel)==1&&countDreien(wuerfel)==1&&countVieren(wuerfel)==1&&countFuenfen(wuerfel)==1&&countSechsen(wuerfel)==1) {
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
        zeigeGrosseStrasseAn(isGrosseStrasse(wuerfel));
        zeigeKniffelAn(isKniffel(wuerfel));
        zeigeChanceAn(countChance(wuerfel));
    }

    public void zeigeSechsenAn(int anzahl){
        //erstelle Button mit anzahl * 6 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btSechser);
        if(tv.getText().equals("")&&anzahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(anzahl*6));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeFuenfenAn(int anzahl){
        //erstelle Button mit anzahl * 5 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btFuenfer);
        if(tv.getText().equals("")&&anzahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(anzahl*5));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeVierenAn(int anzahl){
        //erstelle Button mit anzahl * 4 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btVierer);
        if(tv.getText().equals("")&&anzahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(anzahl*4));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeDreienAn(int anzahl){
        //erstelle Button mit anzahl * 3 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btDreier);
        if(tv.getText().equals("")&&anzahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(anzahl*3));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeZweienAn(int anzahl){
        //erstelle Button mit anzahl * 2 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btZweier);
        if(tv.getText().equals("")&&anzahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(anzahl*2));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeEinsenAn(int anzahl){
        //erstelle Button mit anzahl * 1 als Anzeige, wenn Anzahl 0, erstelle keinen Button
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btEiner);
        if(tv.getText().equals("")&&anzahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(anzahl));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeFullHouseAn(boolean fullhouse){
        //wenn fullhouse, neuer button mit 25, wenn nicht, kein button
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btFullHouse);
        if(tv.getText().equals("")&&fullhouse){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(25));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeDreierpaschAn(int zahl){
        //falls zahl = 0, erstelle keinen neuen button, sonst button mit zahl * 3 erstellen
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btDreierpasch);
        if(tv.getText().equals("")&&zahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(zahl));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeViererpaschAn(int zahl){
        //falls zahl = 0, erstelle keinen neuen button, sonst button mit zahl * 4 erstellen
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btViererpasch);
        if(tv.getText().equals("")&&zahl!=0){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(zahl));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeKleineStrasseAn(boolean kleineStrasse){
        //falls true, neuen button mit 30 erstellen, sonst keinen
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btKleineStrasse);
        if(tv.getText().equals("")&&kleineStrasse){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(30));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeGrosseStrasseAn(boolean grosseStrasse){
        //falls true, neuen button mit 40 erstellen, sonst keinen
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btGrosseStrasse);
        if(tv.getText().equals("")&&grosseStrasse){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(40));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeKniffelAn(boolean kniffel){
        //falls true, neuen button mit 50 erstellen, sonst keinen
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btKniffel);
        if(tv.getText().equals("")&&kniffel){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(50));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void zeigeChanceAn(int zahl){
        //erstelle button mit zahl
        //button nur erstellen, wenn textfeld dort leer ist
        TextView tv = findViewById(R.id.btChance);
        if(tv.getText().equals("")){
            Button b = new Button(this);//richtig so?
            b.setText(String.valueOf(zahl));
            b.setOnClickListener(this::moeglichkeitsButtonOnClickListener); //wie ohne lambda?
            //button an gridlines befestigen
        }
        //onClickListener von Button auf methode moeglichkeitsButtonOnClickListener()
    }

    public void starteSpielNeu(){
        //setze alle textfelder auf leer
        TextView tv = findViewById(R.id.btEiner);
        tv.setText("");
        tv=findViewById(R.id.btZweier);
        tv.setText("");
        tv=findViewById(R.id.btDreier);
        tv.setText("");
        tv=findViewById(R.id.btVierer);
        tv.setText("");
        tv=findViewById(R.id.btFuenfer);
        tv.setText("");
        tv=findViewById(R.id.btSechser);
        tv.setText("");
        tv=findViewById(R.id.btFullHouse);
        tv.setText("");
        tv=findViewById(R.id.btDreierpasch);
        tv.setText("");
        tv=findViewById(R.id.btViererpasch);
        tv.setText("");
        tv=findViewById(R.id.btKleineStrasse);
        tv.setText("");
        tv=findViewById(R.id.btGrosseStrasse);
        tv.setText("");
        tv=findViewById(R.id.btKniffel);
        tv.setText("");
        tv=findViewById(R.id.btChance);
        tv.setText("");
        //fuer alle Spieler wiederholen
    }

    public void moeglichkeitsButtonOnClickListener(){
        //fuege beim Textfeld an der Stelle des Buttons die Zahl ein, die im Button stand
    }

    public void game(){
        while(true/*spiel noch nicht zuende, vllt einfach mit zaehler implementieren, weil eh immer gleich viele Zuege*/){
            rollItBaby = true;
            int[] wuerfel = diceRoll();//wuerfeln-Methode, vllt auch mehrere Methoden? --> Moritz
            rollItBaby = false;
            berechneMoeglichkeiten(wuerfel);
            //klick auf button und eintragen in textview -> sobald Layout erstellt --> Felix, Jessica
            //wechsle Spieler/Activity --> absprechen, wie genau das funktioniert
        }
    }

    public int[] diceRoll(){
        int[] result = new int[5];
        for(int i= 0; i<5; i++){
            result[i] = (int)((Math.random()) * 6 + 1);
        }
        return result;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (rollItBaby) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                long curTime = System.currentTimeMillis();
                if ((curTime - mLastShakeTime) > MIN_TIME_BETWEEN_SHAKES_MILLISECS) {

                    float x = event.values[0];
                    float y = event.values[1];
                    float z = event.values[2];

                    double acceleration = Math.sqrt(Math.pow(x, 2) +
                            Math.pow(y, 2) +
                            Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;

                    if (acceleration > SHAKE_THRESHOLD) {
                        mLastShakeTime = curTime;
                        diceRoll();
                    }
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Ignore
    }


}

// Shake Detection: https://stackoverflow.com/questions/5271448/how-to-detect-shake-event-with-android -> User Tad