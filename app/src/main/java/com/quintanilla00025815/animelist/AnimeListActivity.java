package com.quintanilla00025815.animelist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.quintanilla00025815.animelist.adapter.Adapter;
import com.quintanilla00025815.animelist.adapter.StaggeredGridLayoutAdapter;
import com.quintanilla00025815.animelist.dummy.DummyContent;

import java.util.List;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link AnimeDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class AnimeListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list);

        DummyContent.setContext(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.anime_list);
        assert recyclerView != null;
        setupRecyclerView( recyclerView);

        if (findViewById(R.id.anime_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layoutselect, menu);
        return true;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new Adapter(this, DummyContent.ITEMS, mTwoPane));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DummyContent.DummyItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.anime_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText("Numero "+mValues.get(position).idAnime);
            holder.mContentView.setText(mValues.get(position).descAnime);
            holder.mTitleView.setText(mValues.get(position).titleAnime);
            holder.mImageView.setImageResource(mValues.get(position).imageAnime);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(AnimeDetailFragment.ARG_ITEM_ID, holder.mItem.idAnime);
                        AnimeDetailFragment fragment = new AnimeDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.anime_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, AnimeDetailActivity.class);
                        intent.putExtra(AnimeDetailFragment.ARG_ITEM_ID, holder.mItem.idAnime);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public final TextView mTitleView;
            public final ImageView mImageView;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
                mTitleView =(TextView) view.findViewById(R.id.title);
                mImageView = (ImageView) view.findViewById(R.id.imagee);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.linealOP:
                toLinear();
                return true;
            case R.id.otroOP:
                toStaggered();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void toLinear(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.anime_list);
        assert recyclerView != null;
        setupRecyclerView( recyclerView);
        LinearLayoutManager lLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lLayoutManager);
        recyclerView.setAdapter(new Adapter(this, DummyContent.ITEMS, mTwoPane));
    }

    public void toStaggered(){


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.anime_list);
        recyclerView.setMinimumWidth(300);
        assert recyclerView != null;
        setupRecyclerView( recyclerView);
        StaggeredGridLayoutManager straggLayoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(straggLayoutManager);
        recyclerView.setAdapter(new StaggeredGridLayoutAdapter(this, DummyContent.ITEMS, mTwoPane));
    }
    //f
}
