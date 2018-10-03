package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.lang.String;

public class Anger extends Emotion {

/*  subclass of Emotion used to create instances of Anger objects. Contains a string function unique to other emotions. The type
    is used for identifying what class an object is inside the general ArrayList<Emotion> array (found in Emotion_List class.
    (Cant use isClass() method and this is a workaorund.
    * */
        final public String type = "anger";

    //initial string will be empty upon creation unless user wanted to add a comment
    Anger()
    {
        super();
    }

    public String getType()
    {
        return type;
    }

    public String returnEmotionString()
    {
        return "You are feeling angry | " + this.date + "\n" + "\"" + this.comment + "\"";
    }

}