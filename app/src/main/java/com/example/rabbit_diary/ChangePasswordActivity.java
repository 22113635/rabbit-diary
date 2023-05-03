package com.example.rabbit_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        DataSingletone data = DataSingletone.getInstance();

        EditText curPwEdit = findViewById(R.id.currentPassword);
        EditText changePwEdit = findViewById(R.id.changePassword);
        EditText changePw2Edit = findViewById(R.id.changePasswordConfirm);
        Button btn = findViewById(R.id.confirmButton);


        btn.setOnClickListener(view -> {
            String password = data.get("password");
            String curPw = curPwEdit.getText().toString();
            String pw1 = changePwEdit.getText().toString();
            String pw2 = changePw2Edit.getText().toString();
            if(!password.equals(curPw)) {
                Toast.makeText(getApplicationContext(), "현재 비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
            } else if(!pw1.equals(pw2)){
                Toast.makeText(getApplicationContext(), "변경 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            } else {
                data.set("password", pw1);
                Toast.makeText(getApplicationContext(), "비밀번호가 수정되었습니다.\n로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}