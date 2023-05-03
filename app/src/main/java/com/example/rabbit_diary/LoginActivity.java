package com.example.rabbit_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static Activity activity;
    public static void finishActivity() {
        activity.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activity = this;

        EditText pw = findViewById(R.id.passwordEditText);
        Button findPwBtn = findViewById(R.id.findPasswordButton);
        Button changePwBtn = findViewById(R.id.changePasswordButton);


        DataSingletone data = DataSingletone.getInstance();
        pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = data.get("password");
                if(password.equals(charSequence.toString())) {
                    Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        changePwBtn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ChangePasswordActivity.class));
        });
    }
}