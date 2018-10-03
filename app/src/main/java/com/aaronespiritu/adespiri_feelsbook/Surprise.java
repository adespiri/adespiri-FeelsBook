package com.aaronespiritu.adespiri_feelsbook;


import java.lang.String;

public class Surprise extends Emotion {
    /*  subclass of Emotion used to create instances of Surprise objects. Contains a string function unique to other emotions. The type
    is used for identifying what class an object is inside the general ArrayList<Emotion> array (found in Emotion_List class.
    (Cant use isClass() method and this is a workaorund.
    * */
    public final String type = "surprise";
    Surprise()
    {
        super();
    }

    public String getType()
    {
        return type;
    }

    public String returnEmotionString()
    {
        return "You are feeling surprised | " + this.date + "\n" + "\"" + comment + "\"";
    }

}