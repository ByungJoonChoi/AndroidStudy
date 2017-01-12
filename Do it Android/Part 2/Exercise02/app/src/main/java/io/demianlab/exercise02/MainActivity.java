package io.demianlab.exercise02;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView count_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideActionBar();

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if(text.length() == 0){
                    Toast.makeText(getApplicationContext(), "글자를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                editText.clearFocus();
            }
        });

        count_text = (TextView) findViewById(R.id.count_text);

        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {

            String before;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                before = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String txt = editText.getText().toString();
                int count = txt.getBytes().length;
                count_text.setText(count + " / 80 바이트");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String txt = editText.getText().toString();
                int count = txt.getBytes().length;
                if(count > 80) {
                    editText.setText(before);
                    editText.setSelection(before.length()-1);
                }


            }
        });
    }

    public void hideActionBar(){
        ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.hide();
        }
    }
}
