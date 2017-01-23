package io.demianlab.exercies06;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by peter0618 on 2017. 1. 23..
 */
public class ActionContainerController implements View.OnClickListener{

    private boolean isShown = false;
    private RelativeLayout actionContainer;
    private RelativeLayout showActionContainerBtn;

    private static ActionContainerController ourInstance = new ActionContainerController();

    public static ActionContainerController getInstance() {
        if(ourInstance == null){
            ourInstance = new ActionContainerController();
        }
        return ourInstance;
    }

    private ActionContainerController() {
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public void setUpController(RelativeLayout actionContainer,RelativeLayout showActionContainerBtn ){
        this.actionContainer = actionContainer;
        this.showActionContainerBtn = showActionContainerBtn;
        this.showActionContainerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(isShown()){
            actionContainer.setVisibility(View.GONE);
            ((ImageView) showActionContainerBtn.getChildAt(0)).setImageResource(R.drawable.button_down);
            setShown(false);
        } else {
            actionContainer.setVisibility(View.VISIBLE);
            ((ImageView) showActionContainerBtn.getChildAt(0)).setImageResource(R.drawable.button_up);
            setShown(true);
        }
    }
}
