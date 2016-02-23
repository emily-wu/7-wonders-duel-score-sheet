package com.firebaseapp.emwu.duelpointtracker;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int myPoints = 0;
    int yourPoints = 0;

    public void calculate(View view) {
        displayMyTotal();
        displayYourTotal();

        Toast.makeText(getBaseContext(), toastMessage() , Toast.LENGTH_SHORT ).show();
    }

    public void reset(View view) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    private String toastMessage() {
        String message = "";

        if (myPoints == yourPoints) {
            message = "It's a tie! ";
        }else if (myPoints > yourPoints) {
            message = getMyName() + " Wins!";
        }else {
            message = getYourName() + " Wins!";
        }
        return message;
    }

    private String getMyName() {
        TextView myName = (TextView) findViewById(R.id.myName);
        String mName = myName.getText().toString();
        return mName;
    }

    private String getYourName() {
        TextView yourName = (TextView) findViewById(R.id.yourName);
        String yName = yourName.getText().toString();
        return yName;
    }

    private void displayMyTotal() {
        TextView myTotal = (TextView) findViewById(R.id.myTotal);
        myTotal.setText(String.valueOf(addMyPoints()));
    }

    public void displayYourTotal() {
        TextView yourTotal = (TextView) findViewById(R.id.yourTotal);
        yourTotal.setText(String.valueOf(addYourPoints()));
    }

    public int addMyPoints() {
        TextView myBlues = (TextView) findViewById(R.id.myBlues);
        int mBlues = Integer.parseInt(myBlues.getText().toString());

        TextView myGreens = (TextView) findViewById(R.id.myGreens);
        int mGreens = Integer.parseInt(myGreens.getText().toString());

        TextView myYellows = (TextView) findViewById(R.id.myYellows);
        int mYellows = Integer.parseInt(myYellows.getText().toString());

        TextView myPurples = (TextView) findViewById(R.id.myPurples);
        int mPurples = Integer.parseInt(myPurples.getText().toString());

        TextView myWonders = (TextView) findViewById(R.id.myWonders);
        int mWonders = Integer.parseInt(myWonders.getText().toString());

        TextView mySciences = (TextView) findViewById(R.id.mySciences);
        int mSciences = Integer.parseInt(mySciences.getText().toString());

        TextView myCoins = (TextView) findViewById(R.id.myCoins);
        int mCoins = Integer.parseInt(myCoins.getText().toString());

        TextView myArmies = (TextView) findViewById(R.id.myArmies);
        int mArmies = Integer.parseInt(myArmies.getText().toString());

        myPoints = mBlues + mGreens + mYellows + mPurples + mWonders + mSciences + mCoins + mArmies;

        return myPoints;


    }

    public int addYourPoints() {
        TextView yourBlues = (TextView) findViewById(R.id.yourBlues);
        int yBlues = Integer.parseInt(yourBlues.getText().toString());

        TextView yourGreens = (TextView) findViewById(R.id.yourGreens);
        int yGreens = Integer.parseInt(yourGreens.getText().toString());

        TextView yourYellows = (TextView) findViewById(R.id.yourYellows);
        int yYellows = Integer.parseInt(yourYellows.getText().toString());

        TextView yourPurples = (TextView) findViewById(R.id.yourPurples);
        int yPurples = Integer.parseInt(yourPurples.getText().toString());

        TextView yourWonders = (TextView) findViewById(R.id.yourWonders);
        int yWonders = Integer.parseInt(yourWonders.getText().toString());

        TextView yourSciences = (TextView) findViewById(R.id.yourSciences);
        int ySciences = Integer.parseInt(yourSciences.getText().toString());

        TextView yourCoins = (TextView) findViewById(R.id.yourCoins);
        int yCoins = Integer.parseInt(yourCoins.getText().toString());

        TextView yourArmies = (TextView) findViewById(R.id.yourArmies);
        int yArmies = Integer.parseInt(yourArmies.getText().toString());

        yourPoints = yBlues + yGreens + yYellows + yPurples + yWonders + ySciences + yCoins + yArmies;

        return yourPoints;

    }
}








