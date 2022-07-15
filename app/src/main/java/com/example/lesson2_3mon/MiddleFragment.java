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

public class MiddleFragment extends Fragment {
    private EditText middleEditText;
    private Button middleButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_middle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        middleEditText=view.findViewById(R.id.et_middle);
        middleButton= view.findViewById(R.id.btn_click_middle);

        middleButton.setOnClickListener(view1 -> {
            if(savedInstanceState==null) {
                Bundle bundle = new Bundle();
                bundle.putString(MainFragment.BUNDLE_STRING_KEY,middleEditText.getText().toString());
                bundle.putBoolean(MainFragment.BUNDLE_BOOLEAN_KEY,MainFragment.BUNDLE_BOOLEAN);
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_activity,secondFragment).addToBackStack(null).commit();
            }
        });

        if (getArguments() != null) {
            String value = getArguments().getString(MainFragment.BUNDLE_STRING_KEY);
            boolean isFragment = getArguments().getBoolean(MainFragment.BUNDLE_BOOLEAN_KEY);
            if(!isFragment){
                middleEditText.setText(value);
            }
        }
    }
}