package com.aaronespiritu.adespiri_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Emotion_List emotionList;
    SharedPreferences sharedpreferences;
    EditText commentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Counter counter = new Counter(); //instantiate counter for first time
        commentBox = findViewById(R.id.commentBox);
        emotionList = new Emotion_List();

        //get stored data from shared preferences
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        counter.set_angerCount(sharedpreferences.getInt("anger", 0));
        counter.set_sadCount(sharedpreferences.getInt("sad", 0));
        counter.set_loveCount(sharedpreferences.getInt("love", 0));
        counter.set_surpriseCount(sharedpreferences.getInt("surprise", 0));
        counter.set_fearCount(sharedpreferences.getInt("fear", 0));
        counter.set_joyCount(sharedpreferences.getInt("joy", 0));

//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.clear();
//        editor.commit();


    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Gson gson = new Gson();
//      Read from sharedpreferences to update the emotionList
        String serializedString = sharedpreferences.getString("listkey","");
        if (!serializedString.equals("")) {
            Emotion_List result = gson.fromJson(serializedString, new TypeToken<Emotion_List>() {
            }.getType());
            if (result != null) emotionList = result;
            emotionList.consolidateEmotions();

            if (emotionList != null) updateCurrentEmotion();
        }
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


        //also save the emotions that are saved in the emotion_list
        /*  Reference to this solution is attributed to User 'tpk' from StackOverflow https://stackoverflow.com/questions/7145606/how-android-sharedpreferences-save-store-object
            I also had to manipulate the build.gradle and adding the gson dependency
        * */
        emotionList.organizeEmotions();
        Gson gson = new Gson();
        emotionList.getEmotionList().clear(); //clear emotion list to prevent errors on startup
        String serializedEmotionList = gson.toJson(emotionList);

        editor.remove("listkey").commit();
        editor.putString("listkey", serializedEmotionList);
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
        Gson gson = new Gson();
        emotionList.organizeEmotions();
        String serializedEmotionList = gson.toJson(emotionList);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.remove("listkey").commit();
        editor.putString("listkey", serializedEmotionList);
        //Toast.makeText(this, serializedEmotionList, Toast.LENGTH_LONG).show();
        editor.commit();
        startActivity(intent);
    }

    public void recordLove(View view)
    {
        //add to existing list of emotions, also set the comment
        Love newLove = new Love();
        newLove.setComment(commentBox.getText().toString());

        emotionList.loveList.add(newLove);
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_love();
        Toast.makeText(this, "Love Emotion Recorded!", Toast.LENGTH_SHORT).show();

        //clear text in commentbox
        commentBox.setText("", TextView.BufferType.NORMAL);
        updateCurrentEmotion();

    }

    public void recordJoy(View view)
    {
        //add to existing list of emotions, also set the comment
        Joy newJoy = new Joy();
        newJoy.setComment(commentBox.getText().toString());

        emotionList.joyList.add(newJoy);
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_joy();
        Toast.makeText(this, "Joy Emotion Recorded!", Toast.LENGTH_SHORT).show();

        //clear text in commentbox
        commentBox.setText("", TextView.BufferType.NORMAL);
        updateCurrentEmotion();
    }

    public void recordSad(View view)
    {
        //add to existing list of emotions, also set the comment
        Sad newSad = new Sad();
        newSad.setComment(commentBox.getText().toString());

        emotionList.sadList.add(newSad);
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_sad();
        Toast.makeText(this, "Sad Emotion Recorded!", Toast.LENGTH_SHORT).show();

        //clear text in commentbox
        commentBox.setText("", TextView.BufferType.NORMAL);
        updateCurrentEmotion();
    }

    public void recordAnger(View view)
    {
        //add to existing list of emotions, also set the comment
        Anger newAnger = new Anger();
        newAnger.setComment(commentBox.getText().toString());

        emotionList.angerList.add(newAnger);
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_anger();
        Toast.makeText(this, "Anger Emotion Recorded!", Toast.LENGTH_SHORT).show();

        //clear text in commentbox
        commentBox.setText("", TextView.BufferType.NORMAL);
        updateCurrentEmotion();
    }

    public void recordFear(View view)
    {
        //add to existing list of emotions, also set the comment
        Fear newFear = new Fear();
        newFear.setComment(commentBox.getText().toString());

        emotionList.fearList.add(newFear);
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_fear();
        Toast.makeText(this, "Fear Emotion Recorded!", Toast.LENGTH_SHORT).show();

        //clear text in commentbox
        commentBox.setText("", TextView.BufferType.NORMAL);
        updateCurrentEmotion();
    }

    public void recordSurprise(View view)
    {
        //add to existing list of emotions, also set the comment
        Surprise newSurprise = new Surprise();
        newSurprise.setComment(commentBox.getText().toString());

        emotionList.surpriseList.add(newSurprise);
        //call counter
        Counter myCounter = new Counter();
        myCounter.add_surprise();
        Toast.makeText(this, "Surprise Emotion Recorded!", Toast.LENGTH_SHORT).show();

        //clear text in commentbox
        commentBox.setText("", TextView.BufferType.NORMAL);
        updateCurrentEmotion();
    }

    private void updateCurrentEmotion()
    {
        //clear current text
        TextView currentEmotionView = (TextView) findViewById(R.id.currentEmotionText);
        currentEmotionView.setText("", TextView.BufferType.NORMAL);

        //this function will display the most recent emotion in the home screen
        emotionList.consolidateEmotions();
        emotionList.sortEmotions();
        //get first element in that array and create a string for it
        Emotion emotion = emotionList.getEmotionList().get(0);
        String emotionString = emotion.returnEmotionString();
        //set text
        currentEmotionView.setText(emotionString);
    }
}
