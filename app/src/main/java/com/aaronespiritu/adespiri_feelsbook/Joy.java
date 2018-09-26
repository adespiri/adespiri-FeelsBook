package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Joy extends Emotion {

    Joy()
    {
        super();
    }

    public String returnEmotionString()
    {
        return "You are feeling joyful | " + this.date + "\n" + comment;
    }

}