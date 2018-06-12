package com.example.aon_attapon.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aon_attapon.mvcstructure.R;

public class MainFragment extends Fragment {

    int someVar;

    public static MainFragment newInstace(int someVar){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle(); //Arguments;
        args.putInt("someVar",someVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Read from Argruments
        someVar = getArguments().getInt("someVar");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }
}
