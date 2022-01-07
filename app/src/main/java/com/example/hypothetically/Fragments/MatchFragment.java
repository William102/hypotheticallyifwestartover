package com.example.hypothetically.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hypothetically.databinding.FragmentDataBinding;
import com.example.hypothetically.databinding.FragmentMatchBinding;
import com.example.hypothetically.databinding.MatchActiveBinding;

public class MatchFragment extends Fragment {

    private MatchActiveBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = MatchActiveBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.teamNumbers,android.R.layout.simple_spinner_dropdown_item);
        adapter.SetDropDownViewResource()
    }
}