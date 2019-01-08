package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given
     * position in the list of earthquakes.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in list_item.xml for the magnitude text
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Set text
        String formattedMagnitude = formatMagnitude(currentEarthquake.getQuakeMagnitude());
        magnitudeTextView.setText(formattedMagnitude);

        // Find the TextView in list_item.xml for the offset location text
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Set text
        locationOffsetTextView.setText(getLocationOffset(currentEarthquake.getQuakeLocation()));

        // Find the TextView in list_item.xml for the primary location text
        TextView locationPrimaryTextView = (TextView) listItemView.findViewById(R.id.location_primary);
        // Set text
        locationPrimaryTextView.setText(getLocationPrimary(currentEarthquake.getQuakeLocation()));

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        //GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getQuakeMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Takes in location string (i.e. "74km NW of Rumoi, Japan")
     * and returns location offset only. (i.e. "74km NW of")
     */
    private String getLocationOffset(String location){
        if(location.contains("of")) {
            location = location.substring(0,location.indexOf("of") + 2);
        } else {
            location = "Near the";
        }
        return location;
    }

    /**
     * Takes in location string (i.e. "74km NW of Rumoi, Japan")
     * and returns location primary only. (i.e. "Rumoi, Japan")
     */
    private String getLocationPrimary(String location){
        if(location.contains("of")) {
            location = location.substring(location.indexOf("of") + 3,location.length());
        }
        return location;
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private int getMagnitudeColor(double magnitude) {
        int color;
        switch((int) magnitude){
            case 1:
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case 10:
                color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
        }
        return color;
    }
}
