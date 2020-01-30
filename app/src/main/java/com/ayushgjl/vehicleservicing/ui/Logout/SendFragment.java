package com.ayushgjl.vehicleservicing.ui.Logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ayushgjl.vehicleservicing.MapsActivity;
import com.ayushgjl.vehicleservicing.R;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View view = inflater.inflate(R.layout.activity_maps, container, false);

        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               Intent intent = new Intent(getActivity(), MapsActivity.class);
               startActivity(intent);

            }
        });
        return view;
    }
}