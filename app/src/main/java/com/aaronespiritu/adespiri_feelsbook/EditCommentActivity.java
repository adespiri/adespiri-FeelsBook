package com.aaronespiritu.adespiri_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EditCommentActivity extends AppCompatActivity {

    Button submitButton;
    Emotion_List emotionList;
    SharedPreferences sharedpreferences;
    EditText newComment;
    int arrayPosition;
    String serializedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcommentlayout);

        //initialize submit button, button on click will go back to history activity
        submitButton = (Button) findViewById(R.id.commentSubmit);
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //retrieve the passed off emotionList
        Gson gson = new Gson();

        Intent intent = getIntent();
        serializedString = sharedpreferences.getString("listkey", "");
        emotionList = gson.fromJson(serializedString, new TypeToken<Emotion_List>(){}.getType());
        emotionList.consolidateEmotions();
        arrayPosition = intent.getIntExtra("ARRAYPOSITION", 0);


    }

    public void returnToHistory(View view)
    {
        newComment = (EditText) findViewById(R.id.newCommentBox);
        //replace text of selected emotion
        replaceText(newComment.getText().toString());
        //save the data of the comment and return to history activity

        emotionList.organizeEmotions();
        Toast.makeText(this, emotionList.angerList.toString(), Toast.LENGTH_LONG).show();
        Gson gson = new Gson();
        String serializedEmotionList = gson.toJson(emotionList);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.remove("listkey").commit();
        editor.putString("listkey", serializedEmotionList);

        editor.commit();
        //clear the text box
        newComment.setText("", TextView.BufferType.NORMAL);
        finish(); //remove from activity stack and return to history list


    }

    private void replaceText(String newComment)
    {
        emotionList.consolidateEmotions();
        //this method will take the text in the text box and replace it with the old text of the selected emotion
        emotionList.sortEmotions();
        Emotion emotion = emotionList.getEmotionList().get(arrayPosition);
        emotion.setComment(newComment);


    }

}
