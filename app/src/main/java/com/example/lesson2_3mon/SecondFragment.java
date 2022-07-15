
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

public class SecondFragment extends Fragment {
    private EditText secondEditText;
    private Button secondButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        secondEditText = view.findViewById(R.id.et_second);
        secondButton = view.findViewById(R.id.btn_back);

        secondButton.setOnClickListener(view1 -> {
            if(savedInstanceState==null) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_activity, new MainFragment()).addToBackStack(null).commit();
            }
        });
        if (getArguments() != null) {
            String value = getArguments().getString(MainFragment.BUNDLE_STRING_KEY);
            boolean isFragment = getArguments().getBoolean(MainFragment.BUNDLE_BOOLEAN_KEY);
            if(!isFragment){
                secondEditText.setText(value);
            }
        }
    }
}