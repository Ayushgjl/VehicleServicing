package com.ayushgjl.vehicleservicing.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.ayushgjl.vehicleservicing.BikeActivity;
import com.ayushgjl.vehicleservicing.BookingActivity;
import com.ayushgjl.vehicleservicing.R;
import com.ayushgjl.vehicleservicing.ui.home.Adapter.CategoryAdapter;
import com.ayushgjl.vehicleservicing.ui.home.Adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView, recyclerView1, recyclerView2;
    ViewPager viewPager;
    public static List<HomeViewModel> categoryList=new ArrayList<>();
    private int position;
    private static final int PAGE_NUM=4;

    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(position,true);
            if(position>=PAGE_NUM) position=0;
            else position++;
            handler.postDelayed(runnable,3000);
        }
    };



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        runnable.run();

        recyclerView=view.findViewById(R.id.recycler);
        HomeViewModel homeViewModel=new HomeViewModel(R.drawable.splash);
        categoryList=homeViewModel.getListcategory();
        categoryList.add(new HomeViewModel(R.drawable.car));
        categoryList.add(new HomeViewModel(R.drawable.motorcycle));
        categoryList.add(new HomeViewModel(R.drawable.jeep));
        categoryList.add(new HomeViewModel(R.drawable.scooter));

recyclerView1 = view.findViewById(R.id.recycler1);

        recyclerView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), BookingActivity.class);
                startActivity(intent);
                return;

            }
        });

        recyclerView2 = view.findViewById(R.id.recycler2);
        recyclerView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getContext(), BikeActivity.class);
                startActivity(intent);
                return;

            }
        });


        CategoryAdapter categoryAdapter=new CategoryAdapter(getActivity(),categoryList);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));




        return view;

    }
}