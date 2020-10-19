package com.beyourself.android_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewModelWithLiveData viewModelWithLiveData;
    TextView textView;
    ImageButton imageButtonLike, imageButtonDisLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageButtonLike = findViewById(R.id.imageButton2);
        imageButtonDisLike = findViewById(R.id.imageButton3);

        viewModelWithLiveData =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                        .get(ViewModelWithLiveData.class);

        viewModelWithLiveData.getLikeNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        imageButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikeNumber(1);
            }
        });

        imageButtonDisLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikeNumber(-1);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}