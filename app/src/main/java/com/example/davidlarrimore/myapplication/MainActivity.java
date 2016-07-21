package com.example.davidlarrimore.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



import com.example.davidlarrimore.myapplication.com.example.davidlarrimore.myapplication.die.D20;
import com.example.davidlarrimore.myapplication.com.example.davidlarrimore.myapplication.die.D6;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //DIE OBJECT CREATED TO RESOLVE ISSUE#3 (https://github.com/DiceHard/n20-android/issues/3)
    public static Die die = new D20();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView=(TextView) findViewById(R.id.textView2);
        textView.setText(String.valueOf(die.getRoll()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonOnClick(View v, int roll) {
        TextView textView=(TextView) findViewById(R.id.textView2);
        textView.setText(String.valueOf(roll));
    }


    public void D20buttonOnClick(View v) {
        //buttonOnClick(v, new D20().roll());
        buttonOnClick(v, die.roll());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
