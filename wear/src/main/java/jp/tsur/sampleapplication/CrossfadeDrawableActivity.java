package jp.tsur.sampleapplication;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.view.CrossfadeDrawable;
import android.widget.ImageView;

/**
 * ２つDrawableを持って、その２つをブレンドして調整するメソッドを持ったDrawable
 */
public class CrossfadeDrawableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfade_drawable);

        Resources resources = getResources();
        Drawable background1 = resources.getDrawable(R.drawable.background1);
        Drawable background2 = resources.getDrawable(R.drawable.background2);
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable();
        crossfadeDrawable.setBase(background1);
        crossfadeDrawable.setFading(background2);
        crossfadeDrawable.setProgress(0.5f);

        ImageView imageView = (ImageView) findViewById(R.id.crossfade_image);
        imageView.setImageDrawable(crossfadeDrawable);
    }


}
