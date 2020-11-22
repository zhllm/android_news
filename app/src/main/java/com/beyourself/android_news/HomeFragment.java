package com.beyourself.android_news;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button;
        button = getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = getView().findViewById(R.id.editTextTextPersonName);
                String text = editText.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    Toast.makeText(getActivity(), "请输入名称", Toast.LENGTH_SHORT).show();
                    return;
                }

                Bundle bundle = new Bundle();
                bundle.putString("my_name", text);
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_homeFragment_to_detailFragment, bundle);
            }
        });
    }
}