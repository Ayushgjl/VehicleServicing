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

import com.ayushgjl.vehicleservicing.LoginActivity;
import com.ayushgjl.vehicleservicing.MapsActivity;
import com.ayushgjl.vehicleservicing.R;

public class SendFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_send,container, false);
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);

        return root;

        
    }


}