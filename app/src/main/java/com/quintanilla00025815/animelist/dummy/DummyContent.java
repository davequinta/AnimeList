package com.quintanilla00025815.animelist.dummy;

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

        addItem( new DummyItem(String.valueOf(1), "Gintama" , "Gintoki es cool", R.drawable.gintama,"URL1"));
        addItem( new DummyItem(String.valueOf(2), "Fate Zero" , "Gilgamesh es cool", R.drawable.fate,"URL2"));
        addItem( new DummyItem(String.valueOf(3), "Cowboy Bebop" , "Un anime cool", R.drawable.cowboy,"URL3"));
        addItem( new DummyItem(String.valueOf(4), "Naruto" , "Un anime cool xD", R.drawable.naruto,"URL4"));
        addItem( new DummyItem(String.valueOf(5), "One Piece" , "Un anime cool xDDD", R.drawable.one,"URL5"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.idAnime, item);
    }



    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String idAnime;
        public final String titleAnime;
        public final String descAnime;
        public final int imageAnime;
        public final String url;


        public DummyItem(String idAnime, String titleAnime, String descAnime, int imageAnime, String url) {
            this.idAnime = idAnime;
            this.titleAnime = titleAnime;
            this.descAnime = descAnime;
            this.imageAnime = imageAnime;
            this.url= url;

        }


        @Override
        public String toString() {
            return titleAnime;
        }
    }
}
