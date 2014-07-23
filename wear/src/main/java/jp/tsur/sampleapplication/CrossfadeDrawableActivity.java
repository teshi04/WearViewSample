package jp.tsur.sampleapplication;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.view.CrossfadeDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import jp.tsur.sampleapplication.R;

public class CrossfadeDrawableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfade_drawable);

        Resources resources = getResources();
        Drawable droid = resources.getDrawable(R.drawable.ic_launcher);
        Drawable neko = resources.getDrawable(R.drawable.neko);
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable();
        crossfadeDrawable.setBase(droid);
        crossfadeDrawable.setFading(neko);
        crossfadeDrawable.setProgress(0.5f);

        ImageView imageView = (ImageView) findViewById(R.id.crossfade_image);
        imageView.setImageDrawable(crossfadeDrawable);
    }


}
