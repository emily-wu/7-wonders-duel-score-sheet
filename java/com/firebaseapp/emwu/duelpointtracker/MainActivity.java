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
        myPoints = parseInput(R.id.myBlues) + parseInput(R.id.myGreens) + parseInput(R.id.myYellows) + parseInput(R.id.myPurples) + parseInput(R.id.myWonders) + parseInput(R.id.mySciences) + parseInput(R.id.myCoins) + parseInput(R.id.myArmies);

        return myPoints;
    }

    public int addYourPoints() {
        yourPoints = parseInput(R.id.yourBlues) + parseInput(R.id.yourGreens) + parseInput(R.id.yourYellows) + parseInput(R.id.yourPurples) + parseInput(R.id.yourWonders) + parseInput(R.id.yourSciences) + parseInput(R.id.yourCoins) + parseInput(R.id.yourArmies);

        return yourPoints;
    }

    public int parseInput(Integer integer) {
        TextView myView = (TextView) findViewById(integer);
        String myBluesString = myView.getText().toString();
        if (myBluesString.matches("")){
            myBluesString = "0";
        }
        int myInt = Integer.parseInt(myBluesString);
        return myInt;
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
}








