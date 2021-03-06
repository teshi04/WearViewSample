package jp.tsur.sampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;

/**
 * 円形のカウントダウン式タイマー
 */
public class DelayedConfirmationViewActivity extends Activity {

    private DelayedConfirmationView mDelayedConfirmationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_confirmation_view);
        mDelayedConfirmationView = (DelayedConfirmationView) findViewById(R.id.timer);

        startConfirmationTimer();
    }

    private void startConfirmationTimer() {
        mDelayedConfirmationView.setTotalTimeMs(4 * 1000);
        mDelayedConfirmationView.setListener(
                new android.support.wearable.view.DelayedConfirmationView.DelayedConfirmationListener() {
                    @Override
                    public void onTimerFinished(View view) {
                        // なにかする

                    }

                    @Override
                    public void onTimerSelected(View view) {
                        // キャンセル
                        finish();
                    }
                }
        );

        mDelayedConfirmationView.start();
    }
}
