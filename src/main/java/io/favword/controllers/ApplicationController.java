package io.favword.controllers;

import io.favword.Query;
import io.favword.lyricformatter.LyricFormatter;
import io.favword.services.LyricsService;
import io.favword.wordcloud.WordCloudGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class ApplicationController {
    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public String takeInRequest(Model model) throws IOException {
        // generate favword cloud
        Query query = new Query();
        model.addAttribute("query", query);
        return "index";
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public String generate(@ModelAttribute("query") Query query) throws IOException {
        WordCloudGenerator.generateImage(lyricsService.fetchLyrics(query.getQuery()));
        return "image";
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getImage() throws IOException {
        InputStream in = getClass().getResourceAsStream("/Users/quinnoneal/SpringApps/favword-generator/src/favword_wordcloud.png");
        return IOUtils.toByteArray(in);
    }
}
