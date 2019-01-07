package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

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
        magnitudeTextView.setText(currentEarthquake.getQuakeMagnitude());

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
}
