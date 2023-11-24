package com.example.currencyconverter1;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import com.example.currencyconverter1.ExchangeRateResponse;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private EditText inputText, resultText;

    private Spinner fromSpinner;

    public Spinner getFromSpinner, toSpinner;

    @SuppressLint("MissingInflated")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputText = findViewById(R.id.editTextNumberDecimal);
        resultText = findViewById(R.id.editTextNumberDecimal2);
        fromSpinner = findViewById(R.id.spinner);
        toSpinner = findViewById(R.id.spinner2);


        final String[] currency = {"INR", "AUD", "CAD", "CNY", "NZD", "BZR", "ZAR"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currency);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);


        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                performConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                performConversion();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void performConversion() {


        double inputValue;
        try {
            inputValue = Double.parseDouble(inputText.getText().toString());
        } catch (NumberFormatException e) {

            resultText.setText("Output");
            return;
        }


        String from = fromSpinner.getSelectedItem().toString();
        String to = toSpinner.getSelectedItem().toString();


        double result = covert(from, to, inputValue);

        resultText.setText(String.valueOf(result));

    }

    private double covert(String from, String to, double Value) {

        return Value;
    }


}







