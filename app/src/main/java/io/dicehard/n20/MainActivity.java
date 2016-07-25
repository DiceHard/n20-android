package io.dicehard.n20;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.util.Log;
import android.graphics.Point;
import android.view.Display;

import io.dicehard.n20.die.D20;
import io.dicehard.n20.die.D6;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //DIE OBJECT CREATED TO RESOLVE ISSUE#3 (https://github.com/DiceHard/n20-android/issues/3)
    public static Die die = new D20();
    private static final String TAG = MainActivity.class.getSimpleName();
    public float incrementDistance = 0;
    public int lastXPosition = 0;

    //-1 = Backwards, 0 = Neutral, 1 = Forwards
    public int direction = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setting default first roll
        TextView textView=(TextView) findViewById(R.id.textView2);
        die.roll();
        textView.setText(String.valueOf(die.getRoll()));

        //Getting Screen Resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);


        Log.d(TAG,"Resolution = " + String.valueOf(size.x) + "x" + String.valueOf(size.y));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void rollButton(View v) {
        TextView textView=(TextView) findViewById(R.id.textView2);
        textView.setText(String.valueOf(die.roll()));
    }

    // This example shows an Activity, but you would use the same approach if
    // you were subclassing a View.
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);


        //Getting Screen Resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                direction = 0;
                incrementDistance = 0;
                lastXPosition = (int)event.getX();
                Log.d(TAG,"Action was DOWN. Resetting Increment");
                return true;
            case (MotionEvent.ACTION_MOVE) :
                Log.d(TAG,"Action was MOVE");

                int eventX = (int)event.getX();
                Log.d(TAG,"Last x Position: '"+lastXPosition+"', current x positon: '"+String.valueOf(eventX)+"'");

                //By comparing the lastXPosition to current X position, we can tell if movement was backwards or forwards
                if (eventX - lastXPosition < 0){
                    Log.d(TAG,"Direction was Backwards");
                    //Backwards
                    //If we are switching directions.....
                    if(direction != -1){
                        Log.d(TAG,"Switched directions, resetting");
                        lastXPosition = eventX;
                        incrementDistance = 0;
                    }else{
                        //incrementDistance should always be a positive number
                        incrementDistance += Math.abs((eventX - lastXPosition));
                    }
                    direction = -1;
                }else{
                    Log.d(TAG,"Direction was Forwards");
                    //Forwards
                    //If we are switching directions.....
                    if(direction != 1){
                        Log.d(TAG,"Switched directions, resetting");
                        lastXPosition = eventX;
                        incrementDistance = 0;
                    }else{
                        incrementDistance += eventX - lastXPosition;
                    }
                    direction = 1;
                }


                Log.d(TAG,"Incremental Distance is: " + incrementDistance);


                //If the incrementDistance is greater than 10% of screen size
                if (incrementDistance > (size.x/10)){
                    Log.d(TAG,"We hit 10%, moving the offset up one");

                    //Reset incrementalDistance to be modulus
                    incrementDistance = incrementDistance%(size.x/10);

                    //Last step is to actually increment
                    int oldRoll = die.getRoll();

                    if(direction == 1){
                        die.increment();
                    }else if (direction == -1){
                        die.decrement();
                    }

                    Log.d(TAG,"Old offset was '"+oldRoll+"', new offset is '"+String.valueOf(die.getRoll())+"'");
                    TextView textView=(TextView) findViewById(R.id.textView2);
                    textView.setText(String.valueOf(die.getRoll()));

                }
                //Finally, we reset the lastXPosition
                lastXPosition = eventX;

                return true;
            case (MotionEvent.ACTION_UP) :
                Log.d(TAG,"Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                Log.d(TAG,"Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Log.d(TAG,"Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default :
                return super.onTouchEvent(event);
        }
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
