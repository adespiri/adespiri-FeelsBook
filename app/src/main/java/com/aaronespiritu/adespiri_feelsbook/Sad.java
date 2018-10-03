package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Sad extends Emotion {
    /*  subclass of Emotion used to create instances of Sad objects. Contains a string function unique to other emotions. The type
    is used for identifying what class an object is inside the general ArrayList<Emotion> array (found in Emotion_List class.
    (Cant use isClass() method and this is a workaorund.
    * */
    public final String type = "sad";
    Sad()
    {
        super();
    }

    public String getType()
    {
        return type;
    }

    public String returnEmotionString()
    {
        return "You are feeling sad | " + this.date + "\n" + "\"" + comment + "\"";
    }



}
