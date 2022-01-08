package com.example.hypothetically.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.hypothetically.R;
import com.example.hypothetically.databinding.FragmentMatchBinding;


public class MatchFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner deviceSpinner;
    private Spinner teamSpinner;
    private FragmentMatchBinding binding;
    private int match = 1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMatchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setupSpinners();


        Button button = root.findViewById(R.id.startMatch);
        Button plusButton = root.findViewById(R.id.button5);
        Button minusButton = root.findViewById(R.id.button4);
        TextView matchNum = root.findViewById(R.id.editTextTextPersonName2);
        matchNum.setText(String.valueOf(match));
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                match++;
                matchNum.setText(String.valueOf(match));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(match > 1) {
                    match--;
                    matchNum.setText(String.valueOf(match));
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_activeMatch);
            }
        });

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
    public void setupSpinners(){
        View root = binding.getRoot();

        teamSpinner = root.findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> teamAdapter = ArrayAdapter.createFromResource(root.getContext(),R.array.teams,android.R.layout.simple_spinner_item);
        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamSpinner.setAdapter(teamAdapter);

        teamSpinner.setOnItemSelectedListener(this);
    }
}