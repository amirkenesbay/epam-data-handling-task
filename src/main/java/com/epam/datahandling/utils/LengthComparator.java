package com.epam.datahandling.utils;

import com.epam.datahandling.lexis.Sentence;

import java.io.Serializable;
import java.util.Comparator;

public class LengthComparator implements Comparator<Sentence>, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Sentence firstSentence, Sentence secondSentence) {
        return Integer.compare(firstSentence.getWords().length, secondSentence.getWords().length);
    }
}
