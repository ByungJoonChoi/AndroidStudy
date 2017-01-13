package io.demianlab.exercise02;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "MainActivity";

    private EditText editText;
    private TextView count_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideActionBar();

        Button send = (Button) findViewById(R.id.send);
        Button close = (Button) findViewById(R.id.close);
        send.setOnClickListener(this);
        close.setOnClickListener(this);

        count_text = (TextView) findViewById(R.id.count_text);

        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {

            private String before;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG, "onTextChanged() is called");
                String txt = editText.getText().toString();
                int count = txt.getBytes().length;
                String str = count + " / 80  바이트";
                count_text.setText(str);

                if(count > 80) {
                    Log.d(TAG, "count > 80 before : " + before);
                    editText.setText(before);
                    editText.setSelection(before.length());

                    Toast.makeText(getApplicationContext(), "최대 입력글자 수를 초과하였습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    if(before != null && before.length() > 0){
                        if(before.length() - 1 > txt.length()){
                            return;
                            // <안드로이드 버그로 보이는 현상>
                            // 텍스트 입력도중 clear focus 했다가 다시 EditText 가장 마지막 부분에 커서를 놓고 입력하면 TextWatcher 콜백이 두번 호출됨.
                            // 그리고 EditText 에 입력되어 있는 문자열보다 훨씬 더 적은 수의 문자열이 log 에 찍힘
                        }
                    }
                    before = txt;
                    Log.d("test", "count <= 80 before : " + before);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.send :
                sendMsg();
                break;

            case R.id.close :
                hideKeyboardOrFinish();
                break;

            default :
                break;
        }
    }

    public void sendMsg(){
        String text = editText.getText().toString();
        if(text.length() == 0){
            Toast.makeText(getApplicationContext(), "글자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        editText.clearFocus();
    }

    public void hideKeyboardOrFinish(){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isAcceptingText()) {
            Log.d(TAG, "soft keyboard was shown");
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            editText.clearFocus();

        } else {
            Log.d(TAG, "soft keyboard is not shown");
            finish();
        }
    }

    public void hideActionBar(){
        ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.hide();
        }
    }
}
