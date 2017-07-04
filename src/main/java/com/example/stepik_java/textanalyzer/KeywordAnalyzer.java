package com.example.stepik_java.textanalyzer;

abstract class KeywordAnalyzer implements TextAnalyzer {

    @Override
    public Label processText(String text) {
        for (String s : this.getKeywords()) {
            if (text.contains(s)) {
                return this.getLabel();
            }
        }
        return Label.OK;
    }

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();
}
