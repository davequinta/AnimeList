package com.quintanilla00025815.animelist.dummy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.quintanilla00025815.animelist.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    private static Context context;

    public static void setContext(Context context){
        context = context;
    }
    private static Resources res = context.getResources();
    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {

        addItem( new DummyItem(String.valueOf(1), "Gintama" , res.getString(R.string.gintama_desc), R.drawable.gintama,"URL1",listCaps(200)));
        addItem( new DummyItem(String.valueOf(2), "Fate Zero" , res.getString(R.string.fateZero_desc), R.drawable.fate,"URL2",listCaps(50)));
        addItem( new DummyItem(String.valueOf(3), "Cowboy Bebop" , res.getString(R.string.cowboyBebop_desc), R.drawable.cowboy,"URL3",listCaps(21)));
        addItem( new DummyItem(String.valueOf(4), "Naruto" , res.getString(R.string.naturo_desc), R.drawable.naruto,"URL4",listCaps(12)));
        addItem( new DummyItem(String.valueOf(5), "One Piece" , res.getString(R.string.onePiece_desc), R.drawable.one,"URL678",listCaps(23)));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.idAnime, item);
    }
    
    private static String listCaps(int caps) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < caps; i++) {
            builder.append("\nCapitulo ").append(i);
        }
        return builder.toString();
    }
    



    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem extends Drawable {
        public final String idAnime;
        public final String titleAnime;
        public final String descAnime;
        public final int imageAnime;
        public final String url;
        public final String caps;


        public DummyItem(String idAnime, String titleAnime, String descAnime, int imageAnime, String url, String caps) {
            this.idAnime = idAnime;
            this.titleAnime = titleAnime;
            this.descAnime = descAnime;
            this.imageAnime = imageAnime;
            this.url= url;
            this.caps = caps;

        }

        @Override
        public String toString() {
            return titleAnime;
        }

        @Override
        public void draw(@NonNull Canvas canvas) {

        }

        @Override
        public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

        }

        @Override
        public void setColorFilter(@Nullable ColorFilter colorFilter) {

        }

        @Override
        public int getOpacity() {
            return PixelFormat.OPAQUE;
        }
    }
}
