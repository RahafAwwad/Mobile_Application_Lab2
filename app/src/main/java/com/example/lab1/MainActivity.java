package com.example.lab1;

import android.app.*;
//import android.support.v7.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {
    private int points;
    private int n1;
    private int n2;

    public void clickButton1(View view) {
        check(n1, n2);
    }

    public void clickButton2(View view) {
        check(n2, n1);
    }

    private void check(int nu1, int nu2) {
        if (nu1 > nu2) {
            points++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            points--;
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }

        TextView pointsView = (TextView) findViewById(R.id.points);
        pointsView.setText("Points: " + points);
        roll();
    }

    private void roll() {
        // random numbers
        Random r = new Random();
        n1 = r.nextInt(9);
        n2 = r.nextInt(9);
        while (n2 == n1) {
            n2 = r.nextInt(9);
        }
        Button buttonLeft = (Button) findViewById(R.id.buttonLeft);
        buttonLeft.setText("" + n1);

        Button buttonRight = (Button) findViewById(R.id.buttonRight);
        buttonRight.setText("" + n2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll();
    }
}