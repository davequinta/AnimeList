package com.quintanilla00025815.animelist.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.quintanilla00025815.animelist.AnimeDetailActivity;
import com.quintanilla00025815.animelist.AnimeDetailFragment;
import com.quintanilla00025815.animelist.R;
import com.quintanilla00025815.animelist.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Luis on 29/05/2017.
 */

public class StaggeredGridLayoutAdapter extends CustomRecyclerViewAdapter {
    private final AppCompatActivity activity;
    private ArrayList<DummyItem> animes;
    private int screenWidth;
    private boolean mtwoPane;

    public StaggeredGridLayoutAdapter(final AppCompatActivity activity, final List<DummyItem> animes, boolean mtwoPane) {
        this.activity = activity;
        this.animes = (ArrayList<DummyItem>) animes;
        this.mtwoPane = mtwoPane;
        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity,animes.get(position).titleAnime, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.list_row_a, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecycleViewHolder holder, final int position) {
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
        myHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mtwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(AnimeDetailFragment.ARG_ITEM_ID, animes.get(position).idAnime);
                    AnimeDetailFragment fragment = new AnimeDetailFragment();
                    fragment.setArguments(arguments);

                    activity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.anime_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, AnimeDetailActivity.class);
                    intent.putExtra(AnimeDetailFragment.ARG_ITEM_ID, animes.get(position).idAnime);

                    context.startActivity(intent);
                }
            }
        });
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
            poster = (ImageView) itemView.findViewById(R.id.image_a);
            title = (TextView) itemView.findViewById(R.id.txt_a);
            cardView = (CardView) itemView.findViewById(R.id.card1);
        }
    }
//f
}
