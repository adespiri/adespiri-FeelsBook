package com.aaronespiritu.adespiri_feelsbook;


import java.lang.String;

public class Surprise extends Emotion {

    Surprise()
    {
        super();
    }


    public String returnEmotionString()
    {
        return "You are feeling surprised | " + this.date + "\n" + comment;
    }

}