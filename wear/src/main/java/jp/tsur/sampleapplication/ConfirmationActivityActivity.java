package jp.tsur.sampleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.view.View;
import android.widget.Button;

/**
 * 確認のアニメーションが表示されるActivity
 */
public class ConfirmationActivityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_activity);

        Button successButton = (Button) findViewById(R.id.success_button);
        Button failureButton = (Button) findViewById(R.id.failure_button);
        Button openOnPhoneButton = (Button) findViewById(R.id.open_on_phone_button);

        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConfirmationActivity(ConfirmationActivity.SUCCESS_ANIMATION, getString(R.string.success));
            }
        });

        failureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConfirmationActivity(ConfirmationActivity.FAILURE_ANIMATION, getString(R.string.failure));
            }
        });

        openOnPhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConfirmationActivity(ConfirmationActivity.OPEN_ON_PHONE_ANIMATION, getString(R.string.open_on_phone));
            }
        });
    }

    private void startConfirmationActivity(int animationType, String message) {
        // android.support.wearable.activity.ConfirmationActivity を AndroidManifest に書く
        Intent confirmationActivity = new Intent(this, ConfirmationActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION)
                .putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE, animationType)
                .putExtra(ConfirmationActivity.EXTRA_MESSAGE, message);
        startActivity(confirmationActivity);
    }

}
