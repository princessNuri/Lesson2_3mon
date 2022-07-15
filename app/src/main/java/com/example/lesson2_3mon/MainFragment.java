package com.example.lesson2_3mon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {
    public static final String BUNDLE_STRING_KEY="key";
    public static final String BUNDLE_BOOLEAN_KEY="key1";
    public static final boolean BUNDLE_BOOLEAN=false;
    private EditText mainEditText;
    private Button mainButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainEditText=view.findViewById(R.id.et_main);
        mainButton= view.findViewById(R.id.btn_click_main);

        mainButton.setOnClickListener(view1 -> {
            if(savedInstanceState==null) {
                Bundle bundle = new Bundle();
                bundle.putString(BUNDLE_STRING_KEY,mainEditText.getText().toString());
                bundle.putBoolean(BUNDLE_BOOLEAN_KEY,BUNDLE_BOOLEAN);
                MiddleFragment middleFragment = new MiddleFragment();
                middleFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_activity,middleFragment).addToBackStack(null).commit();
            }
        });

    }
}