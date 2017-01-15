package io.demianlab.mysmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MySMSReceiver extends BroadcastReceiver {
    private static final String TAG = "MySMSReceiver";

    public MySMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive() is called");

//        Intent myIntent = new Intent();
//        myIntent.setClassName("io.demianlab.mysmsreceiver", "io.demianlab.mysmsreceiver.MainActivity");
//        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(myIntent);

        Intent intent1 = new Intent(context, MainActivity.class); // 이 방법으로 하면 에러 발생할 때도 있고 안그럴 때도 있다.
        // context 가 시스템에서 보낸 거라 MainActivity.class 가 어떤 패키지 소속인지 알 수 없어서 에러가 나는 것 같음
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        long time = System.currentTimeMillis();
        intent1.putExtra("timestamp", time);
        context.startActivity(intent1);
    }
}
