package com.aaronespiritu.adespiri_feelsbook;


import java.lang.String;

public class Love extends Emotion {
    /*  subclass of Emotion used to create instances of Love objects. Contains a string function unique to other emotions. The type
    is used for identifying what class an object is inside the general ArrayList<Emotion> array (found in Emotion_List class.
    (Cant use isClass() method and this is a workaorund.
    * */
    public final String type = "love";
    Love()
    {
        super();
    }

    public String returnEmotionString()
    {
        return "You are feeling loved | " + this.date + "\n" + "\"" + comment + "\"";
    }

    public String getType()
    {
        return type;
    }

}