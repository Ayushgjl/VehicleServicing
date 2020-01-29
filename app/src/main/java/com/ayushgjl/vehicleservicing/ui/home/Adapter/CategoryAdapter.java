package com.ayushgjl.vehicleservicing.ui.home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayushgjl.vehicleservicing.R;
import com.ayushgjl.vehicleservicing.ui.home.HomeViewModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    Context context;
    List<HomeViewModel> listAdapter;

    public CategoryAdapter(Context context, List<HomeViewModel> listAdapter) {
        this.context = context;
        this.listAdapter = listAdapter;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories,parent,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        HomeViewModel dataModel=listAdapter.get(position);
        holder.img.setImageResource(dataModel.getImg());

    }

    @Override
    public int getItemCount() {
        return listAdapter.size();
    }


    public class CategoryHolder extends RecyclerView.ViewHolder{

        ImageView img;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
        }
    }
}
