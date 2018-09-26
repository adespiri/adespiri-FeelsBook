package com.aaronespiritu.adespiri_feelsbook;

public class Counter {
    /*This class will handle all the methods to keep track of
    the number of each emotion recorded
     */
    private static boolean first_instantiation = true;

    private static int joyCount;
    private static int fearCount;
    private static int angerCount;
    private static int loveCount;
    private static int sadCount;
    private static int surpriseCount;

    Counter()
    {
        //if first instantiation, set all counts to 0
        if (first_instantiation == true)
        {
            joyCount = 0;
            fearCount = 0;
            angerCount = 0;
            loveCount = 0;
            sadCount = 0;
            surpriseCount = 0;
            first_instantiation = false;
        }
    }
    public void add_joy()
    {
        joyCount += 1;
    }

    public void remove_joy()
    {
        joyCount -= 1;
    }

    public void add_fear()
    {
        fearCount += 1;
    }

    public void remove_fear()
    {
        fearCount -= 1;
    }

    public void add_anger()
    {
        angerCount += 1;
    }
    public void remove_anger()
    {
        angerCount -= 1;
    }

    public void add_surprise()
    {
        surpriseCount += 1;
    }
    public void remove_surprise()
    {
        surpriseCount -= 1;
    }

    public void add_sad()
    {
        sadCount += 1;
    }
    public void remove_sad()
    {
        sadCount -= 1;
    }

    public void add_love()
    {
        loveCount += 1;
    }
    public void remove_love()
    {
        loveCount -= 1;
    }

    public int get_loveCount()
    {
        return loveCount;
    }

    public int get_surpriseCount()
    {
        return surpriseCount;

    }

    public int get_fearCount()
    {
        return fearCount;
    }

    public int get_angerCount()
    {
        return angerCount;
    }

    public int get_sadCount()
    {
        return sadCount;
    }

    public int get_joyCount()
    {
        return joyCount;
    }

    //the following are used to reset persistent values after app is closed
    public void set_joyCount(int count) {joyCount = count;}
    public void set_fearCount(int count) {fearCount = count;}
    public void set_sadCount(int count) {sadCount = count;}
    public void set_angerCount(int count) {angerCount = count;}
    public void set_loveCount(int count) {loveCount = count;}
    public void set_surpriseCount(int count) {surpriseCount = count;}
}
