package com.example.budgetmanager.ui.settingtab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.budgetmanager.R;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class Covert extends AppCompatActivity {

    private Spinner spinnerFromCurrency;
    private Spinner spinnerToCurrency;
    private Button buttonConvert;
    private TextView textViewConvertedAmount;

    private EditText editTextAmountToConvert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covert);

        spinnerFromCurrency = findViewById(R.id.spinner_from_currency);
        spinnerToCurrency = findViewById(R.id.spinner_to_currency);
        buttonConvert = findViewById(R.id.button_convert);
        textViewConvertedAmount = findViewById(R.id.textview_converted_amount);
        editTextAmountToConvert = findViewById(R.id.editTextAmountToConvert);

        //strings.xml
        String[] currencyOptions1 = getResources().getStringArray(R.array.currencies);
        String[] currencyOptions2 = getResources().getStringArray(R.array.currencies2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyOptions1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyOptions2);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFromCurrency.setAdapter(adapter1);
        spinnerToCurrency.setAdapter(adapter1);
        spinnerFromCurrency.setAdapter(adapter2);
        spinnerToCurrency.setAdapter(adapter2);


        //convert here
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String fromCurrency = spinnerFromCurrency.getSelectedItem().toString();
                String toCurrency = spinnerToCurrency.getSelectedItem().toString();

                double exchangeRate = getExchangeRate(fromCurrency, toCurrency);


                String amountString = editTextAmountToConvert.getText().toString();
                double amountToConvert = Double.parseDouble(amountString);

                double convertedAmount = amountToConvert * exchangeRate;

                textViewConvertedAmount.setText(String.format("%.2f", convertedAmount));
            }
        });
    }

    private double getExchangeRate(String fromCurrency, String toCurrency) {
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

                        runOnUiThread(() -> {
                            String amountString = editTextAmountToConvert.getText().toString();
                            double amountToConvert = Double.parseDouble(amountString);
                            double convertedAmount = amountToConvert * exchangeRate;
                            textViewConvertedAmount.setText(String.format("%.2f", convertedAmount));
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return 0.0;
    }

}
