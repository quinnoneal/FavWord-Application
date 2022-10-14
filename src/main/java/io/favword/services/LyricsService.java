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
    private StringBuilder sb;
    // Genius Lyrics API Object
    @Autowired
    private GLA gla;

    public LyricsService() {

    }

    /**
     * Returns an array of every singular word written in the specified artists top 10 hit songs
     * @param query Singer/Songwriter/Band/Artist
     */
    @PostConstruct
    public ArrayList<String> fetchLyrics() throws IOException {
        for (int i = 0; i < 10; i++) {
            sb.append(gla.search("eminem").getHits().get(i).fetchLyrics());
        }
        return LyricFormatter.splitLyrics(sb.toString());
    }
}
