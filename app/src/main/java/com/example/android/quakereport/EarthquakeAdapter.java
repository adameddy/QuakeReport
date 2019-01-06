package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        // Find the TextView in list_item.xml for the location text
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        // Set text
        locationTextView.setText(currentEarthquake.getQuakeLocation());

        // Find the TextView in list_item.xml for the date text
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Set text
        dateTextView.setText(currentEarthquake.getQuakeDate());

        return listItemView;
    }
}
