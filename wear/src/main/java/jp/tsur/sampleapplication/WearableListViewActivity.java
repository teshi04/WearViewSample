package jp.tsur.sampleapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WearableListView;
import android.support.wearable.view.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WearableListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearable_list_view);
        WearableRecyclerView list = (WearableRecyclerView) findViewById(R.id.list);
        list.setCircularScrollingGestureEnabled(true);

        Adapter adapter = new Adapter(this) {
            @Override
            void onItemClick(int position) {
                Intent intent = null;
                switch (position) {

                    case 0:
                        intent = new Intent(WearableListViewActivity.this, BoxInsetLayoutActivity.class);
                        break;
                    case 1:
                        intent = new Intent(WearableListViewActivity.this, CardScrollViewActivity.class);
                        break;
                    case 2:
                        intent = new Intent(WearableListViewActivity.this, CircledImageViewActivity.class);
                        break;
                    case 3:
                        intent = new Intent(WearableListViewActivity.this, CrossfadeDrawableActivity.class);
                        break;
                    case 4:
                        intent = new Intent(WearableListViewActivity.this, DelayedConfirmationViewActivity.class);
                        break;
                    case 5:
                        intent = new Intent(WearableListViewActivity.this, DismissOverlayViewActivity.class);
                        break;
                    case 6:
                        intent = new Intent(WearableListViewActivity.this, GridViewPagerActivity.class);
                        break;
                    case 7:
                        intent = new Intent(WearableListViewActivity.this, WatchViewStubActivity.class);
                        break;
                    case 8:
                        intent = new Intent(WearableListViewActivity.this, ConfirmationActivityActivity.class);
                        break;
                    case 9:
                        intent = new Intent(WearableListViewActivity.this, DrawerLayoutActivity.class);
                        break;

                }
                startActivity(intent);
            }
        };
        list.setAdapter(adapter);
    }

    private static class Adapter extends WearableRecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final LayoutInflater mInflater;
        private Context mContext;

        void onItemClick(int position) {
        }

        private Adapter(Context context) {
            mInflater = LayoutInflater.from(context);
            mContext = context;
        }

        @Override
        public WearableRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final WearableListView.ViewHolder viewHolder = new WearableListView.ViewHolder(
                    mInflater.inflate(R.layout.notif_preset_list_item, null));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick(viewHolder.getAdapterPosition());
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView view = (TextView) holder.itemView.findViewById(R.id.name);
            view.setText(mContext.getResources().getStringArray(R.array.menu)[position]);
        }


        @Override
        public int getItemCount() {
            return mContext.getResources().getStringArray(R.array.menu).length;
        }
    }
}
