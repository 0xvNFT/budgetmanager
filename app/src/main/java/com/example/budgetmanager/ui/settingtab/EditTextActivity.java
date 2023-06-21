package com.example.budgetmanager.ui.settingtab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.budgetmanager.R;

public class EditTextActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        editTextInput = findViewById(R.id.editTextInput);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextInput.getText().toString();
                // Perform actions with the user input, e.g., save it to a database

                // Create the toast and set its gravity to top
                Toast toast = Toast.makeText(EditTextActivity.this, "lưu lại thành công: " + userInput, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }
}