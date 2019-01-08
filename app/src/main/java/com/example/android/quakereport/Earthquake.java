package com.example.android.quakereport;

public class Earthquake {

    /** Earthquake Magnitude */
    private Double mMagnitude;

    /** Earthquake Location */
    private String mLocation;

    /** Earthquake Date */
    private Long mTimeInMilliseconds;

    /** Earthquake URL */
    private String mUrl;

    /**
     * Create a new Earthquake object
     * @param magnitude - severity of earthquake
     * @param location - location of earthquake
     * @param timeInMilliseconds - date of earthquake
     * @param url - URL to extended info on earthquake
     * */
    public Earthquake(Double magnitude, String location, Long timeInMilliseconds, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /**
     * Get earthquake magnitude
     */
    public Double getQuakeMagnitude(){
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

    /**
     * Get earthquake url
     */
    public String getUrl(){
        return mUrl;
    }
}
