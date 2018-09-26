package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Fear extends Emotion {

    Fear()
    {
        super();
    }

    public String returnEmotionString()
    {
        return "You are feeling scared | " + this.date + "\n" + comment;
    }

}