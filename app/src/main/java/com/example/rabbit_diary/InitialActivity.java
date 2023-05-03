package com.example.rabbit_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        EditText pwConfirm = findViewById(R.id.passwordConfirmEditText);
        EditText pw = findViewById(R.id.passwordEditText);
        Button btn = findViewById(R.id.confirmButton);

        DataSingletone data = DataSingletone.getInstance();

        btn.setOnClickListener(view -> {
            String pwString = pw.getText().toString();
            if(pwString.length() < 4) {
                Toast.makeText(getApplicationContext(), "4자리 이상으로 설정해주세요.", Toast.LENGTH_SHORT).show();
            } else if(pwString.equals(pwConfirm.getText().toString())) {
                data.set("password", pwString);
                Toast.makeText(getApplicationContext(), "비밀번호 설정 완료.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}