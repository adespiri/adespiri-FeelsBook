package com.aaronespiritu.adespiri_feelsbook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;

public abstract class Emotion {
    /*  This abstract class will be the parent class to all emotions. There are two abstract functions that need to be overriden by the children.
    Namely, each child emotion will print a different string and will have a different type. The date and comment of each emotion is handled
    similarly and so they can be found in this parent class.
    * */
    protected String date;
    protected String comment;

    //upon creation we should set the date to current time
    public Emotion()
    {
        comment = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        date = sdf.format(new Date());
    }

    public void setComment(String newComment) {
        comment = newComment;
        return;
    }

    public String getComment() {
        return comment;
    }
    public abstract String returnEmotionString();
    public abstract String getType(); //this function will determine what type of emotion it is

    public void setDate(String newDate)
    {
        date = newDate;
    }

    public String getDate()
    {
        return date;
    }


}
