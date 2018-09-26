package com.aaronespiritu.adespiri_feelsbook;


import java.lang.String;

public class Love extends Emotion {

    Love()
    {
        super();
    }

    public String returnEmotionString()
    {
        return "You are feeling loved | " + this.date + "\n" + comment;
    }

}