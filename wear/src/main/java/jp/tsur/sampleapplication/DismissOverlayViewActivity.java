package jp.tsur.sampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.wearable.view.DismissOverlayView;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * 画面を長押しすると、確認画面が出て × 押すと Activity が finish されるようだ
 * ほとんどのアプリで実装されてなかったけど Allthecooks では実装された
 */
public class DismissOverlayViewActivity extends Activity {

    private GestureDetectorCompat mGestureDetector;
    private DismissOverlayView mDismissOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dismiss_overlay_view);

        mDismissOverlayView = (DismissOverlayView) findViewById(R.id.dismiss_overlay);

        // intro text は初回起動時に1回表示される
        mDismissOverlayView.setIntroText(R.string.intro_text);
        // 必要であれば intro text が表示される
        mDismissOverlayView.showIntroIfNecessary();
        mGestureDetector = new GestureDetectorCompat(this, new LongPressListener());
    }

    // 長押しジェスチャーを検出する
    private class LongPressListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public void onLongPress(MotionEvent event) {
            // exit button 表示
            mDismissOverlayView.show();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event) || super.dispatchTouchEvent(event);
    }

}
