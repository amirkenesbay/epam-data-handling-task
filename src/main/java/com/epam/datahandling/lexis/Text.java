package com.epam.datahandling.lexis;

import com.epam.datahandling.utils.RegexProvider;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Text to be parsed
 */
public class Text {

    private String content;
    private static final String SENTENCE_REGULAR_EXPRESSION = "sentences";

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Sentence[] getSentences() {
        Pattern pattern = Pattern.compile(RegexProvider.get(SENTENCE_REGULAR_EXPRESSION));
        Matcher matcher = pattern.matcher(content);
        Sentence[] sentences = new Sentence[0];
        while (matcher.find()) {
            sentences = Arrays.copyOf(sentences, sentences.length + 1);
            sentences[sentences.length - 1] = new Sentence(content.substring(matcher.start(), matcher.end()));
        }
        return sentences;
    }
}
