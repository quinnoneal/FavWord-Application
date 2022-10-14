package io.favword;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import core.GLA;
import io.favword.lyricformatter.LyricFormatter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class FavWordGeneratorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FavWordGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// genius api

		/*
		// todo create a collection of common words to filter out
		final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
		frequencyAnalyzer.setWordFrequenciesToReturn(200);
		frequencyAnalyzer.setMinWordLength(4);
		final ArrayList<WordFrequency> wordFrequencies = (ArrayList<WordFrequency>) frequencyAnalyzer.load(Arrays.asList(list));
		final Dimension dimension = new Dimension(600, 600);
		final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
		wordCloud.setPadding(2);
		wordCloud.setBackground(new CircleBackground(300));
		// colors followed by and steps between
		wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
		wordCloud.setFontScalar( new SqrtFontScalar(15, 50));
		wordCloud.build(wordFrequencies);
		wordCloud.writeToFile("/Users/quinnoneal/Documents/datarank_wordcloud_circle_sqrt_font.png");
		*/

	}
}
