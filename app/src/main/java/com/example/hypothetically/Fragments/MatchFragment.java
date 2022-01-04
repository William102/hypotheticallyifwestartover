package com.example.hypothetically.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hypothetically.MainActivity;
import com.example.hypothetically.R;
import com.example.hypothetically.databinding.FragmentDataBinding;
import com.example.hypothetically.databinding.FragmentMatchBinding;

public class MatchFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner deviceSpinner;
    private Spinner teamSpinner;

    private FragmentMatchBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMatchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        deviceSpinner = root.findViewById(R.id.spinner);
        teamSpinner = root.findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> deviceAdapter = ArrayAdapter.createFromResource(root.getContext(),R.array.devices,android.R.layout.simple_spinner_item);
        deviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deviceSpinner.setAdapter(deviceAdapter);

        deviceSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> teamAdapter = ArrayAdapter.createFromResource(root.getContext(),R.array.teams,android.R.layout.simple_spinner_item);
        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamSpinner.setAdapter(deviceAdapter);

        teamSpinner.setOnItemSelectedListener(this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        Toast.makeText(binding.getRoot().getContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}