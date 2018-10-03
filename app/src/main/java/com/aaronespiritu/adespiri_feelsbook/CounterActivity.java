package com.aaronespiritu.adespiri_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    EditText joyCounter;
    EditText sadCounter;
    EditText angerCounter;
    EditText fearCounter;
    EditText loveCounter;
    EditText surpriseCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counterview);

        joyCounter = (EditText) findViewById(R.id.joyCountBox); //will use these to update the boxes as activity is pulled up
        sadCounter = (EditText) findViewById(R.id.sadCountBox);
        angerCounter = (EditText) findViewById(R.id.angerCountBox);
        fearCounter = (EditText) findViewById(R.id.fearCountBox);
        loveCounter = (EditText) findViewById(R.id.lovedCountBox);
        surpriseCounter = (EditText) findViewById(R.id.surpriseCountBox);

       updateScreen();


    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //update the screen every time this activity is called
        updateScreen();
    }

    private void updateScreen()
    {
        //get counter
        Counter counter = new Counter();
        joyCounter.setText(Integer.toString(counter.get_joyCount()), TextView.BufferType.NORMAL);
        sadCounter.setText(Integer.toString(counter.get_sadCount()), TextView.BufferType.NORMAL);
        surpriseCounter.setText(Integer.toString(counter.get_surpriseCount()), TextView.BufferType.NORMAL);
        fearCounter.setText(Integer.toString(counter.get_fearCount()), TextView.BufferType.NORMAL);
        angerCounter.setText(Integer.toString(counter.get_angerCount()), TextView.BufferType.NORMAL);
        loveCounter.setText(Integer.toString(counter.get_loveCount()), TextView.BufferType.NORMAL);
    }
}
