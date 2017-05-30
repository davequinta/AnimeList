package com.quintanilla00025815.animelist.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.quintanilla00025815.animelist.AnimeDetailActivity;
import com.quintanilla00025815.animelist.AnimeDetailFragment;
import com.quintanilla00025815.animelist.R;
import com.quintanilla00025815.animelist.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 29/05/2017.
 */

public class Adapter extends CustomRecyclerViewAdapter {
    private AppCompatActivity activity;
    private final ArrayList<DummyContent.DummyItem> series;
    private boolean mtwoPane;

    public Adapter(final AppCompatActivity activity, List<DummyContent.DummyItem> items, boolean mtwoPane) {
        this.activity = activity;
        this.series = (ArrayList<DummyContent.DummyItem>) items;
        this.mtwoPane = mtwoPane;
        setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity,series.get(position).titleAnime, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.anime_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomRecycleViewHolder holder, final int position) {
        final ViewHolder myHolder = (ViewHolder) holder;
        myHolder.poster.setImageResource(series.get(position).imageAnime);
        myHolder.desc.setText(series.get(position).descAnime);
        myHolder.title.setText(series.get(position).titleAnime);
        myHolder.ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mtwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(AnimeDetailFragment.ARG_ITEM_ID, series.get(position).idAnime);
                    AnimeDetailFragment fragment = new AnimeDetailFragment();
                    fragment.setArguments(arguments);

                    activity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.anime_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, AnimeDetailActivity.class);
                    intent.putExtra(AnimeDetailFragment.ARG_ITEM_ID, series.get(position).idAnime);

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private ImageView poster;
        private TextView title;
        private TextView desc;
        private CardView cardView;
        private Button ver;
        private TextView idView;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.imagee);
            desc = (TextView) itemView.findViewById(R.id.content);
            title = (TextView) itemView.findViewById(R.id.title);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            ver = (Button) itemView.findViewById(R.id.ver_button);
            idView = (TextView) itemView.findViewById(R.id.id);
        }
    }
}
