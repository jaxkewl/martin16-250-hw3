package com.marshong.martin16_250_hw3.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshong.martin16_250_hw3.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*return inflater.inflate(R.layout.fragment_main, container, false);*/
        return inflater.inflate(R.layout.sample_custom_shape_view, container, false);
    }
}
