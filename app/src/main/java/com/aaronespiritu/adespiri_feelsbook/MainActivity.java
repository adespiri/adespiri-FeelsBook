package com.aaronespiritu.adespiri_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Counter counter = new Counter(); //instantiate counter for first time

        //get stored data from shared preferences
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        counter.set_angerCount(sharedpreferences.getInt("anger", 0));
        counter.set_sadCount(sharedpreferences.getInt("sad", 0));
        counter.set_loveCount(sharedpreferences.getInt("love", 0));
        counter.set_surpriseCount(sharedpreferences.getInt("surprise", 0));
        counter.set_fearCount(sharedpreferences.getInt("fear", 0));
        counter.set_joyCount(sharedpreferences.getInt("joy", 0));
        //sharedpreferences.edit().clear().commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public void onStop()
    {
        super.onStop();
        //save data using shared preferences doc found here https://www.tutorialspoint.com/android/android_shared_preferences.htm
        Counter counter = new Counter();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("anger",counter.get_angerCount());
        editor.putInt("sad",counter.get_sadCount());
        editor.putInt("love",counter.get_loveCount());
        editor.putInt("surprise",counter.get_surpriseCount());
        editor.putInt("fear",counter.get_fearCount());
        editor.putInt("joy",counter.get_joyCount());
        editor.commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        /* following code consulted from stackoverflow https://stackoverflow.com/questions/7479992/handling-a-menu-item-click-event-android
        by user Niranj Patel
         */
        int itemID = item.getItemId();

        if (itemID == R.id.countobj_menu) to_Counter();
        else if (itemID == R.id.historyobj_menu) to_History();
        return true;

    }

    public void to_Counter()
    {
        Intent intent = new Intent(MainActivity.this, CounterActivity.class);
        startActivity(intent);
    }

    public void to_History()
    {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    public void recordLove(View view)
    {
        //add to existing list of emotions
        Emotion_List list = new Emotion_List();
        list.getEmotionList().add(new Love());
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_love();


    }

    public void recordJoy(View view)
    {
        //add to existing list of emotions
        Emotion_List list = new Emotion_List();
        list.getEmotionList().add(new Joy());
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_joy();
        Toast.makeText(this, Integer.toString(myCounter.get_joyCount()), Toast.LENGTH_SHORT).show();
    }

    public void recordSad(View view)
    {
        Emotion_List list = new Emotion_List();
        list.getEmotionList().add(new Sad());
        //Toast.makeText(this, "The length is " + temp, Toast.LENGTH_SHORT ).show();
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_sad();
    }

    public void recordAnger(View view)
    {
        Emotion_List list = new Emotion_List();
        list.getEmotionList().add(new Anger());
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_anger();
    }

    public void recordFear(View view)
    {
        Emotion_List list = new Emotion_List();
        list.getEmotionList().add(new Fear());
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_fear();
    }

    public void recordSurprise(View view)
    {
        Emotion_List list = new Emotion_List();
        list.getEmotionList().add(new Surprise());
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_surprise();
    }
}
