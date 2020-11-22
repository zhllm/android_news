package com.beyourself.android_news;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String name = getArguments().getString("name");
        TextView textView = getView().findViewById(R.id.textView6);

        String string2 = getArguments().getString("my_name");
        textView.setText(string2);

        Button button;
        button = getView().findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_detailFragment_to_homeFragment);
            }
        });
    }
}