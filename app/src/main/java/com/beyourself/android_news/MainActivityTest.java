package com.beyourself.android_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivityTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        NavController controller = Navigation.findNavController(this, R.id.fragment);

        NavigationUI.setupActionBarWithNavController(this, controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // return super.onSupportNavigateUp();
        NavController controller = Navigation.findNavController(this, R.id.fragment);
        return controller.navigateUp();
    }
}