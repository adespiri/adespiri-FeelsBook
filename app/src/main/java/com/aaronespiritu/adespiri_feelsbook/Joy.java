package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Joy extends Emotion {
    /*  subclass of Emotion used to create instances of Joy objects. Contains a string function unique to other emotions. The type
    is used for identifying what class an object is inside the general ArrayList<Emotion> array (found in Emotion_List class.
    (Cant use isClass() method and this is a workaorund.
    * */
    public final String type = "joy";
    Joy()
    {
        super();
    }

    public String returnEmotionString()
    {
        return "You are feeling joyful | " + this.date + "\n" + "\"" + comment + "\"";
    }

    public String getType()
    {
        return type;
    }

}