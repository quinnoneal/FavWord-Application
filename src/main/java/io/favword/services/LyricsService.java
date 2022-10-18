package io.favword.services;

import core.GLA;
import io.favword.lyricformatter.LyricFormatter;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LyricsService {
    // Genius Lyrics API Object
    private GLA gla = new GLA();
    private final int MAX_STRING_LENGTH = 15000;

    public LyricsService() {

    }

    /**
     * Returns an array of every singular word written in the specified artists top 10 hit songs
     * @param query Singer/Songwriter/Band/Artist
     */
    public String fetchLyrics(String query) throws IOException {
        StringBuilder sb = new StringBuilder("");
        // combines top 10 hits raw lyrics into one string builder object
        for (int i = 0; i < 10; i++) {
            if (sb.length() < MAX_STRING_LENGTH) {
                sb.append(gla.search(query).getHits().get(i).fetchLyrics());
            }
        }
        // formats raw lyrics into string with each word spaced
        return LyricFormatter.splitLyrics(sb.toString());
    }
}
