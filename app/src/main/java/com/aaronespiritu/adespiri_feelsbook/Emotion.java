package com.aaronespiritu.adespiri_feelsbook;

import java.util.Date;
import java.lang.String;

public abstract class Emotion {
    protected Date date;
    protected String comment;

    //upon creation we should set the date to current time
    public Emotion()
    {
        comment = "";
        date = new Date();
    }

    public void setComment(String newComment) {
        comment = newComment;
        return;
    }

    public String getComment() {
        return comment;
    }
    public abstract String returnEmotionString();

    public void setDate(Date newDate)
    {
        date = newDate;
    }

    public Date getDate() //am I going to use this? TODO
    {
        return date;
    }


}
