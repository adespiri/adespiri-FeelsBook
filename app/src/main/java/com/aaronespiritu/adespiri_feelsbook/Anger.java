package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Anger extends Emotion {


    //initial string will be empty upon creation unless user wanted to add a comment
    Anger() //if no comment was provided
    {
        super();
    }

    public String returnEmotionString()
    {
        return "You are feeling angry | " + this.date + "\n" + this.comment;
    }

}