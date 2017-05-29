package com.quintanilla00025815.animelist.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.quintanilla00025815.animelist.R;
import com.quintanilla00025815.animelist.dummy.Anime;
import com.quintanilla00025815.animelist.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Luis on 29/05/2017.
 */

public class StaggeredGridLayoutAdapter extends CustomRecyclerViewAdapter {
    private Activity activity;
    private ArrayList<DummyItem> animes;
    private int screenWidth;

    public StaggeredGridLayoutAdapter(Activity activity, List<DummyItem> animes) {
        this.activity = activity;
        this.animes = (ArrayList<DummyItem>) animes;
        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.anime_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewHolder holder, int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.poster.setImageResource(animes.get(position).imageAnime);
        myHolder.title.setText(animes.get(position).titleAnime);

        Random mRandom = new Random();
        int max= 600 , min = 200;
        //  myHolder.itemView.getLayoutParams().height = mRandom.nextInt((max-min)+min)+min;
        /*int height;
        *if (position == 1 || position == (series.size() - 1)) {
            height = 600;
        } else {
            height = 800;
        }

        myHolder.cardView.setLayoutParams(new RecyclerView.LayoutParams(screenWidth/2,height));*/

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private ImageView poster;
        private TextView title;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.imagee);
            title = (TextView) itemView.findViewById(R.id.title);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

}
