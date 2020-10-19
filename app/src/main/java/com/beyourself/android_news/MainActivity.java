package com.beyourself.android_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
=======
>>>>>>> parent of c426164... viewmodel

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.beyourself.android_news.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    MyViewModel myViewModel;
    ActivityMainBinding binding;
=======
    Button button2;
    TextView textView;
    String Tag = "myLog";

>>>>>>> parent of c426164... viewmodel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button2 = findViewById(R.id.button2);

        if (savedInstanceState != null) {
            String value = savedInstanceState.getString("Key");
            textView.setText(value);
        }


<<<<<<< HEAD
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                .get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
=======

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.btn2);
            }
        });
>>>>>>> parent of c426164... viewmodel
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Key", textView.getText().toString());
    }
}