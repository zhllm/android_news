package com.beyourself.android_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.beyourself.android_news.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    ActivityMainBinding binding;
    final static String KEY_NUMBER_A = "my_score_a";
    final static String KEY_NUMBER_B = "my_score_b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myViewModel = new ViewModelProvider(this,
                new SavedStateViewModelFactory(getApplication(), this))
                .get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myViewModel.save();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_NUMBER_A, myViewModel.getATeamScoreValue());
        outState.putInt(KEY_NUMBER_B, myViewModel.getBTeamScoreValue());
        super.onSaveInstanceState(outState);
    }
}