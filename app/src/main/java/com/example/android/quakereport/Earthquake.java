package com.example.android.quakereport;

public class Earthquake {

    /** Earthquake Magnitude */
    private String mMagnitude;

    /** Earthquake Location */
    private String mLocation;

    /** Earthquake Date */
    private Long mTimeInMilliseconds;

    /**
     * Create a new Earthquake object
     * @param magnitude - severity of earthquake
     * @param location - location of earthquake
     * @param timeInMilliseconds - date of earthquake
     * */
    public Earthquake(String magnitude, String location, Long timeInMilliseconds){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    /**
     * Get earthquake magnitude
     */
    public String getQuakeMagnitude(){
        return mMagnitude;
    }

    /**
     * Get earthquake location
     */
    public String getQuakeLocation(){
        return mLocation;
    }

    /**
     * Get earthquake date
     */
    public Long getTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }
}
