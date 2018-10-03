package com.aaronespiritu.adespiri_feelsbook;

import android.widget.Toast;

import com.aaronespiritu.adespiri_feelsbook.Emotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Emotion_List {
    /*  This class will be used to instantiate an ArrayList of all emotions. The other arraylists that are involved will be used
    to comprise one general list called emotionList. The reason we do this is so that there are no errors when using gson to save
    and load emotionList (Emotion type is an abstract class)
    * */

    //one array for every emotion, which will all eventually be consolidated into one for sorting purposes
    //the consolidated arraylist will then be broken back down into
    private ArrayList<Emotion> emotionList;

    public  ArrayList<Sad> sadList;
    public  ArrayList<Joy> joyList;
    public  ArrayList<Surprise> surpriseList;
    public  ArrayList<Fear> fearList;
    public  ArrayList<Anger> angerList;
    public  ArrayList<Love>loveList;

    public Emotion_List()
    {   emotionList = new ArrayList<Emotion>();
        sadList = new ArrayList<Sad>();
        joyList = new ArrayList<Joy>();
        surpriseList = new ArrayList<Surprise>();
        fearList = new ArrayList<Fear>();
        angerList = new ArrayList<Anger>();
        loveList = new ArrayList<Love>();
    }

    public ArrayList<Emotion> getEmotionList()
    {


        return this.emotionList;
    }


    //sorting function that sorts each element by date.
    public void sortEmotions()
    {

        //need to use a comparator
        /*understanding of comparator and format from
        https://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
        by user: Domchi
         */
        Collections.sort(this.emotionList, new Comparator<Emotion>()
        {
            public int compare(Emotion obj1, Emotion obj2)
            {   //will sort objects by their date
                return obj2.getDate().compareTo(obj1.getDate());
            }
        });

    }

    public void consolidateEmotions()
    {
        //clear current emotion list
        //emotionList.clear();
        //first consolidate all arraylists into one
        for (Sad sadEmotion: this.sadList)
        {   //add to general list
            this.emotionList.add(sadEmotion);
        }

        for (Anger angerEmotion: this.angerList)
        {   //add to general list
            this.emotionList.add(angerEmotion);

        }

        for (Joy joyEmotion: this.joyList)
        {   //add to general list
            this.emotionList.add(joyEmotion);
        }

        for (Fear fearEmotion: this.fearList)
        {   //add to general list
            this.emotionList.add(fearEmotion);
        }

        for (Love loveEmotion: this.loveList)
        {   //add to general list
            this.emotionList.add(loveEmotion);
        }

        for (Surprise surpriseEmotion: this.surpriseList)
        {   //add to general list
            this.emotionList.add(surpriseEmotion);
        }

        //clear all the other arrays
        sadList.clear();
        joyList.clear();
        fearList.clear();
        angerList.clear();
        loveList.clear();
        surpriseList.clear();
    }

    public void organizeEmotions()
    {   /*
            This function does the opposite of consolidateEmotions. Namely it stores the appropriate emotions back into their arrays
            for storage with gson. Needs to be called before being saved to gson
        */
        for (Emotion emotion: emotionList)
        {
            //get class type and add to array

            if (emotion.getType().equals("sad"))
            {
                sadList.add((Sad) emotion);
            }

            else if (emotion.getType().equals("anger"))
            {
                angerList.add((Anger) emotion);
            }

            else if (emotion.getType().equals("surprise"))
            {
                surpriseList.add((Surprise) emotion);
            }

            else if (emotion.getType().equals("love"))
            {
                loveList.add((Love) emotion);
            }

            else if (emotion.getType().equals("fear"))
            {
                fearList.add((Fear) emotion);
            }

            else if (emotion.getType().equals("joy"))
            {
                joyList.add((Joy) emotion);
            }
        }
        //clear emotionlist
        emotionList.clear();
    }

}
