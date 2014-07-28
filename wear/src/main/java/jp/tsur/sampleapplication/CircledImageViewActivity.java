package jp.tsur.sampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class CircledImageViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circled_image_view);
        findViewById(R.id.circle_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
