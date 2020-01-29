package com.ayushgjl.vehicleservicing.ui.home;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {

    static List<HomeViewModel> listcategory=new ArrayList<>();
    private int img;

    public HomeViewModel(int img) {
        this.img = img;
    }

    public static List<HomeViewModel> getListcategory() {
        return listcategory;
    }

    public static void setListcategory(List<HomeViewModel> listcategory) {
        HomeViewModel.listcategory = listcategory;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
