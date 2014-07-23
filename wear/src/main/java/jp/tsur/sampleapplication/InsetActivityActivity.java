package jp.tsur.sampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.activity.InsetActivity;
import android.view.Menu;
import android.view.MenuItem;
import jp.tsur.sampleapplication.R;

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
