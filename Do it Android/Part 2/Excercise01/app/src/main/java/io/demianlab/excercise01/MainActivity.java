package io.demianlab.excercise01;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageViewUp;
    private ImageView imageViewDown;
    private ImageView button_up;
    private ImageView button_down;

    private boolean isImageUp = true;
    private int width_img;
    private int height_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideActionBar();
        imageViewUp = (ImageView) findViewById(R.id.imageViewUp);
        imageViewDown = (ImageView) findViewById(R.id.imageViewDown);
        button_up = (ImageView) findViewById(R.id.button_up);
        button_down = (ImageView) findViewById(R.id.button_down);

        button_up.setOnClickListener(this);
        button_down.setOnClickListener(this);

        BitmapFactory.Options dimensions = new BitmapFactory.Options();
        dimensions.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.sample1, dimensions);
        width_img =  dimensions.outWidth;
        height_img = dimensions.outHeight;

        Log.d("test", "width : " + width_img + ", height : " + height_img);



        drawImage(imageViewUp);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_up:

                if(isImageUp)
                    return;
                drawImage(imageViewUp);
                cancelImage(imageViewDown);
                isImageUp = !isImageUp;
                break;

            case R.id.button_down:

                if(!isImageUp)
                    return;
                drawImage(imageViewDown);
                cancelImage(imageViewUp);
                isImageUp = !isImageUp;
                break;

            default:
                break;
        }

    }

    public void drawImage(ImageView imageView){
        Glide
                .with(this)
                .load(R.drawable.sample1)
                .asBitmap()
                .override(width_img,height_img)
                .into(imageView);
    }

    public void cancelImage(ImageView imageView){
        Glide
                .with(this)
                .load("")
                .asBitmap()
                .into(imageView);
    }

    public void hideActionBar(){
        ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.hide();
        }
    }
}
