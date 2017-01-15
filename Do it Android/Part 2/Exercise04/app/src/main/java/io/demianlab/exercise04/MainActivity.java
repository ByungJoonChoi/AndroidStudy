package io.demianlab.exercise04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_REQ = 1000;
    private static final String TAG = "MainActivity";
    private EditText userId;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = (EditText) findViewById(R.id.userId);
        password = (EditText) findViewById(R.id.password);
    }

    public void onLoginButtonClicked(View v){
        if(validateForm()){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivityForResult(intent, MENU_REQ);
        }
    }

    public boolean validateForm(){
        boolean isValid = true;
        if(TextUtils.isEmpty(userId.getText().toString())){
            Toast.makeText(getApplicationContext(),"아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
            isValid = false;
        } else if(TextUtils.isEmpty(password.getText().toString())){
            Toast.makeText(getApplicationContext(),"비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        return isValid;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult() is called");
        if(resultCode == RESULT_OK){
            String txt = data.getStringExtra("txt");
            if(txt!=null)
                Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
        } else if(resultCode == RESULT_CANCELED){
            Toast.makeText(getApplicationContext(), "result 를 설정하지 않았습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
