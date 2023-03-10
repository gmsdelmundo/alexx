package com.alexx.length.model;

import com.alexx.arithmetic.AdjustNumberByOneFactory;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class StringLengthCounter implements LengthCounter {

    private static final AdjustNumberByOneFactory ADJUST_NUMBER_BY_ONE_FACTORY = new AdjustNumberByOneFactory();

    private final String str;

    public StringLengthCounter(String str) {
        this.str = str;
    }

    @Override
    public long getLength() {
        int length = 0;
        final CharacterIterator it = new StringCharacterIterator(str);

        for (char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            length = (int) ADJUST_NUMBER_BY_ONE_FACTORY.createAdjustNumberByOne(length).increment();
        }

        return length;
    }

}
