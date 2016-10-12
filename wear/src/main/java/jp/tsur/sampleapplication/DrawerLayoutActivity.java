package jp.tsur.sampleapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.view.drawer.WearableActionDrawer;
import android.support.wearable.view.drawer.WearableDrawerLayout;
import android.support.wearable.view.drawer.WearableNavigationDrawer;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;


public class DrawerLayoutActivity extends Activity {

    //    private WearableActionDrawer mWearableActionDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        // Main Wearable Drawer Layout that wraps all content
        WearableDrawerLayout wearableDrawerLayout
                = (WearableDrawerLayout) findViewById(R.id.drawer_layout);

        // Top Navigation Drawer
        WearableNavigationDrawer wearableNavigationDrawer
                = (WearableNavigationDrawer) findViewById(R.id.top_navigation_drawer);
        wearableNavigationDrawer.setAdapter(new NavigationAdapter(this));

        // Peeks Navigation drawer on the top.
        wearableDrawerLayout.peekDrawer(Gravity.TOP);

        // Bottom Action Drawer
        WearableActionDrawer wearableActionDrawer
                = (WearableActionDrawer) findViewById(R.id.bottom_action_drawer);
        wearableActionDrawer.setOnMenuItemClickListener(
                new WearableActionDrawer.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        return false;
                    }
                });

        // Peeks action drawer on the bottom.
        wearableDrawerLayout.peekDrawer(Gravity.BOTTOM);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_NAVIGATE_NEXT:
                Log.d("onKeyDown", "Next");
                break;
            case KeyEvent.KEYCODE_NAVIGATE_PREVIOUS:
                Log.d("onKeyDown", "Previous");
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    private final class NavigationAdapter
            extends WearableNavigationDrawer.WearableNavigationDrawerAdapter {

        private final Context context;

        public NavigationAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public void onItemSelected(int position) {

        }

        @Override
        public String getItemText(int position) {
            return "text" + position;
        }

        @Override
        public Drawable getItemDrawable(int position) {
            return context.getDrawable(R.drawable.star);
        }
    }

}
