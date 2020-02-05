package com.ayushgjl.vehicleservicing.ui.Profile;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ayushgjl.vehicleservicing.R;
import com.ayushgjl.vehicleservicing.ui.PrivacyandPolicy.ToolsViewModel;

public class ProfileFragment extends Fragment {


    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        return root;
    }
}
