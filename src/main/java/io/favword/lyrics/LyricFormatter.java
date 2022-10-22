package io.favword.lyrics;

import java.util.ArrayList;
import java.util.Arrays;

public class LyricFormatter {
    private static final int MAX_STRING_LENGTH = 12000;

    // takes in raw unformatted lyrics
    // removes all unnecessary song annotations such as [Bridge], [Chorus], [Verse], from string
    // removes all line breaks, empty lines, punctuation
    // returns string of all words separated by a space
    public static String splitLyrics(String unformattedLyrics) {
        //
        ArrayList<String> list = new ArrayList<>(Arrays.asList(unformattedLyrics.split("\\n")));
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            // remove song structure annotations and blank elements
            if (temp.contains("[") || temp.isEmpty()) {
                list.remove(i);
                i--;
            } else {
                // remove punctuation
                list.set(i, list.get(i).replaceAll("\\p{Punct}", ""));
            }
        }
        String temp = String.join(" ", list);
        if (temp.length() > MAX_STRING_LENGTH) {
            return temp.substring(0, MAX_STRING_LENGTH);
        }
        return temp;
    }

}