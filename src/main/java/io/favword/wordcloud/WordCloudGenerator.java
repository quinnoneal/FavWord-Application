package io.favword.wordcloud;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WordCloudGenerator {
    private static final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
    private static final int WORD_FREQUENCIES = 200;
    private static final int MIN_WORD_LENGTH = 4;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int RADIUS = 300;

    public static void generateImage(ArrayList<String> words) {
        frequencyAnalyzer.setWordFrequenciesToReturn(WORD_FREQUENCIES);
        frequencyAnalyzer.setMinWordLength(MIN_WORD_LENGTH);
        String[] list = words.toArray(new String[0]);
        final ArrayList<WordFrequency> wordFrequencies = (ArrayList<WordFrequency>) frequencyAnalyzer.load(Arrays.asList(list));
        final Dimension dimension = new Dimension(WIDTH, HEIGHT);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(RADIUS));
        // colors followed by and steps between
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setFontScalar( new SqrtFontScalar(15, 50));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("/Users/quinnoneal/SpringApps/favword-generator/src/favword_wordcloud.png");
    }
}
