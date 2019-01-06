package com.example.android.quakereport;

public class Earthquake {

    /** Earthquake Magnitude */
    private String mQuakeMagnitude;

    /** Earthquake Location */
    private String mQuakeLocation;

    /** Earthquake Date */
    private String mQuakeDate;

    /**
     * Create a new Earthquake object
     * @param quakeMagnitude - severity of earthquake
     * @param quakeLocation - location of earthquake
     * @param quakeDate - date of earthquake
     * */
    public Earthquake(String quakeMagnitude, String quakeLocation, String quakeDate){
        mQuakeMagnitude = quakeMagnitude;
        mQuakeLocation = quakeLocation;
        mQuakeDate = quakeDate;
    }

    /**
     * Get earthquake magnitude
     */
    public String getQuakeMagnitude(){
        return mQuakeMagnitude;
    }

    /**
     * Get earthquake location
     */
    public String getQuakeLocation(){
        return mQuakeLocation;
    }

    /**
     * Get earthquake date
     */
    public String getQuakeDate(){
        return mQuakeDate;
    }
}
