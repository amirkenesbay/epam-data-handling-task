package com.epam.datahandling.utils;

import com.epam.datahandling.lexis.Text;
import com.epam.datahandling.lexis.Word;

/**
 * Utility class creating table by input data
 */
public class TableGenerator {
    private static final String LINE_BREAK = "\n";
    private static final String SPACE = " ";
    private static final String FORWARD_SLASH = "|";
    private static final int FIND_MIDDLE = 2;
    private static final int NUMBER_OF_DIGIT_IN_NUMBER = 9;
    private static final String WORD_SPLIT_REGULAR_EXPRESSION = "wordSplit";
    private static final String SIGN_EQUAL = "=";
    private static final String SIGN_NUMBER = "№";
    private static final String SIGN_DASH = "-";
    private static final String NAME_COLUMN_SENTENCES = "Sentences";
    private static final String NAME_COLUMN_NUMBER_OF_WORDS = "Word's Count";

    private final int numberColumnWidth;
    private final int sentenceColumnWidth;
    private final int wordColumnWidth;

    public TableGenerator(int numberColumnWidth, int sentenceColumnWidth, int wordColumnWidth) {
        this.numberColumnWidth = numberColumnWidth;
        this.sentenceColumnWidth = sentenceColumnWidth;
        this.wordColumnWidth = wordColumnWidth;
    }

    public String generate(Text text, int maxDataLength) {
        StringBuilder table = new StringBuilder();
        return table.toString();
    }

    void generateTableContent(StringBuilder table, Text text, int maxDataLength) {
        for (int i = 1; i < text.getSentences().length + 1; i++) {

        }
    }

    void printWordColumnWidthPartOne(Text text, StringBuilder table, int i){
        for (int j = 0; j < wordColumnWidth - 1; j++) {
            if(j == wordColumnWidth / FIND_MIDDLE){
                table.append(text.getSentences()[i - 1].getWords().length);
            } else {
                table.append(SPACE);
            }
        }
    }

    void printWordColumnWidthPartTwo(Text text, StringBuilder table, int i){
        for (int j = 0; j < wordColumnWidth; j++) {
            if(j == wordColumnWidth / FIND_MIDDLE){
                table.append(text.getSentences()[i - 1].getWords().length);
            } else {
                table.append(SPACE);
            }
        }
    }

    void printSentenceColumnWidth(StringBuilder table, Text text, int i, int maxDataLength) {
        int differenceSymbol = sentenceColumnWidth - noPunctuationMarks(text, i, maxDataLength).length();
        StringBuilder sentenceNoPunctuationsMarks = noPunctuationMarks(text, i, maxDataLength);
        for (int j = 0; j < differenceSymbol; j++) {
            if (j == differenceSymbol / FIND_MIDDLE) {
                table.append(sentenceNoPunctuationsMarks);
            } else {
                table.append(SPACE);
            }
        }
    }

    public StringBuilder noPunctuationMarks(Text text, int i, int maxDataLength) {
        String[] wordOfSentence = text.getSentences()[i - 1].getContent().split(RegexProvider.get(WORD_SPLIT_REGULAR_EXPRESSION));
        StringBuilder returnedStringBuilder = new StringBuilder();
        int maxSentenceLength = makeStringWithWordsLength(text.getSentences()[i - 1].getWords(), maxDataLength);
        for (int j = 0; j < maxSentenceLength; j++) {
            returnedStringBuilder.append(wordOfSentence[j]).append(SPACE);
        }
        return returnedStringBuilder;
    }

    void printBorder(StringBuilder table) {
        table.append(LINE_BREAK);
        table.append(SIGN_DASH.repeat(Math.max(0, numberColumnWidth + sentenceColumnWidth + wordColumnWidth)));
    }

    void printHeading(StringBuilder table) {
        table.append(LINE_BREAK);
        printSplit(table);
        printHeadingNumberColumn(table);
        printHeadingSentenceColumn(table);
        printHeadingWordColumn(table);
        printSplit(table);
    }

    void printSplit(StringBuilder table) {
        table.append(SIGN_EQUAL.repeat(Math.max(0, numberColumnWidth + sentenceColumnWidth + wordColumnWidth)));
        table.append(LINE_BREAK);
    }

    void printHeadingNumberColumn(StringBuilder table) {
        String numberColumnName = SIGN_NUMBER;
        int differenceSymbolNumber = numberColumnWidth - numberColumnName.length();
        table.append(FORWARD_SLASH);
        for (int i = 0; i < differenceSymbolNumber; i++) {
            if (i == differenceSymbolNumber / FIND_MIDDLE) {
                table.append(numberColumnName).append(SPACE);
            } else {
                table.append(SPACE);
            }
        }
        table.append(FORWARD_SLASH);
    }

    void printHeadingSentenceColumn(StringBuilder table) {
        String sentenceColumnName = NAME_COLUMN_SENTENCES;
        int differenceSymbolSentence = sentenceColumnWidth - sentenceColumnName.length();
        for (int i = 0; i < differenceSymbolSentence; i++) {
            if (i == differenceSymbolSentence / FIND_MIDDLE) {
                table.append(sentenceColumnName);
            } else {
                table.append(SPACE);
            }
        }
        table.append(FORWARD_SLASH);
    }

    void printHeadingWordColumn(StringBuilder table) {
        String wordColumnName = NAME_COLUMN_NUMBER_OF_WORDS;
        int differenceSymbolWord = wordColumnWidth - wordColumnName.length();
        for (int i = 0; i < differenceSymbolWord; i++) {
            if (i == differenceSymbolWord / FIND_MIDDLE) {
                table.append(wordColumnName);
            } else {
                table.append(SPACE);
            }
        }
        table.append(FORWARD_SLASH);
        table.append(LINE_BREAK);
    }

    public int makeStringWithWordsLength(Word[] words, int maxDataLength) {
        StringBuilder builder = new StringBuilder();
        int maxSentenceLength = 0;
        for (Word word : words) {
            builder.append(word.getContent());
            if (builder.length() > maxDataLength) {
                break;
            }
            maxSentenceLength++;
        }
        return maxSentenceLength;
    }
}
