package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        Button saveButton = findViewById(R.id.button);

        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPreferences",MODE_PRIVATE);
        String string = sharedPreferences.getString("SAVED_VALUE","");
        editText.setText(string);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = MainActivity.this.getSharedPreferences("mySharedPreferences",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("SAVED_VALUE",editText.getText().toString());
                editor.apply();
            }
        });
    }
}