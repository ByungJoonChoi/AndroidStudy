package io.demianlab.exercise04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by peter0618 on 2017. 1. 15..
 */

public class BaseActivity extends AppCompatActivity {
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        title = (TextView) findViewById(R.id.title);
    }

    @Override
    public void onBackPressed() {
        setResultAndFinish();
    }

    public void setTitle(String str){
        title.setText(str);
    }

    public void onButtonClicked(View v){
        setResultAndFinish();
    }

    public void setResultAndFinish(){
        Intent intent = new Intent();
        intent.putExtra("title", title.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
