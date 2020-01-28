package com.ayushgjl.vehicleservicing.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ayushgjl.vehicleservicing.R;

public class GalleryFragment extends Fragment {

  private   WebView Webview;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        Webview = view.findViewById(R.id.Webview);

        Webview.getSettings().setJavaScriptEnabled(true);
        Webview.setWebViewClient(new WebViewClient());
        Webview.loadUrl("https://www.budgetdirect.com.au/blog/car-maintenance.html");

        return view;
    }
}