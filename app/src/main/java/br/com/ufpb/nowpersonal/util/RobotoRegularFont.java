package br.com.ufpb.nowpersonal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;


public class RobotoRegularFont extends TextView {


    public RobotoRegularFont(Context context) {
        super(context);
        setTypeface(context);
    }

    public RobotoRegularFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(context);
    }

    public RobotoRegularFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RobotoRegularFont(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setTypeface(context);
    }

    private void setTypeface(Context context){
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf"));
    }
}
