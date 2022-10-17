package io.favword.services;

import core.GLA;
import io.favword.lyricformatter.LyricFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class LyricsService {
    // gets lyric data and parses
    private StringBuilder sb = new StringBuilder("");
    // Genius Lyrics API Object
    private GLA gla = new GLA();

    public LyricsService() {

    }

    /**
     * Returns an array of every singular word written in the specified artists top 10 hit songs
     * @param query Singer/Songwriter/Band/Artist
     */
    public ArrayList<String> fetchLyrics(String query) throws IOException {
        for (int i = 0; i < 10; i++) {
            sb.append(gla.search(query).getHits().get(i).fetchLyrics());
        }
        return LyricFormatter.splitLyrics(sb.toString());
    }
}
