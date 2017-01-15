package io.demianlab.exercise04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private final int CUSTOMER_REQ = 1001;
    private final int REVENUE_REQ = 1002;
    private final int PRODUCT_REQ = 1003;

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

        Intent intent = new Intent();
        intent.putExtra("txt", "from MenuActivity");
        setResult(RESULT_OK, intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(data != null){
                String title = data.getStringExtra("title");
                if(title != null){
                    Toast.makeText(getApplicationContext(),"from : " + title,Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button :
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivityForResult(intent, CUSTOMER_REQ);
                break;

            case R.id.button2 :
                Intent intent2 = new Intent(getApplicationContext(), RevenueActivity.class);
                startActivityForResult(intent2, REVENUE_REQ);
                break;

            case R.id.button3 :
                Intent intent3 = new Intent(getApplicationContext(), ProductActivity.class);
                startActivityForResult(intent3, PRODUCT_REQ);
                break;

            default:
                break;
        }
    }

}
