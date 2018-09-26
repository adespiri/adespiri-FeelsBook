package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Sad extends Emotion {

    Sad()
    {
        super();
    }


    public String returnEmotionString()
    {
        return "You are feeling sad | " + this.date + "\n" + comment;
    }



}
