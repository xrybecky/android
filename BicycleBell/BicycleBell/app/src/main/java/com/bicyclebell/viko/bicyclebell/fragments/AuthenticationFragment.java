package com.bicyclebell.viko.bicyclebell.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bicyclebell.viko.bicyclebell.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthenticationFragment extends Fragment {


    public AuthenticationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authentication, container, false);
    }

}
