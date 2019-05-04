package com.manpro.pawlinks.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.manpro.pawlinks.R;

public class QnaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.qna_fragment, container, false);
        LinearLayout L1 = (LinearLayout) rootview.findViewById(R.id.catforum);
        LinearLayout L2 = (LinearLayout) rootview.findViewById(R.id.dogforum);
        LinearLayout L3 = (LinearLayout) rootview.findViewById(R.id.birdforum);
        LinearLayout L4 = (LinearLayout) rootview.findViewById(R.id.fishforum);
        LinearLayout L5 = (LinearLayout) rootview.findViewById(R.id.rabbitforum);
        LinearLayout L6 = (LinearLayout) rootview.findViewById(R.id.turtleforum);
        LinearLayout L7 = (LinearLayout) rootview.findViewById(R.id.spiderforum);
        LinearLayout L8 = (LinearLayout) rootview.findViewById(R.id.hamsterforum);
        LinearLayout L9 = (LinearLayout) rootview.findViewById(R.id.otherforum);

        L1.setOnClickListener(this);
        L2.setOnClickListener(this);
        L3.setOnClickListener(this);
        L4.setOnClickListener(this);
        L5.setOnClickListener(this);
        L6.setOnClickListener(this);
        L7.setOnClickListener(this);
        L8.setOnClickListener(this);
        L9.setOnClickListener(this);


        return rootview;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.catforum:
                fragment = new ListForum();
                replaceFragment(fragment);
                break;

            case R.id.phbookButton:
                fragment = new PhoneBookFragment();
                replaceFragment(fragment);
                break;
        }
    }
}