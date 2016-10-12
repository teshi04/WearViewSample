/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.tsur.sampleapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.support.wearable.complications.ComplicationData;
import android.support.wearable.complications.ComplicationManager;
import android.support.wearable.complications.ComplicationProviderService;
import android.support.wearable.complications.ComplicationText;
import android.text.TextPaint;
import android.util.Log;

import java.util.Locale;

public class MyComplicationProviderService extends ComplicationProviderService {

    private static final String TAG = "RandomNumberProvider";

    @Override
    public void onComplicationActivated(
            int complicationId, int dataType, ComplicationManager complicationManager) {
        Log.d(TAG, "onComplicationActivated(): " + complicationId);
    }


    @Override
    public void onComplicationUpdate(
            int complicationId, int dataType, ComplicationManager complicationManager) {
        Log.d(TAG, "onComplicationUpdate(): " + complicationId);
        int randomNumber = (int) Math.floor(Math.random() * 10);

        String randomNumberText =
                String.format(Locale.getDefault(), "%d", randomNumber);

        ComplicationData complicationData = null;

        switch (dataType) {
//            case ComplicationData.TYPE_SHORT_TEXT:
//                complicationData = new ComplicationData.Builder(ComplicationData.TYPE_SHORT_TEXT)
//                        .setShortText(ComplicationText.plainText(randomNumberText))
//                        .build();
//                Log.d(TAG, "a");
//                break;
            case ComplicationData.TYPE_LARGE_IMAGE:
                Bitmap bitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
            {
                // 好きな絵を描く（ここでは適当な数字を描画）
                Canvas canvas = new Canvas(bitmap);
                canvas.drawARGB(0, 0, 0, 0xFF);
                TextPaint textPaint = new TextPaint();
                textPaint.setAntiAlias(true);
                textPaint.setColor(Color.BLACK);
                textPaint.setFakeBoldText(true);
                textPaint.setTextSize(72);
                canvas.drawText("12", 0, 72, textPaint); // サンプルなのでハードコードですが
            }
            Icon icon = Icon.createWithBitmap(bitmap);

                BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.drawable.neko, null);
                complicationData = new ComplicationData
                        .Builder(ComplicationData.TYPE_LARGE_IMAGE)
                        .setLargeImage(icon)
                        .build();
                Log.d(TAG, "a");
                break;
            default:

        }

        if (complicationData != null) {
            complicationManager.updateComplicationData(complicationId, complicationData);
        }
    }

    @Override
    public void onComplicationDeactivated(int complicationId) {
        Log.d(TAG, "onComplicationDeactivated(): " + complicationId);
    }
}
