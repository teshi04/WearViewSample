package jp.tsur.sampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.CardFrame;
import android.support.wearable.view.CardScrollView;

public class CardScrollViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_scroll_view);

        CardScrollView cardScrollView = (CardScrollView) findViewById(R.id.card_scroll_view);
        CardFrame cardFrame = (CardFrame) findViewById(R.id.card_frame);
    }

}
