package com.example.budgetmanager.ui.settingtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.budgetmanager.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CongFragment extends Fragment {

    private Spinner spinnerFromCurrency;
    private Spinner spinnerToCurrency;
    private Button buttonConvert;
    private TextView textViewConvertedAmount;
    private EditText editTextAmountToConvert;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_covert, container, false);

        spinnerFromCurrency = rootView.findViewById(R.id.spinner_from_currency);
        spinnerToCurrency = rootView.findViewById(R.id.spinner_to_currency);
        buttonConvert = rootView.findViewById(R.id.button_convert);
        textViewConvertedAmount = rootView.findViewById(R.id.textview_converted_amount);
        editTextAmountToConvert = rootView.findViewById(R.id.editTextAmountToConvert);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFromCurrency.setAdapter(adapter);
        spinnerToCurrency.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromCurrency = spinnerFromCurrency.getSelectedItem().toString();
                String toCurrency = spinnerToCurrency.getSelectedItem().toString();

                getExchangeRate(fromCurrency, toCurrency);
//                double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
//
//                String amountString = editTextAmountToConvert.getText().toString();
//                double amountToConvert = Double.parseDouble(amountString);
//
//                double convertedAmount = amountToConvert * exchangeRate;
//
//                textViewConvertedAmount.setText(String.format("%.2f", convertedAmount));
            }
        });

        return rootView;
    }

    private void getExchangeRate(String fromCurrency, String toCurrency) {
        String apiKey = "81e2b76cd3fb8ac61eb2123d";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + fromCurrency + "/" + toCurrency;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    try {
                        JSONObject jsonResponse = new JSONObject(responseData);
                        double exchangeRate = jsonResponse.getDouble("conversion_rate");

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String amountString = editTextAmountToConvert.getText().toString();
                                if (!amountString.isEmpty()) {
                                    double amountToConvert = Double.parseDouble(amountString);
                                    double convertedAmount = amountToConvert * exchangeRate;
                                    textViewConvertedAmount.setText(String.format("%.2f", convertedAmount));
                                }
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}