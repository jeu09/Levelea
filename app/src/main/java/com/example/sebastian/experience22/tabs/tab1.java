package com.example.sebastian.experience22.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastian.experience22.R;

/**
 * Created by Dinfantes on 10/07/2015.
 */
public class tab1 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab1,container,false);


        return  view;
    }
}
