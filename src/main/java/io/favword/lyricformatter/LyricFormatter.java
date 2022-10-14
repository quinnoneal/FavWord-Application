package io.favword.lyricformatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LyricFormatter {

    //todo: fix random [chorus] bug
    // takes in raw unformatted lyrics
    // removes all substrings that start with "[" and end with "]"
    // removes all new lines, empty lines, punctuation
    // returns string of all words separated by a space
    public static ArrayList<String> splitLyrics(String unformattedLyrics) {
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
        String listString = String.join(" ", list);
        return new ArrayList<String>(List.of(listString.split(" ")));
    }

}