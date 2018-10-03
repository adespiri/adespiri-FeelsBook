package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Fear extends Emotion {
    /*  subclass of Emotion used to create instances of Fear objects. Contains a string function unique to other emotions. The type
    is used for identifying what class an object is inside the general ArrayList<Emotion> array (found in Emotion_List class.
    (Cant use isClass() method and this is a workaorund.
    * */

    final public String type = "fear";
    Fear()
    {
        super();
    }

    public String returnEmotionString()
    {
        return "You are feeling scared | " + this.date + "\n" + "\"" + comment + "\"";
    }

    public String getType() {
        return type;
    }
}