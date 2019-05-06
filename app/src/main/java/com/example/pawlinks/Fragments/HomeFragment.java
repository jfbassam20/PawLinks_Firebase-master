package com.example.pawlinks.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pawlinks.R;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {
    private TextView textViewEmail, textViewUsername;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        textViewEmail=view.findViewById(R.id.textViewEmail);
//        textViewUsername=view.findViewById(R.id.textViewUsername);



    }
}
