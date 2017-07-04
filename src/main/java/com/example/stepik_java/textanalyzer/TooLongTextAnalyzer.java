package com.example.stepik_java.textanalyzer;

class TooLongTextAnalyzer implements TextAnalyzer {

    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() > this.maxLength ? Label.TOO_LONG : Label.OK;
    }
}
