package io.favword.controllers;

import io.favword.lyrics.Lyrics;
import io.favword.query.Query;
import io.favword.lyrics.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class ApplicationController {
    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String takeInRequest(Model model) throws IOException {
        // get user query
        Query query = new Query();
        model.addAttribute("query", query);
        return "index";
    }

    @RequestMapping(value = "/generated", method = RequestMethod.POST)
    public String generate(@ModelAttribute("query") Query query, Model model) throws IOException, InterruptedException {
        Lyrics lyrics = new Lyrics();
        // using lyric service to retrieve a string of space-separated words used in artists' hits
        lyrics.setLyrics(lyricsService.getLyrics(query.getQuery()));
        model.addAttribute("lyrics", lyrics);
        // "image" template displays an embedded quick chart word cloud
        // within the url, parameter of "text" is set to the lyrics attribute
        // parameter of "format" is set to png
        // parameter of "removeStopWords" is set to true
        // parameter of "maxNumWords" is set to 2000
        return "image";
    }

}
