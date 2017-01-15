package io.demianlab.exercise03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button :
                moveBackToMainActivity("고객 관리");
                break;

            case R.id.button2 :
                moveBackToMainActivity("매출 관리");
                break;

            case R.id.button3 :
                moveBackToMainActivity("상품 관리");
                break;

            default:
                break;
        }
    }

    public void moveBackToMainActivity(String txt){
        Intent intent = new Intent();
        intent.putExtra("txt", txt);
        setResult(RESULT_OK, intent);
        finish();
    }
}
