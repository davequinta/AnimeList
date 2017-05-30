package com.quintanilla00025815.animelist.dummy;

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

        addItem( new DummyItem(String.valueOf(1), "Gintama" , "La historia de Gintama nos sitúa en un Japón sometido por unas criaturas alienígenas conocidas como Amantos. Gracias a estos el país goza de avances tecnológicos desmedidos, pero a la vez la especie humana ha sido desprendida de la autoridad de velar sobre su propio planeta. ", R.drawable.gintama,"URL1",listCaps(200)));
        addItem( new DummyItem(String.valueOf(2), "Fate Zero" , "Cada 10 años se lleva acabo un ritual, una guerra entre 7 magos escogidos por una fuerza omnipotente, cuyo objetivo es invocar el Santo Grial y que este le conceda al vencedor un unico deseo que sera realizado sin importar lo que se pida.", R.drawable.fate,"URL2",listCaps(50)));
        addItem( new DummyItem(String.valueOf(3), "Cowboy Bebop" , "Un grupo muy peculiar de caza-recompensas que viaja a través del sistema solar en la nave Bebop. Balas, emoción y diversión se encuentran en cada una de sus sesiones autoconclusivas, las cuales los llevarán a enfrentar a un gran adversario y viejo amigo de Spike.", R.drawable.cowboy,"URL3",listCaps(21)));
        addItem( new DummyItem(String.valueOf(4), "Naruto" , "Naruto, un aprendiz de ninja de la Aldea Oculta de Konoha es un chico travieso que desea llegar a ser el Hokage de la aldea para demostrar a todos lo que vale.", R.drawable.naruto,"URL4",listCaps(12)));
        addItem( new DummyItem(String.valueOf(5), "One Piece" , "Una historia épica de piratas, donde narra la historia de Monkey D. Luffy quien cuado tenia 7 años, comió accidentalmente una Akuma no mi(Futa del diablo) la cual le dio poderes de goma.", R.drawable.one,"URL678",listCaps(23)));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.idAnime, item);
    }
    
    private static String listCaps(int caps) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("Capitulo ").append(i);
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
