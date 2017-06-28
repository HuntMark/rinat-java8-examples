package com.example.stepik_java;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {

    private byte[] chars;

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars;
    }

    @Override
    public int length() {
        return this.chars.length;
    }

    @Override
    public char charAt(int index) {
        return (char) this.chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.chars, start, end));
    }

    @Override
    public String toString() {
        return new String(this.chars);
    }
}
