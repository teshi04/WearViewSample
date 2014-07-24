package jp.tsur.sampleapplication;

import android.os.Bundle;
import android.support.wearable.activity.InsetActivity;

public class InsetActivityActivity extends InsetActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onReadyForContent() {
        setContentView(R.layout.activity_inset_activity);

    }
}
