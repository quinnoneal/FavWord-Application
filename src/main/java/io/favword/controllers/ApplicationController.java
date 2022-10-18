package io.favword.controllers;

import io.favword.Lyrics;
import io.favword.Query;
import io.favword.services.LyricsService;
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
        // generate favword cloud
        Query query = new Query();
        model.addAttribute("query", query);
        return "index";
    }

    @RequestMapping(value = "/generated", method = RequestMethod.POST)
    public String generate(@ModelAttribute("query") Query query, Model model) throws IOException, InterruptedException {
        Lyrics lyrics = new Lyrics();
        lyrics.setLyrics(lyricsService.fetchLyrics(query.getQuery()));
        model.addAttribute("lyrics", lyrics);
        return "image";
    }

}
