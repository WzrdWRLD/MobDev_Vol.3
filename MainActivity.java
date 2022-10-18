package com.example.android3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    // Локальные переменные для доступа к компонентам окна
    private EditText editText;
    private String gender = "Мужской";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация переменных доступа к компонентам окна
        editText = findViewById(R.id.editText);
    }

    public void OnClick(View v) {
        boolean checked = ((Switch) v).isChecked();
        if (checked) {
            gender = "Женский";
        } else {
            gender = "Мужской";
        }
    }

    // МЕТОД ДЛЯ КНОПКИ "ИТОГО"
    public void onNext(View v) {
        // Создание второго окна
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        // Подготовка параметров для второго окна
        intent.putExtra("gender", gender);
        intent.putExtra("fio", editText.getText().toString());

        // Запуск второго окна
        startActivity(intent);
    }

}
