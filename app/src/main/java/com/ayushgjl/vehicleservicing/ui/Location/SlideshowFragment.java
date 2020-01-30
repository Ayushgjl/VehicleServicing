package com.ayushgjl.vehicleservicing.ui.Location;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ayushgjl.vehicleservicing.MapsActivity;
import com.ayushgjl.vehicleservicing.R;

public class SlideshowFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_maps,container, false);
        Intent intent = new Intent(getContext(), MapsActivity.class);
        startActivity(intent);
        return root;

    }
}