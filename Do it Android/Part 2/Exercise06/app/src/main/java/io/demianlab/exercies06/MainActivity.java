package io.demianlab.exercies06;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    private EditText urlInput;
    private TextView moveBtn;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout actionContainer = (RelativeLayout) findViewById(R.id.actionContainer);
        RelativeLayout showActionContainerBtn = (RelativeLayout) findViewById(R.id.showActionContainerBtn);
        ActionContainerController.getInstance().setUpController(actionContainer, showActionContainerBtn);

        urlInput = (EditText) findViewById(R.id.urlInput);
        moveBtn = (TextView) findViewById(R.id.moveBtn);
        moveBtn.setOnClickListener(this);


        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // 이걸 추가해야 크롭 앱을 실행하지 않고, 내 앱 내에서 웹브라우징 하도록 함.
        WebSettings set = webView.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(true);
//        webView.loadUrl("http://www.google.com");

    }

    @Override
    public void onClick(View view) {
        String url = urlInput.getText().toString();
        webView.loadUrl(url);
    }
}
