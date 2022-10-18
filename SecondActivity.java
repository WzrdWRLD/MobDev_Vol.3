package com.example.android3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton selectRadioButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinner);


    }

    public void onNext(View v) {
        // Создание второго окна
        Intent intent = new Intent(SecondActivity.this, ResultActivity.class);

        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        // Подготовка параметров для второго окна
        intent.putExtra("gender", getIntent().getStringExtra("gender"));
        intent.putExtra("fio", getIntent().getStringExtra("fio"));
        intent.putExtra("edu", selectRadioButton.getText());
        intent.putExtra("country", spinner.getSelectedItem().toString());

        // Запуск второго окна
        startActivity(intent);
    }

    // МЕТОД ДЛЯ КНОПКИ НАЗАД
    public void onBack(View v) {
        setResult(RESULT_OK);
        finish();
    }
}
