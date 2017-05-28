package com.quintanilla00025815.animelist.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    public static final Map<Integer, DummyItem> ITEM_MAP = new HashMap<Integer, DummyItem>();

    private static final int COUNT = 10;

   static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }

    }



    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.idAnime, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(1,"Konosuba",2,"Comedia","Ecchi",12,2,"CTM");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {

       public int idAnime;
        public String titulo;
        public int imgId;
        private String genero;
        private String subGenero;
        private int cantCapitulos;
        private int cantTemporadas;
        public String descripcion;

        public DummyItem(int idAnime, String titulo, int imgId, String genero, String subGenero, int cantCapitulos, int cantTemporadas, String descripcion) {
            this.idAnime = idAnime;
            this.titulo = titulo;
            this.imgId = imgId;
            this.genero = genero;
            this.subGenero = subGenero;
            this.cantCapitulos = cantCapitulos;
            this.cantTemporadas = cantTemporadas;
            this.descripcion = descripcion;
        }

        public int getIdAnime() {
            return idAnime;
        }

        public void setIdAnime(int idAnime) {
            this.idAnime = idAnime;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public int getImgId() {
            return imgId;
        }

        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getSubGenero() {
            return subGenero;
        }

        public void setSubGenero(String subGenero) {
            this.subGenero = subGenero;
        }

        public int getCantCapitulos() {
            return cantCapitulos;
        }

        public void setCantCapitulos(int cantCapitulos) {
            this.cantCapitulos = cantCapitulos;
        }

        public int getCantTemporadas() {
            return cantTemporadas;
        }

        public void setCantTemporadas(int cantTemporadas) {
            this.cantTemporadas = cantTemporadas;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }


    }
}
