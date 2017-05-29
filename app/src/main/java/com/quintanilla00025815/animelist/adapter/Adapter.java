package com.quintanilla00025815.animelist.adapter;

import android.app.Activity;
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

import com.quintanilla00025815.animelist.R;
import com.quintanilla00025815.animelist.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 29/05/2017.
 */

public class Adapter extends CustomRecyclerViewAdapter {
    private Activity activity;
    private final ArrayList<DummyContent.DummyItem> series;
    private boolean twoPane;

    public Adapter(final Activity activity, List<DummyContent.DummyItem> items, boolean twoPane) {
        this.activity = activity;
        this.series = (ArrayList<DummyContent.DummyItem>) items;
        this.twoPane = twoPane;
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
        myHolder.title.setText(series.get(position).titleAnime);
        /*myHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myHolder.itemView.getContext(),"LIKE "+ series.get(position).titleAnime, Toast.LENGTH_SHORT).show();
            }

        });*/

    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public class ViewHolder extends CustomRecycleViewHolder {
        private ImageView poster;
        private TextView title;
        private CardView cardView;
        //private Button like;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.imagee);
            title = (TextView) itemView.findViewById(R.id.title);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
//f
}
