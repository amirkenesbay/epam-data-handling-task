package com.epam.datahandling.lexis;

import com.epam.datahandling.utils.RegexProvider;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sentence is a sequence of characters separated by ".", "!", "?" and new line characters
 */
public class Sentence {
    private static final String WORD_REGULAR_EXPRESSION = "word";

    private final String content;

    public Sentence(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(content, sentence.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public Word[] getWords() {
        Word[] words;
        Pattern pattern = Pattern.compile(RegexProvider.get(WORD_REGULAR_EXPRESSION));
        Matcher matcher = pattern.matcher(content);
        words = new Word[0];
        while (matcher.find()) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = new Word(content.substring(matcher.start(), matcher.end()));
        }
        return words;
    }

}
