package io.demianlab.exercise02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * final 로 선언된 변수를 익명 클래스 내에서 변경해야 할 필요가 있을 때
 * 사용할 수 있는 트릭
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button button = (Button) findViewById(R.id.button);
        final MyInteger a = new MyInteger(1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.setValue(2);
                Log.d("test", "a : " + a);
            }
        });
    }

    class MyInteger {
        private int value;

        public MyInteger(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String toString(){
            return value+"";
        }
    }
}
