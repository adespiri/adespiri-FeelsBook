package com.aaronespiritu.adespiri_feelsbook;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Emotion_List {
    //make a persistent list. Static variables are shared with all instances
    private static ArrayList<Emotion> emotionList = null;


    //The first time an emotion list is instantiated we need to create
    public ArrayList<Emotion> getEmotionList()
    {
        if (emotionList == null)
        {
            emotionList = new ArrayList<Emotion>();
        }

        return emotionList;
    }

    //sorting function that sorts each element by date.
    public void sortEmotions(ArrayList<Emotion> emotions)
    {
        //need to use a comparator
        /*understanding of comparator and format from
        https://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
        by user: Domchi
         */
        Collections.sort(emotions, new Comparator<Emotion>()
        {
            public int compare(Emotion obj1, Emotion obj2)
            {   //will sort objects by their date
                return obj1.getDate().compareTo(obj2.getDate());
            }
        });

    }



}
