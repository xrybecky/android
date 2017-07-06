package com.bicyclebell.viko.bicyclebell.fragments;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bicyclebell.viko.bicyclebell.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleLocationFragment extends Fragment {


    public SimpleLocationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_location, container, false);

        setAwesomeTypeFace(view);

        return view;
    }

    private void setAwesomeTypeFace(View view) {
        Typeface fontAwesome = Typeface.createFromAsset(getActivity().getAssets(), "fontawesome-webfont.ttf");

        // Icon Text Views
        TextView altitudeTextView = (TextView) view.findViewById(R.id.altitudeIcon);
        TextView speedTextView = (TextView) view.findViewById(R.id.speedIcon);
        TextView distanceTextView = (TextView) view.findViewById(R.id.distanceIcon);

        altitudeTextView.setTypeface(fontAwesome);
        speedTextView.setTypeface(fontAwesome);
        distanceTextView.setTypeface(fontAwesome);
    }

}
