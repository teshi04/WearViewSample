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

        // 内容がカードの幅より大きい場合、上端または下端にこれを示すためにフェードアウトのエフェクトを掛ける？
        cardFrame.setExpansionEnabled(true);

        // カードが展開される方向 CardFrame.EXPAND_UP | CardFrame.EXPAND_DOWN
        cardFrame.setExpansionDirection(CardFrame.EXPAND_DOWN);

        // 親の高さを基準にカードの高さの最大値を設定
        cardFrame.setExpansionFactor(1f);

    }

}
