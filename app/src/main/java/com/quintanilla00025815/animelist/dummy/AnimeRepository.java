package com.quintanilla00025815.animelist.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnimeRepository {
    private ArrayList<Anime> rAnimes = new ArrayList<>();
    private HashMap<Integer,Anime> pAnimes = new HashMap<>();


    public AnimeRepository() {
        saveAnime(new Anime(1,"Konosuba",2,"Comedia","Ecchi",12,2,"CTM"));
        saveAnime(new Anime(2,"Konosuba",2,"Comedia","Ecchi",12,2,"CTM"));
        saveAnime(new Anime(3,"Konosuba",2,"Comedia","Ecchi",12,2,"CTM"));
    }
/*LELOUCH ESTA VIVO F.César*/

    private void saveAnime(Anime pAnime){pAnimes.put(pAnime.getIdAnime(),pAnime);
    }

    public List<Anime> getAnime(){
        Map<Integer,Anime> map = new TreeMap<>(pAnimes);
        return new ArrayList<>(map.values());
    }
}
