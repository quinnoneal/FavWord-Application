package io.favword.lyrics;

import java.util.ArrayList;
import java.util.Arrays;

public class LyricFormatter {
    private static final int MAX_STRING_LENGTH = 12000;

    /**
     * Takes in raw unformatted lyrics & removes all unnecessary song annotations such as [Bridge], [Chorus], [Verse],
     * etc. from string. Removes all line breaks, empty lines, and punctuation.
     * @param unformattedLyrics raw unformatted lyrics
     * @return String of all words from lyrics, separated by a space
     */
    public static String splitLyrics(String unformattedLyrics) {
        // initialize arraylist with raw lyrics string split by each line break (first format step)
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
        // check if string is longer than url character limit to prevent http 414 error code
        if (temp.length() > MAX_STRING_LENGTH) {
            return temp.substring(0, MAX_STRING_LENGTH);
        }
        return temp;
    }

}