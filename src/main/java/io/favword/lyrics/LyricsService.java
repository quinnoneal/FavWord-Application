package io.favword.lyrics;

import core.GLA;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LyricsService {
    // Genius Lyrics API Object, responsible for retrieving raw lyrics scraped straight from lyric page
    private final GLA gla = new GLA();
    // cut off length for string (increase of length provides more data but decreases performance significantly)
    private final int MAX_STRING_LENGTH = 15000;

    public LyricsService() {

    }

    /**
     * Returns a string of every word used in the specified artists top hit songs, separated by a space
     * @param query Singer/Songwriter/Band/Artist
     */
    public String getLyrics(String query) throws IOException {
        StringBuilder sb = new StringBuilder("");
        // combines artists' top 10 hits raw lyrics into one string builder object
        for (int i = 0; i < 10; i++) {
            if (sb.length() < MAX_STRING_LENGTH) {
                // attach
                sb.append(gla.search(query).getHits().get(i).fetchLyrics());
            }
        }
        // formats raw lyrics into string with each word spaced
        // splitLyrics method removes all unnecessary bridge, chorus, etc. annotations given by Genius API
        return LyricFormatter.splitLyrics(sb.toString());
    }
}
