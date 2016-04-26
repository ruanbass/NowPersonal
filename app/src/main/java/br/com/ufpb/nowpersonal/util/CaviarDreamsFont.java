package br.com.ufpb.nowpersonal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;


public class CaviarDreamsFont extends TextView {


    public CaviarDreamsFont(Context context) {
        super(context);
        setTypeface(context);
    }

    public CaviarDreamsFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(context);
    }

    public CaviarDreamsFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CaviarDreamsFont(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setTypeface(context);
    }

    private void setTypeface(Context context){
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/caviar_dreams.ttf"));
    }
}
